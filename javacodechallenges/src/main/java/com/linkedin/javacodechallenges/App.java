package com.linkedin.javacodechallenges;

import java.util.List;

public class App {

    public static double calculateAverageChangeInvested(List<Double> purchases) {
        /* 
        double total = 0.0;
        double average = 0.0;
        if(!purchases.isEmpty()) {
            for(Double purchase : purchases) {
                total += Math.ceil(purchase) - purchase;
            }
            average = total / purchases.size();
        }

        return average;
        */

        return purchases.stream()
                .mapToDouble(purchase -> Math.ceil(purchase) - purchase)
                .average().orElse(0);
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
