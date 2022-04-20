package com.example.spring.designPattern.structural.adapterPattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoucheng
 * @description 以后如果要扩展新功能的时候只需要增加新的controller和adapter而不需要改变已有代码
 * @date 2022-04-01-16:51
 */
public class DispatchServlet {

    public static List<HandleAdapter> handleAdapters = new ArrayList<>();

    public DispatchServlet() {
        handleAdapters.add(new HttpHandleAdapter());
        handleAdapters.add(new SimpleHandleAdapter());
        handleAdapters.add(new AnnotationHandleAdapter());
    }

    @Test
    public void doDispatch(){
        HttpController controller = new HttpController();
        SimpleController controller1 = new SimpleController();
        getHandle(controller1).handle(controller1);
    }
    public HandleAdapter getHandle(Controller controller){
        HandleAdapter hander = null;
        for (int i = 0; i < handleAdapters.size(); i++) {
            if(handleAdapters.get(i).supports(controller)){
                hander = handleAdapters.get(i);
                break;
            }
        }
        return hander;
    }
}
