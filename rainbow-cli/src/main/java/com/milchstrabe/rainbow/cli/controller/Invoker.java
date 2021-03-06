package com.milchstrabe.rainbow.cli.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ch3ng
 * @Date 2020/4/20 23:10
 * @Version 1.0
 * @Description
 **/
public class Invoker {

    private Method method;
    private Object target;


    public static Invoker valueOf(Method method,Object target){
        Invoker invoker = new Invoker();
        invoker.setMethod(method);
        invoker.setTarget(target);
        return invoker;
    }

    public Object invoke(Object... paramters){
        try {
           return method.invoke(target,paramters);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
