/**
 * QuantityMeasurementApp - UC4: Extended Unit Support
 * UC4 extends UC3 by introducing Yards and Centimeters
 * as additional length units to the QuantityLength class.
 * This use case demonstrates how the generic Quantity class
 * design scales effortlessly to accommodate new units without code
 * duplication. Yards will be added to the LengthUnit enum with
 * the appropriate conversion factor
 * (1 yard = 3 feet) and (1cm = 0.393701in),
 * and all equality comparisons will work seamlessly across
 * feet, inches, yards, and cms.
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

    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(100, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);

    }
}