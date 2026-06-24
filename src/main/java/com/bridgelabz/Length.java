package com.bridgelabz;

public class Length {
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
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
    }

    public Length(double value, LengthUnit unit) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(
                    "Length value must be a finite number");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    private double convertToBaseUnit() {
        return value * unit.conversionFactor;
    }

    public boolean compare(Length thatLength) {
        double difference = Math.abs(
                this.convertToBaseUnit()
                        - thatLength.convertToBaseUnit());

        return (difference < 0.0001);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Length lengthObj = (Length) obj;
        return compare(lengthObj);
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double valueInBaseUnit = this.convertToBaseUnit();
        double convertedValue =
                valueInBaseUnit / targetUnit.getConversionFactor();

        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double length1 = this.convertToBaseUnit();
        double length2 = thatLength.convertToBaseUnit();

        double sumInInches = length1 + length2;
        double sumInTargetUnits = convertFromBaseToTargetUnit(sumInInches, this.unit);
        double output = Math.round(sumInTargetUnits * 1000.0) / 1000.0;
        return new Length(output, this.unit);
    }

    public double convertFromBaseToTargetUnit(double lengthInInches,
                                              LengthUnit targetUnit) {
        return lengthInInches / targetUnit.getConversionFactor();
    }


    public static void main(String[] args) {
        Length length1 = new Length(1, LengthUnit.FEET);

        Length toYards = length1.convertTo(LengthUnit.YARDS);
        System.out.println(toYards.toString());

        Length toCM = length1.convertTo(LengthUnit.CENTIMETERS);
        System.out.println(toCM.toString());

        Length toInches = length1.convertTo(LengthUnit.INCHES);
        System.out.println(toInches);

        System.out.println((length1.add(toCM).toString()));
    }
}
