package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.math.BigDecimal;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        // TODO: Implement method
        double gallonPerCCF = 748;
        double minGallonForTwoCCFs = 2 * 748;
        BigDecimal minChargeForTwoCCFs = new BigDecimal(18.84);
        BigDecimal chargeForAddCCF = new BigDecimal(3.90);
        BigDecimal finalCharge = minChargeForTwoCCFs;

        if (gallonsUsage > minGallonForTwoCCFs) {
            double extraGallonsUsage = gallonsUsage - minGallonForTwoCCFs;
            double totalCCFUsage = Math.ceil(extraGallonsUsage / gallonPerCCF);
            finalCharge = minChargeForTwoCCFs.add(chargeForAddCCF.multiply(new BigDecimal(totalCCFUsage)));
        }

        return finalCharge.doubleValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
