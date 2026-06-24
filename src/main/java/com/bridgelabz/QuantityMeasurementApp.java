/**
 * QuantityMeasurementApp -UC6: Addition of Two Length Units (Same Category)
 * UC6 extends UC5 by introducing addition operations between length measurements.
 * This use case enables the Quantity Length API to add two lengths of potentially different units
 * (but same category—length) and return the result in the unit of the first operand.
 * Essentially adding another length to the current length. For example,
 * adding 1 foot and 12 inches should yield 2 feet (based on the unit of the first operand
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

    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1, double value2, Length.LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        return demonstrateLengthEquality(length1, length2);
    }

    public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static void main(String[] args) {
        Length lengthInFeet = new Length(1.0, Length.LengthUnit.FEET);
        Length lengthInYards = new Length(3.0, Length.LengthUnit.YARDS);
        Length lengthInInches = new Length(36.0, Length.LengthUnit.INCHES);
        Length lengthInCM = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length zeroFeet = new Length(0.0, Length.LengthUnit.FEET);

        System.out.println(demonstrateLengthConversion(lengthInFeet, Length.LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(lengthInYards, Length.LengthUnit.FEET));
        System.out.println(demonstrateLengthConversion(lengthInInches, Length.LengthUnit.YARDS));
        System.out.println(demonstrateLengthConversion(lengthInCM, Length.LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(zeroFeet, Length.LengthUnit.INCHES));

        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches));
        System.out.println(demonstrateLengthAddition(lengthInYards, lengthInFeet));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInYards));
        System.out.println(demonstrateLengthAddition(lengthInCM, lengthInYards));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInCM));
    }
}