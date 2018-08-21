package com.gxy.proxy;/*
 * Created by GXY on 2018/8/21
 */

public class PeopleEat implements Eat {
    @Override
    public void getFood(String food) {
        System.out.println("get "+food);
    }

    @Override
    public void eatFood(String food) {
        System.out.println("eat "+food);
    }

    @Override
    public void pullFood(String food) {
        System.out.println("pull "+food);
    }


}
