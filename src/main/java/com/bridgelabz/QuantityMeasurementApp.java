/**
 * QuantityMeasurementApp - UC3: Generic Quantity Class for DRY Principle
 * UC3 is designed to overcome the Disadvantage of using Feet and Inches
 * which starts violating the DRY principle, where both Feet and Inches
 * classes contain nearly identical code, having the same constructor
 * pattern, Identical equals() method implementation.
 * This Use Case refactors the existing Feet and Inches classes into a
 * single generic Quantity Length class that eliminates code duplication
 * while maintaining all functionality from UC1 and UC2.
 * The Quantity Length class represents any measurement with a value and
 * unit type, applying the DRY (Don't Repeat Yourself) principle.
 * This reduces maintenance burden and makes the codebase more scalable
 * for adding new units in the future.
 */

package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void demonstrateLengthEquality(Length length1, Length length2) {
        if (length1.compare(length2)) {
            System.out.println("Equal (True)");
        } else {
            System.out.println("Not Equal (False)");
        }
    }

    public static void demonstrateFeetEquality() {
        System.out.println("Feet Equality:");
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        demonstrateLengthEquality(length1, length2);
    }

    public static void demonstrateInchesEquality() {
        System.out.println("Inches Equality:");
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        demonstrateLengthEquality(length1, length2);
    }

    public static void demonstrateFeetInchesComparison() {
        System.out.println("Feet and Inches Comparison:");
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        demonstrateLengthEquality(length1, length2);
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}