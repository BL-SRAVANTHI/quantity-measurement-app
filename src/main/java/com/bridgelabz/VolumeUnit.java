package com.bridgelabz;

public enum VolumeUnit implements IMeasurable {
    MILLILITER(1.0),
    LITER(1000.0),
    CUBIC_METER(1000000.0),
    GALLON(3785.41);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return this.conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return Math.round(value * conversionFactor * 1000.0) / 1000.0;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return Math.round(baseValue / conversionFactor * 1000.0) / 1000.0;
    }
}