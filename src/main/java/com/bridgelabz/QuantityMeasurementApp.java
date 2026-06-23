/**
 * QuantityMeasurementApp - UC1: Feet measurement equality
 * This class is responsible for checking the equality of two numeric values
 * measured in feet in the Quantity Measurement Application
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

    public static void main(String[] args) {
        Feet feet1 = new Feet(1);
        Feet feet2 = new Feet(1);

        if (feet1.equals(feet2)) {
            System.out.println("Equal(true)");
        } else {
            System.out.println("Not Equal(False)");
        }
    }
}
