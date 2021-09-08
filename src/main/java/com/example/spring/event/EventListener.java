package com.example.spring.event;


import com.example.spring.factory.BeanFactory;
import com.example.spring.util.CommonUtil;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author Cheng
 * @date 2021-03-10-12:40
 */
@Component
@EnableAsync
public class EventListener implements ApplicationListener<MyEvent> {

    /**
     * define a global Logger object
     */
    private static Logger logger = LoggerFactory.getLogger(EventListener.class);



    @SneakyThrows
    @Override
    @Async
    public void onApplicationEvent(MyEvent event) {
        String type = event.getType();
        Map<String,Object> param = event.getParam();
        if("002".equals(type)){
            String methodName = CommonUtil.nonNullStr(param.get("threadfunc"));
            //根据类名从bean工厂获取类
            Object bean = BeanFactory.getBean(CommonUtil.nonNullStr(param.get("threadclassName")));
            Method Method = bean.getClass().getMethod(methodName, List.class, Map.class);
            //执行实际方法,注:因没做暴力反射,所以方式需为public修饰
            Method.invoke(bean,param);
        }
        logger.info("事件发布成功！");
    }
}
