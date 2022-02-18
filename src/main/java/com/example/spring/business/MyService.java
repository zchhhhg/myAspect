package com.example.spring.business;

import com.example.spring.event.EventPublisher;
import com.example.spring.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.DatabaseMetaData;

/**
 * @author Cheng
 * @date 2021-09-08-10:32
 */
@Service
public class MyService implements IService {

    /**
     * define a global Logger object
     */
    private static Logger logger = LoggerFactory.getLogger(MyService.class);

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.driver-class-name}")
    public String driverClass;

    /**
     * 由BUSI_CODE关联的配置表，置于字符串数组中方便批量操作
     */
    private static String[] tables = {"OPP_BUSI_DEF","OPP_BUSI_ACS_CFG","OPP_BUSI_TRANS_CONF","OPP_PROC_POST_CFG","OPP_BUSI_REVIEW_NODE"};

    /**
     * sql注释
     */
    private HashMap<String,String> messages = new HashMap<>();

    @Override
    public void getCache() {
        String result = getCacheResult();
        logger.debug(result);
        logger.info("测算项目【{}】明细中部门经济分类【{}】的测算金额【{}】元","我的项目","0503-公用经费","123");
        logger.warn(result);
        logger.error(result);
    }

    public String getCacheResult(){
        return "cache result";
    }

    @Override
    public void publishEvent(){
        Map<String,Object> param = new HashMap<>();
        param.put("message", "233333");
        eventPublisher.publish(param, "001");
        logger.info("我在事件发布之后");
    }
    @Override
    public void generateSqlScript(String MENU_ID) throws Exception {
        Map<String, Object> menuInfo = jdbcTemplate.queryForMap("SELECT * FROM UPM_MENU WHERE MENU_ID="+MENU_ID);
        if(CommonUtil.isNullOrEmpty(menuInfo)){
            throw new Exception("菜单信息不存在!!!");
        }
        String MENU_NAME = CommonUtil.nonNullStr(menuInfo.get("MENU_NAME"));
        messages.put("UPM_MENU","-- 新增【XX】菜单");
        messages.put("OPP_BUSI_DEF","-- 新增【XX】菜单业务基本设置");
        messages.put("OPP_BUSI_ACS_CFG","-- 业务【XX】新增业务准入配置");
        messages.put("OPP_PROC_POST_CFG","-- 新增【XX】菜单业务流程模板设置");
        messages.put("OPP_BUSI_TRANS_CONF","-- 新增【XX】菜单业务任务配置");
        messages.put("OPP_BUSI_REVIEW_NODE","-- 新增【XX】菜单业务审核模块配置");
        messages.put("OPP_BUSI_ACS_COND","-- 新增【XX】的准入条件【CON_ID-CON_NAME】");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateScript("UPM_MENU", MENU_ID, MENU_NAME, null, null));
        if(CommonUtil.isNotNullOrEmpty(menuInfo.get("BUSI_CODE"))){
            String BUSI_CODE = CommonUtil.nonNullStr(menuInfo.get("BUSI_CODE"));
            List<Map<String, Object>> checkList = jdbcTemplate.queryForList("SELECT * FROM OPP_BUSI_ACS_CFG WHERE BUSI_CODE='"+BUSI_CODE+"'");
            if(CommonUtil.isNotNullOrEmpty(checkList)){
                checkList.forEach(e->{
                    String CON_ID = CommonUtil.nonNullStr(e.get("CON_ID"));
                    try {
                        stringBuilder.append(generateScript("OPP_BUSI_ACS_COND", MENU_ID, MENU_NAME,null,CON_ID));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
            for(int j = 0; j< tables.length; j++) {
                String tableName = tables[j];
                stringBuilder.append(generateScript(tableName, MENU_ID, MENU_NAME, BUSI_CODE, null));
            }
        }
        System.out.println(stringBuilder);
        writeToTxtFile(stringBuilder);
    }

    private StringBuilder generateScript(String tableName,String MENU_ID,String MENU_NAME,String BUSI_CODE,String CON_ID) throws IOException {
        String whereStr = " WHERE MENU_ID=" + MENU_ID;
        if(CommonUtil.isNotNullOrEmpty(BUSI_CODE)){
            whereStr = " WHERE BUSI_CODE='" + BUSI_CODE + "'";
        }
        if(CommonUtil.isNotNullOrEmpty(CON_ID)){
            whereStr = " WHERE CON_ID=" + CON_ID;
        }
        List<Map<String, Object>> dataList = jdbcTemplate.queryForList("SELECT * FROM " + tableName + whereStr);
        if (CommonUtil.isNotNullOrEmpty(dataList)) {
            String message = messages.get(tableName).replace("XX", MENU_NAME);
            if(CommonUtil.isNotNullOrEmpty(dataList.get(0).get("CON_ID"))){
                message = message.replace("CON_ID",CommonUtil.nonNullStr(dataList.get(0).get("CON_ID"))).replace("CON_NAME", CommonUtil.nonNullStr(dataList.get(0).get("CON_NAME")));
            }
            StringBuilder sb = new StringBuilder(message);
            sb.append("\nDELETE FROM ").append(tableName).append(whereStr).append(";\n");
            List<Map<String, Object>> columnList = new ArrayList<>();
            if(isSqlServer()){
                columnList = jdbcTemplate.queryForList("SELECT ColumnName = Columns.name ,ColumnType = Types.name FROM sys.tables AS Tables INNER JOIN sys.columns AS Columns ON Tables.object_id = Columns.object_id INNER JOIN sys.types AS Types ON Columns.system_type_id = Types.system_type_id AND is_user_defined = 0 AND Types.name <> 'sysname' WHERE Tables.name = '" + tableName + "' ORDER BY Columns.column_id");
            }else {
                columnList = jdbcTemplate.queryForList("select a.column_name ColumnName,a.data_type ColumnType from user_tab_columns a where a.table_name='"+ tableName +"' order by a.table_name, a.column_id");
            }
            for (int k = 0; k < dataList.size(); k++) {
                Map<String, Object> map = dataList.get(k);
                StringBuilder fieldSb = new StringBuilder("INSERT INTO " + tableName + " (");
                StringBuilder valueSb = new StringBuilder(" VALUES (");
                for (int i = 0; i < columnList.size(); i++) {
                    String columnName = CommonUtil.nonNullStr(columnList.get(i).get("ColumnName"));
                    String columnType = CommonUtil.nonNullStr(columnList.get(i).get("ColumnType")).toLowerCase();
                    fieldSb.append(columnName).append(",");
                    if (CommonUtil.isNullOrEmpty(map.get(columnName))) { // 若当前field值为空，value直接给空串
                        valueSb.append("'',");
                        continue;
                    }
                    if(isSqlServer()) {
                        if ("int".equals(columnType) || "numeric".equals(columnType)) { // 整型及数字型的值拼接时不加字符串
                            valueSb.append(map.get(columnName)).append(",");
                        } else if ("datetime".equals(columnType)) {
                            valueSb.append("GETDATE(),");
                        } else {
                            valueSb.append("'").append(map.get(columnName)).append("',");
                        }
                    }else {
                        if ("number".equals(columnType)) {
                            valueSb.append(map.get(columnName)).append(",");
                        } else if ("date".equals(columnType)) {
                            valueSb.append("sysdate,");
                        } else {
                            valueSb.append("'").append(map.get(columnName)).append("',");
                        }
                    }
                }
                fieldSb.replace(fieldSb.length() - 1, fieldSb.length(), ")");
                valueSb.replace(valueSb.length() - 1, valueSb.length(), ")");
                sb.append(fieldSb).append(valueSb).append(";\n");
            }
            return sb.append("\n");
        }
        return new StringBuilder();
    }
    private void writeToTxtFile(StringBuilder sb) throws IOException {
        String filenameTemp = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()+File.separator+(isSqlServer()?"msqlscript.sql":"oraclescript.sql");
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
        }
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(filenameTemp);
            StringBuffer buf = new StringBuffer();
            buf.append(sb.toString());
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename),"GB2312")));
            pw.write(buf.toString().toCharArray());
            pw.flush();
        } catch (IOException e1) {
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private boolean isSqlServer(){
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver".equals(driverClass);
    }
}
