package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-16:52
 */
public interface HandleAdapter {

    public boolean supports(Object handle);

    public void handle(Object handle);
}

class HttpHandleAdapter implements HandleAdapter {

    @Override
    public boolean supports(Object handle) {
        return (handle instanceof HttpController);
    }

    @Override
    public void handle(Object handle) {
        ((HttpController)handle).doHttpHandle();
    }
}

class SimpleHandleAdapter implements HandleAdapter {

    @Override
    public boolean supports(Object handle) {
        return (handle instanceof SimpleController);
    }

    @Override
    public void handle(Object handle) {
        ((SimpleController)handle).doSimpleHandle();
    }
}

class AnnotationHandleAdapter implements HandleAdapter {

    @Override
    public boolean supports(Object handle) {
        return (handle instanceof AnnotationController);
    }

    @Override
    public void handle(Object handle) {
        ((AnnotationController)handle).doAnnotationHandle();
    }
}
