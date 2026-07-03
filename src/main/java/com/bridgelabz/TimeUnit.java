package com.bridgelabz;

public enum TimeUnit implements IMeasurable {
    SECOND(1.0),
    MINUTE(60.0),
    HOUR(3600.0),
    DAY(86400.0);

    private final double conversionFactor;

    TimeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
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