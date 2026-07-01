/**
 * QuantityMeasurementApp -UC9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)
 * UC9 extends the Quantity Measurement Application to support
 * weight measurements alongside length measurements.
 * This use case introduces a new measurement category—weight—that
 * operates independently of length. Similar to how length measurements
 * (feet, inches, yards, centimeters) are compared for equality,
 * converted between units, and added together, weight measurements in different units
 * (kilograms, grams, pounds) will support the same operations.
 */

package com.bridgelabz;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        if (length1.compare(length2)) {
            System.out.println("Equal(True)");
            return true;
        } else {
            System.out.println("Not Equal(False)");
            return false;
        }
    }

    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        return demonstrateLengthEquality(length1, length2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
        if (weight1.compare(weight2)) {
            System.out.println("Equal(True)");
            return true;
        } else {
            System.out.println("Not Equal(False)");
            return false;
        }
    }

    public static boolean demonstrateWeightComparison(double value1, WeightUnit unit1, double value2, WeightUnit unit2) {
        Weight weight1 = new Weight(value1, unit1);
        Weight weight2 = new Weight(value2, unit2);

        return demonstrateWeightEquality(weight1, weight2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit fromUnit, WeightUnit toUnit) {
        Weight weight = new Weight(value, fromUnit);
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {
        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2, WeightUnit targetUnit) {
        return weight1.add(weight2, targetUnit);
    }

    public static void main(String[] args) {
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length lengthInYards = new Length(3.0, LengthUnit.YARDS);
        Length lengthInInches = new Length(36.0, LengthUnit.INCHES);
        Length lengthInCM = new Length(1.0, LengthUnit.CENTIMETERS);
        Length zeroFeet = new Length(0.0, LengthUnit.FEET);

        System.out.println(demonstrateLengthConversion(lengthInFeet, LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(lengthInYards, LengthUnit.FEET));
        System.out.println(demonstrateLengthConversion(lengthInInches, LengthUnit.YARDS));
        System.out.println(demonstrateLengthConversion(lengthInCM, LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(zeroFeet, LengthUnit.INCHES));

        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches));
        System.out.println(demonstrateLengthAddition(lengthInYards, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInYards));
        System.out.println(demonstrateLengthAddition(lengthInCM, lengthInYards));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInCM));

        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, LengthUnit.FEET));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, LengthUnit.INCHES));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, LengthUnit.YARDS));
        System.out.println(demonstrateLengthAddition(lengthInYards, lengthInFeet, LengthUnit.YARDS));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInYards, LengthUnit.FEET));
        System.out.println(demonstrateLengthAddition(lengthInCM, lengthInInches, LengthUnit.CENTIMETERS));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInFeet, LengthUnit.INCHES));

        Weight grams = new Weight(1.0, WeightUnit.GRAM);
        Weight kilograms = new Weight(1000, WeightUnit.KILOGRAM);
        Weight milligrams = new Weight(0.001, WeightUnit.MILLIGRAM);
        Weight pound = new Weight(453.592, WeightUnit.POUND);
        Weight tonnes = new Weight(1000000, WeightUnit.TONNE);

        System.out.println(demonstrateWeightConversion(grams, WeightUnit.GRAM));
        System.out.println(demonstrateWeightConversion(kilograms, WeightUnit.MILLIGRAM));
        System.out.println(demonstrateWeightConversion(milligrams, WeightUnit.TONNE));
        System.out.println(demonstrateWeightConversion(pound, WeightUnit.GRAM));
        System.out.println(demonstrateWeightConversion(tonnes, WeightUnit.POUND));

        System.out.println(demonstrateWeightAddition(milligrams, grams));
        System.out.println(demonstrateWeightAddition(pound, kilograms));
        System.out.println(demonstrateWeightAddition(tonnes, pound));
        System.out.println(demonstrateWeightAddition(kilograms, grams));
        System.out.println(demonstrateWeightAddition(grams, pound));
        System.out.println(demonstrateWeightAddition(pound, milligrams));
        System.out.println(demonstrateWeightAddition(tonnes, kilograms));
        System.out.println(demonstrateWeightAddition(pound, milligrams));

        System.out.println(demonstrateWeightAddition(grams, kilograms, WeightUnit.MILLIGRAM));
        System.out.println(demonstrateWeightAddition(kilograms, milligrams, WeightUnit.TONNE));
        System.out.println(demonstrateWeightAddition(pound, tonnes, WeightUnit.KILOGRAM));
        System.out.println(demonstrateWeightAddition(tonnes, milligrams, WeightUnit.KILOGRAM));
        System.out.println(demonstrateWeightAddition(tonnes, kilograms, WeightUnit.GRAM));
        System.out.println(demonstrateWeightAddition(pound, grams, WeightUnit.TONNE));
        System.out.println(demonstrateWeightAddition(kilograms, pound, WeightUnit.MILLIGRAM));
    }
}