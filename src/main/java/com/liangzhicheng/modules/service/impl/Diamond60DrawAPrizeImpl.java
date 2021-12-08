package com.liangzhicheng.modules.service.impl;

import com.liangzhicheng.modules.service.IHandler;

/*
 * 角色2.1：
 *         具体处理者：具体处理者是实现处理者接口的类的实例
 *                    具体处理者通过调用处理者接口规定的方法，处理用户的请求
 *                    即在接到用户的请求后，处理者将调用接口规定的方法，在执行该方法的过程中
 *                    如果发现能处理用户的请求，就处理有关数据
 *                    否则就反馈无法处理的信息给用户，然后将用户的请求传递给自己的后继对象
 */
public class Diamond60DrawAPrizeImpl implements IHandler {

    private IHandler handler;

    @Override
    public void handleRequest(int number) {
        if(number == 60){ //60钻石抽一次
            String random = "";
            String[] doc = {
                    "白起", "夏侯惇", "甄姬",
                    "金币288","小喇叭5","铭文碎片1600",
                    "铭文碎片400","铭文碎片100", "铭文碎片25",
                    "爱心气球（3日）", "亲密玫瑰","钻石48","龙域领主体验卡"};
            int index = (int) (Math.random() * doc.length); //随机选取其一输出
            random = doc[index];
            System.out.println(random);
        }else{
            handler.handleRequest(number); //将请求传递给下一个处理者
        }
    }

    @Override
    public void setNextHandler(IHandler handler) {
        this.handler = handler;
    }

}
