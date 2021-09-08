package com.example.spring.business;

import com.example.spring.event.EventPublisher;
import com.example.spring.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
