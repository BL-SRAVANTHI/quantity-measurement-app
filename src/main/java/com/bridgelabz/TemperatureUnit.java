package com.bridgelabz;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS {
        @Override
        public double getConversionFactor() {
            throw new IllegalCallerException();
        }

        @Override
        public double convertToBaseUnit(double value) {
            return value;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return baseValue;
        }
    },

    FAHRENHEIT {
        @Override
        public double getConversionFactor() {
            throw new IllegalCallerException();
        }

        @Override
        public double convertToBaseUnit(double value) {
            return (value - 32) * 5 / 9;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return (baseValue * 9 / 5) + 32;
        }
    },

    KELVIN {
        @Override
        public double getConversionFactor() {
            throw new IllegalCallerException();
        }

        @Override
        public double convertToBaseUnit(double value) {
            return value - 273.15;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return baseValue + 273.15;
        }
    };
}
