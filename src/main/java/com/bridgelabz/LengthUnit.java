package com.bridgelabz;

public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    public double getConversionFactor() {
        return this.conversionFactor;
    }

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return Math.round((value * this.conversionFactor) * 1000.0) / 1000.0;
    }

    public double convertFromBaseUnit(double baseValue) {
        return Math.round((baseValue / this.conversionFactor) * 1000.0) / 1000.0;
    }
}
