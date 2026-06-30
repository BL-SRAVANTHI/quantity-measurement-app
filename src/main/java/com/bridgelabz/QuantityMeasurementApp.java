/**
 * QuantityMeasurementApp -UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility
 * UC8 refactors the design from UC1–UC7 to overcome the disadvantage of embedding the LengthUnit enum within the QuantityLength class.
 * This design flaw creates circular dependencies when scaling to
 * multiple measurement categories (length, weight, volume, etc.) and violates the Single Responsibility Principle by
 * not centralizing unit-related conversion logic.
 * <p>
 * <p>
 * UC8 extracts the LengthUnit enum into a standalone,
 * top-level class and assigns it the responsibility of managing
 * conversions to and from the base unit. The QuantityLength class is
 * simplified to delegate conversion logic to the unit itself, improving
 * cohesion, reducing coupling, and establishing a scalable pattern for additional measurement categories.
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

    }
}