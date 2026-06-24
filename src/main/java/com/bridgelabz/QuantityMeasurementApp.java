/**
 * QuantityMeasurementApp -UC7: Addition with Target Unit Specification
 * UC7 extends UC6 by providing flexibility in specifying the unit for
 * the addition result. Instead of defaulting to the unit of the first operand,
 * this use case allows the caller to explicitly specify any supported unit as the
 * target unit for the result. This provides greater flexibility in use cases
 * where the result must be expressed in a specific unit regardless of the operands' units.
 * For example, adding 1 foot and 12 inches with a target unit of
 * yards should yield approximately 0.667 yards.
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

    public static Length demonstrateLengthAddition(Length length1, Length length2, Length.LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
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

        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, Length.LengthUnit.FEET));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, Length.LengthUnit.INCHES));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInInches, Length.LengthUnit.YARDS));
        System.out.println(demonstrateLengthAddition(lengthInYards, lengthInFeet, Length.LengthUnit.YARDS));
        System.out.println(demonstrateLengthAddition(lengthInInches, lengthInYards, Length.LengthUnit.FEET));
        System.out.println(demonstrateLengthAddition(lengthInCM, lengthInInches, Length.LengthUnit.CENTIMETERS));
        System.out.println(demonstrateLengthAddition(lengthInFeet, lengthInFeet, Length.LengthUnit.INCHES));

    }
}