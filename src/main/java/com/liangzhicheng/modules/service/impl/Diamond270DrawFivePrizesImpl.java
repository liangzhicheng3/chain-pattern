package com.liangzhicheng.modules.service.impl;

import com.liangzhicheng.modules.service.IHandler;

/*
 * 角色2.2：
 *         具体处理者：具体处理者是实现处理者接口的类的实例
 *                    具体处理者通过调用处理者接口规定的方法，处理用户的请求
 *                    即在接到用户的请求后，处理者将调用接口规定的方法，在执行该方法的过程中
 *                    如果发现能处理用户的请求，就处理有关数据
 *                    否则就反馈无法处理的信息给用户，然后将用户的请求传递给自己的后继对象
 */
public class Diamond270DrawFivePrizesImpl implements IHandler {

    private IHandler handler; //存放当前处理者后继的Handler接口变量

    @Override
    public void handleRequest(int number) {
        if(number == 270){ //270钻石抽五次
            String random1, random2, random3, random4, random5 = "";
            String[] doc = {
                    "白起", "夏侯惇", "甄姬",
                    "金币288","小喇叭5","铭文碎片1600",
                    "铭文碎片400","铭文碎片100", "铭文碎片25",
                    "爱心气球（3日）", "亲密玫瑰","钻石48","龙域领主体验卡"};
            int index1 = (int) (Math.random() * doc.length); //随机选取其五输出
            random1 = doc[index1];
            System.out.print(random1 + "、");

            int index2 = (int) (Math.random() * doc.length);
            random2 = doc[index2];
            System.out.print(random2 + "、");

            int index3 = (int) (Math.random() * doc.length);
            random3 = doc[index3];
            System.out.print(random3 + "、");

            int index4 = (int) (Math.random() * doc.length);
            random4 = doc[index4];
            System.out.print(random4 + "、");

            int index5 = (int) (Math.random() * doc.length);
            random5 = doc[index5];
            System.out.println(random5);
        }else{
            handler.handleRequest(number); //将请求传递给下一个处理者
        }
    }

    @Override
    public void setNextHandler(IHandler handler) {
        this.handler = handler;
    }

}
