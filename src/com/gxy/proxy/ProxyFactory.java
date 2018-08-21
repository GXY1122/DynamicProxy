package com.gxy.proxy;/*
 * Created by GXY on 2018/8/21
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("begin");
                System.out.println("args:" + String.valueOf(args[0]));
                Object value = method.invoke(target, args);
                System.out.println("end");
                return value;
            }
        });
    }

    public Object getProxyInstance(InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }
}
