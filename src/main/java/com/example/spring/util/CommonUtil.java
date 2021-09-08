package com.example.spring.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Cheng
 * @date 2021-09-03-17:08
 */
public class CommonUtil {
    //判断字符串是否包含特殊字符
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 判断一个空字符串（null或者""）
     *
     * @param s 待判断的字符串
     * @return 判断结果
     */
    public static boolean isNullStr(Object s) {
        return s == null || s.toString().trim().length() <= 0;
    }

    public static boolean isNotNullStr(Object s) {
        return !isNullStr(s);
    }

    /**
     * 由一个对象返回非空的字符串
     *
     * @param o 传入的对象
     * @return 生成的字符串
     */
    public static String nonNullStr(Object o) {
        return nonNullStr(o, "");
    }

    //
    public static String nonNullStr(Object o, String def) {
        String s = o == null ? def : o.toString();
        if (s == null) {
            s = "";
        }
        if (s.equalsIgnoreCase("null") || s.length() == 0) {
            s = def;
        }
        return s;
    }

    public static boolean isNotNullOrEmpty(String string) {
        return !isNullOrEmpty(string);
    }

    public static boolean isNotNullOrEmpty(Object[] strArr) {
        return !isNullOrEmpty(strArr);
    }

    public static boolean isNotNullOrEmpty(List list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNotNullOrEmpty(Map map) {
        return !isNullOrEmpty(map);
    }


    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.equals("") || string.equals("null") || string.equals("undefined");
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof Map) {//map类
            return isNullOrEmpty((Map) obj);
        } else if (obj instanceof Collection) {//列表
            return isNullOrEmpty((Collection) obj);
        } else if (obj.getClass().isArray()) {//数组类
            return isNullOrEmpty((Object[]) obj);
        } else {//其他应该都是字符串
            return isNullOrEmpty(obj.toString());
        }
    }

    public static boolean isNotNullOrEmpty(Object obj) {
        return !isNullOrEmpty(obj);
    }

    /**
     * 移除map中的空值
     * @param map
     * @return
     * @throws Exception
     */
    public static Map<String, Object> removeNullField(Map<String, Object> map) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public static List<String> getKeys(List<Map<String, Object>> dataSelected, String keyField) throws Exception {
        List<String> keyList = new ArrayList<String>();
        for (int i = 0, size = dataSelected.size(); i < size; i++) {
            keyList.add(nonNullStr(dataSelected.get(i).get(keyField)));
        }
        return keyList;
    }

    /**
     * 构建树形结构
     */
    public static List buildTreeDatas(List list, String parentId) throws Exception {
        if (isNullOrEmpty(list)) {
            return list;
        }
        if (list.size() == 1) {
            Map<String, Object> m = (Map<String, Object>) list.get(0);
            m.put("isleaf", "1");
            return list;
        }
        int size = list.size();
        Map<String, Integer> guidPos = new HashMap<String, Integer>();
        Map<String, List<Map<String, Object>>> superMap = new LinkedHashMap<String, List<Map<String, Object>>>();
        String guid = null, superguid = null;
        List<Map<String, Object>> childList = null;
        Map<String, Object> m = null;
        for (int i = 0; i < size; i++) {
            m = (Map<String, Object>) list.get(i);
            //默认都是底级
            m.put("isleaf", "1");
            guid = nonNullStr(m.get("guid"));
            superguid = nonNullStr(m.get("superguid"), "0");//空默认处理为0
            guidPos.put(guid, i);//记录guid位置
            if (superMap.containsKey(superguid)) {//此父级已有子集集合
                childList = superMap.get(superguid);
            } else {
                childList = new ArrayList<Map<String, Object>>();
                superMap.put(superguid, childList);
            }
            childList.add(m);
        }
        Set<String> keySet = superMap.keySet();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (String key : keySet) {//遍历父级
            if (guidPos.containsKey(key)) {//superguid对应到了list中的一个
                m = (Map<String, Object>) list.get(guidPos.get(key));//获取父级节点
                m.put("isleaf", "0");
                m.put("children", superMap.get(key));//放置子节点
            } else { //但这个父级节点可能不存在当前list中，则此key对应的list的都是顶级节点
                result.addAll(superMap.get(key));
            }
        }
        return result;
    }
}
