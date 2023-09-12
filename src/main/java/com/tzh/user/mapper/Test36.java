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
        check36(72);
    }

    public static void check36(Integer sumMonth){
        Integer year1 = 12;
        Integer year2 = 24;
        Integer year3 = 36;

        Double rate1=1.0175;
        Double rate2=1.022;
        Double rate3=1.0226;

        Double monthMoney=1000d;
        //总投入，5年
        double monthMoneySum= 3000d * sumMonth;
        //总收入
        Double moneyYearSum = 0d;
        //第一期
        Map<Integer, Double> moneyYearSum1 = getMoneyYearSum(year1, monthMoney, rate1);

        Map<Integer, Double> moneyYearSum2 = getMoneyYearSum(year2, monthMoney, rate2);
        Map<Integer, Double> moneyYearSum3 = getMoneyYearSum(year3, monthMoney, rate3);
        int oneEnd = sumMonth / 12;
        int twoEnd = sumMonth / 24;
        int thirdEnd = sumMonth / 36;
        //一年利息的,按6年算
        List<Map<Integer, Double>> oneYear = showMoney(oneEnd,year1, rate1, moneyYearSum1);
        //两年利息的,按6年算
        List<Map<Integer, Double>> twoYear = showMoney(twoEnd,year2, rate2, moneyYearSum2);
        //两年利息的,按6年算
        List<Map<Integer, Double>> thirdYear = showMoney(thirdEnd,year3, rate3, moneyYearSum3);
        List<Map<Integer,Double>> allList = new ArrayList<>();
        allList.addAll(oneYear);
        allList.addAll(twoYear);
        allList.addAll(thirdYear);
        System.out.println(allList);

        for (int i = 0; i < allList.size(); i++) {
            Map<Integer, Double> map = allList.get(i);
            for (Integer key: map.keySet()){
                Double aDouble = map.get(key);
                System.out.println(aDouble);
                moneyYearSum = moneyYearSum + aDouble;
            }
        }
        System.out.println("总投入"+monthMoneySum);
        System.out.println("5年连本带利共计"+moneyYearSum);
        double sum = moneyYearSum-monthMoneySum;
        System.out.println("5年获得的利息共计"+sum);

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
        System.out.println(twoYearList);
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
