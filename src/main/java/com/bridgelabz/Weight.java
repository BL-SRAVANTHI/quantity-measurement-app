package com.bridgelabz;

public class Weight {
    private double value;
    private WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(
                    "Weight value must be a finite number");
        } else if (unit == null) {
            throw new IllegalArgumentException("Unit must not be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public boolean compare(Weight thatWeight) {
        double difference = Math.abs(
                this.convertToBaseUnit()
                        - thatWeight.convertToBaseUnit());

        return (difference < 0.0001);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Weight weightUnit = (Weight) obj;
        return compare(weightUnit);
    }

    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double valueInBaseUnit = this.convertToBaseUnit();
        double convertedValue =
                valueInBaseUnit / targetUnit.getConversionFactor();

        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Weight(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public Weight add(Weight thatWeight) {
        return addAndConvert(thatWeight, this.unit);
    }

    public Weight add(Weight weight, WeightUnit targetUnit) {
        return addAndConvert(weight, targetUnit);
    }

    public Weight addAndConvert(Weight weight, WeightUnit targetUnit) {
        if (weight == null) {
            throw new IllegalArgumentException("Weight cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double value1InInches = this.convertToBaseUnit();
        double value2InInches = weight.convertToBaseUnit();

        double sum = convertFromBaseToTargetUnit(value1InInches + value2InInches, targetUnit);
        return new Weight(Math.round(sum * 1000.0) / 1000.0, targetUnit);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(this.value);
    }

    public double convertFromBaseToTargetUnit(double weightInGrams,
                                              WeightUnit targetUnit) {
        return weightInGrams / targetUnit.getConversionFactor();
    }
}

