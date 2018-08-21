package com.gxy.proxy;/*
 * Created by GXY on 2018/8/21
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Client {


    public Object returnProxy(Object clazz) {
        ProxyFactory proxyFactory = new ProxyFactory(clazz);
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(clazz, args);
                return invoke;
            }
        };
        Object instance = proxyFactory.getProxyInstance(handler);
        return instance;
    }


    public static void main(String[] args) {

        Eat proxy = (Eat) new Client().returnProxy(new PeopleEat());
        proxy.eatFood("pig");
        proxy.getFood("aaaa");
        proxy.pullFood("adad");
    }
}
