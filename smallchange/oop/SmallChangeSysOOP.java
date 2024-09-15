package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    //属性
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    String details = "\n---------------零钱通明细---------------";

    double money = 0;
    double balance = 0;
    Date date = null;

    String note = "";
    public void mainMenu(){
        do{
            System.out.println("\n===============零钱通菜单(OOP)===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1~4)");
            String key = scanner.next();
            //使用switch
            switch (key){
                case "1":
                    this.Detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
            }
        }while (loop);
    }
    public void Detail(){
        System.out.println(details);
    }
    public void income(){
        System.out.println("收益入账金额:");
        money = scanner.nextDouble();

        if(money <= 0){
            System.out.println("收益入账金额需要大于0~");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t +" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    public void pay(){
        System.out.println("消费说明");
        note = scanner.next();
        System.out.println("消费金额:");
        money = scanner.nextDouble();
        if(balance < money){
            System.out.println("你不能支付,超出余额~");
            return;
        }
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    public void exit(){
        String choice = "";
        do{
            System.out.println("你确定要退出吗?y/n");
            choice = scanner.next();
            if(choice.equals("y") || choice.equals("n")) {
                break;
            }
        }while (loop);
        if(choice.equals("y")){
            loop = false;
        }
    }
}
