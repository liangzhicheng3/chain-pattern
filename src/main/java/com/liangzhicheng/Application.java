package com.liangzhicheng;

import com.liangzhicheng.modules.service.IHandler;
import com.liangzhicheng.modules.service.impl.Diamond270DrawFivePrizesImpl;
import com.liangzhicheng.modules.service.impl.Diamond60DrawAPrizeImpl;
import com.liangzhicheng.modules.service.impl.RareCrystalOfKingsImpl;

public class Application {

    private IHandler diamond60, diamond270, rareDiamond; //责任链上的对象

    public void createChain(){ //建立责任链
        diamond60 = new Diamond60DrawAPrizeImpl();
        diamond270 = new Diamond270DrawFivePrizesImpl();
        rareDiamond = new RareCrystalOfKingsImpl();
        diamond60.setNextHandler(diamond270);
        diamond270.setNextHandler(rareDiamond);
    }

    public void responseClient(int number){ //响应用户的请求
        diamond60.handleRequest(number);
    }

    public static void main(String args[]){
        Application application = new Application();
        application.createChain();

//        System.out.println("当点击“60钻石”抽一次时：");
//        System.out.println("当点击“270钻石”抽五次时：");
        System.out.println("当钻石抽奖“幸运值达201时”：");
        System.out.print("[购买成功]");
        application.responseClient(201);

    }

}
