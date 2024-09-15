package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String details = "\n---------------零钱通明细---------------";

        double money = 0;
        double balance = 0;
        Date date = null;
        do{
            System.out.println("===============零钱通菜单===============");
            System.out.println("\t\t\t" + "1 零钱通明细");
            System.out.println("\t\t\t" + "2 收益入账");
            System.out.println("\t\t\t" + "3 消费");
            System.out.println("\t\t\t" + "4 退     出");

            System.out.println("请选择(1~4)");
            String key = scanner.next();

            String note = "";

            //使用switch
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();

                    if(money <= 0){
                        System.out.println("收益入账金额需要大于0~");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t +" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("消费说明");
                    note = scanner.next();
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    if(balance < money){
                        System.out.println("你不能支付,超出余额~");
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
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
                        break;
                default:
                    System.out.println("你输入的字符不正确,没有匹配的");
            }
        }while (loop);

        System.out.println("-----退出了零钱通-----");
    }
}
