/**
 * QuantityMeasurementApp - UC2: Feet and Inches measurement equality
 * This Use Case extends UC1 to accommodate the Equality
 * Check for Inches along with Feet. This use case is in no way
 * trying to compare two entities, Feet and Inches.
 * They are still treated separately.
 * Please ensure like UC1 the test cases ensure complete test coverage
 * to accurately compare and handle various edge cases
 */

package com.bridgelabz;

public class QuantityMeasurementApp {
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            Inches inches = (Inches) obj;
            return Double.compare(inches.value, value) == 0;
        }
    }

    public static void demonstrateFeetEquality() {
        Feet feet1 = new Feet(1);
        Feet feet2 = new Feet(1);
        Feet feet3 = new Feet(3);

        System.out.println("Comparison of Two Feet Objects with same Value(1 ft) : ");
        if (feet1.equals(feet2)) {
            System.out.println("Equal(True)");
        } else {
            System.out.println("Not Equal(False)");
        }

        System.out.println("Comparison of Two Feet Objects with different values(1 ft, 3 ft) : ");
        if (feet1.equals(feet3)) {
            System.out.println("Equal(True)");
        } else {
            System.out.println("Not Equal(False)");
        }
    }

    public static void demonstrateInchesEquality() {
        Inches inch1 = new Inches(1);
        Inches inch2 = new Inches(1);
        Inches inch3 = new Inches(3);

        System.out.println("Comparison of Two Inch Objects with same Value(1 inch) : ");
        if (inch1.equals(inch2)) {
            System.out.println("Equal(True)");
        } else {
            System.out.println("Not Equal(False)");
        }

        System.out.println("Comparison of Two Inch Objects with different values(1 Inch, 3 Inch) : ");
        if (inch1.equals(inch3)) {
            System.out.println("Equal(True)");
        } else {
            System.out.println("Not Equal(False)");
        }
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
