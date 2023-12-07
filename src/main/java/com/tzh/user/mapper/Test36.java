package com.tzh.user.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-09-13 00:45
 * @Description: 验证36存钱法
 */
public class Test36 {
    public static void main(String[] args) {
        check36(72,1000d,1000d,1000d);
    }

    public static void check36(Integer sumMonth,Double oneYearMoney,Double twoYearMoney,Double thirdYearMoney){
        Integer year1 = 12;
        Integer year2 = 24;
        Integer year3 = 36;

        Double rate1=1.0175;
        Double rate2=1.022;
        Double rate3=1.0226;

        int oneEnd = sumMonth / 12;
        int twoEnd = sumMonth / 24;
        int thirdEnd = sumMonth / 36;

        //总投入，5年
        double monthMoneySum= (oneYearMoney+twoYearMoney+thirdYearMoney) * sumMonth;
        //12期投入总和
        double oneYearMoneySum = oneYearMoney * sumMonth;

        double twoYearMoneySum = twoYearMoney * sumMonth;

        double thirdYearMoneySum = thirdYearMoney * sumMonth;
        //总收入
        Double moneyYearSum = 0d;
        //第一期
        Map<Integer, Double> moneyYearSum1 = getMoneyYearSum(year1, oneYearMoney, rate1);

        Map<Integer, Double> moneyYearSum2 = getMoneyYearSum(year2, twoYearMoney, rate2);
        Map<Integer, Double> moneyYearSum3 = getMoneyYearSum(year3, thirdYearMoney, rate3);

        //一年利息的,按6年算
        List<Map<Integer, Double>> oneYear = showMoney(oneEnd,year1, rate1, moneyYearSum1);
        Double oneMoneySum = everyOne(oneYear);
        System.out.println("12期总投入"+oneYearMoneySum);
        System.out.println("12期，"+oneEnd+"年连本带利共计"+oneMoneySum);
        double oneSum = oneMoneySum-oneYearMoneySum;
        System.out.println("12期，"+oneEnd+"年获得的利息共计"+oneSum);

        List<Map<Integer, Double>> twoYear = showMoney(twoEnd,year2, rate2, moneyYearSum2);
        Double twoMoneySum = everyOne(twoYear);
        System.out.println("24期总投入"+twoMoneySum);
        System.out.println("24期，"+oneEnd+"年连本带利共计"+twoMoneySum);
        double twoSum = twoMoneySum-twoYearMoneySum;
        System.out.println("24期，"+oneEnd+"年获得的利息共计"+twoSum);

        List<Map<Integer, Double>> thirdYear = showMoney(thirdEnd,year3, rate3, moneyYearSum3);
        Double thirdMoneySum = everyOne(thirdYear);
        System.out.println("36期总投入"+thirdMoneySum);
        System.out.println("36期，"+oneEnd+"年连本带利共计"+thirdMoneySum);
        double thirdSum = thirdMoneySum-thirdYearMoneySum;
        System.out.println("36期，"+oneEnd+"年获得的利息共计"+thirdSum);

        List<Map<Integer,Double>> allList = new ArrayList<>();
        allList.addAll(oneYear);

        allList.addAll(twoYear);
        allList.addAll(thirdYear);
        // System.out.println(allList);
        //总和
        Double sumMoney = everyOne(allList);
        System.out.println(oneEnd+"年总投入"+monthMoneySum);
        System.out.println(oneEnd+"年连本带利共计"+sumMoney);
        double allSum = sumMoney-monthMoneySum;
        System.out.println(oneEnd+"年获得的利息共计"+allSum);

    }
    //每种存法各获利多少

    /**
     * 每种存单每月的本金+利息
     * @param list  存单列表
     * @return      此种存单最终得到的本金和
     */
    public static Double everyOne(List<Map<Integer,Double>> list){
        Double moneyYearSum = 0d;
        for (int i = 0; i < list.size(); i++) {
            Map<Integer, Double> map = list.get(i);
            for (Integer key: map.keySet()){
                Double aDouble = map.get(key);
                moneyYearSum = moneyYearSum + aDouble;
            }
        }
        return moneyYearSum;
    }
    private static List<Map<Integer,Double>> showMoney(Integer end,Integer year2, Double rate2, Map<Integer, Double> moneyYearSum2) {
        List<Map<Integer,Double>> twoYearList = new ArrayList<>();
//        twoYearList.add(moneyYearSum2);
        for (int i = 0; i < end; i++) {
            Map<Integer, Double> moneyYearSumMap = new HashMap<>();

            for (int j = 0; j < year2; j++) {
                if ( i == 0){
                    moneyYearSumMap.put(j,moneyYearSum2.get(j));
                } else {
                    Map<Integer, Double> map = twoYearList.get(i - 1);
                    double newMonth = (map.get(j) + 1000d) * rate2 ;
                    moneyYearSumMap.put(j,newMonth);
                }

            }
            twoYearList.add(moneyYearSumMap);
        }
        // System.out.println(twoYearList);
        return twoYearList;
    }

    public static Map<Integer,Double> getMoneyYearSum(Integer year, Double monthMoney, Double rate) {
        Map<Integer,Double> map = new HashMap<>();
        for (int i = 0; i < year; i++) {
            double month = monthMoney * rate;
            map.put(i,month);
        }
        return map;
    }
}
