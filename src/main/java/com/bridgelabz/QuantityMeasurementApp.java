/**
 * QuantityMeasurementApp -UC10: Generic Quantity Class with Unit Interface for Multi-Category Support
 * UC10 addresses the architectural and design disadvantages introduced
 * by UC9 by refactoring the design into a single, generic Quantity
 * class that works with any measurement category through a common
 * IMeasurable interface. This use case eliminates code duplication
 * across parallel QuantityLength and QuantityWeight classes,
 * consolidates unit enum patterns, and simplifies the
 * QuantityMeasurementApp class to adhere to the Single Responsibility Principle.
 */

package com.bridgelabz;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> quantity1, Quantity<U> quantity2) {
        if (quantity1.equals(quantity2)) {
            System.out.println("Equal(True)");
            return true;
        } else {
            System.out.println("Not Equal(False)");
            return false;
        }
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit) {
        double resultQuantity = quantity.convertTo(targetUnit);
        return new Quantity<U>(resultQuantity, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2) {
        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {
        return quantity1.add(quantity2, targetUnit);
    }

    public static void main(String[] args) {
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000, WeightUnit.GRAM);
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        boolean areEqual = demonstrateEquality(weightInGrams, weightInKilograms);
        System.out.println("Are weights equal? " + areEqual);

        Quantity<WeightUnit> convertedWeight = demonstrateConversion(weightInGrams, WeightUnit.KILOGRAM);
        System.out.println("Converted Weight: " + convertedWeight.getValue() + " " + convertedWeight.getUnit());

        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.204, WeightUnit.POUND);
        Quantity<WeightUnit> sumWeight = demonstrateAddition(weightInKilograms, weightInPounds);
        System.out.println("Sum Weight: " + sumWeight.getValue() + " " + sumWeight.getUnit());

        Quantity<WeightUnit> sumWeightInGrams = demonstrateAddition(weightInKilograms, weightInPounds, WeightUnit.GRAM);
        System.out.println("Sum Weight in Grams: " + sumWeightInGrams.getValue() + " " + sumWeightInGrams.getUnit());
    }
}