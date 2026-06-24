/**
 * QuantityMeasurementApp -UC5: Unit-to-Unit Conversion (Same Measurement Type)
 * UC5 extends UC4 by providing explicit conversion operations between length units
 * (e.g., feet → inches, yards → inches, centimeters → feet).
 * Instead of only comparing equality, the Quantity Length API exposes a conversion method
 * that returns a numeric value converted from a
 * source unit to a target unit using the centralized conversion factors.
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
    }
}