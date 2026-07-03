package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testIMeasurableInterfaceLengthUnitImplementation() {
        assertEquals(36.0, LengthUnit.YARDS.getConversionFactor(), EPSILON);
        assertEquals(12.0, LengthUnit.FEET.convertToBaseUnit(1), EPSILON);
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(12), EPSILON);
    }

    @Test
    public void testIMeasurableInterfaceWeightUnitImplementation() {
        assertEquals(453.592, WeightUnit.POUND.getConversionFactor(), EPSILON);
        assertEquals(1000.0, WeightUnit.KILOGRAM.convertToBaseUnit(1), EPSILON);
        assertEquals(1.0, WeightUnit.KILOGRAM.convertFromBaseUnit(1000), EPSILON);
    }

    @Test
    public void testGenericQuantityLengthOperationsEquality() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testGenericQuantityWeightOperationsEquality() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    public void testGenericQuantityLengthOperationsConversion() {
        Quantity<LengthUnit> feet = new Quantity<>(3.33, LengthUnit.YARDS);

        double converted = feet.convertTo(LengthUnit.FEET);

        assertEquals(9.99, converted, EPSILON);
    }

    @Test
    public void testGenericQuantity_WeightOperations_Conversion() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        double converted = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, converted, EPSILON);
    }

    @Test
    public void testGenericQuantityLengthOperationsAddition() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testGenericQuantityWeightOperationsAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = kg.add(gram, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testCrossCategoryPreventionLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    public void testGenericQuantityConstructorValidationNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    public void testGenericQuantityConstructorValidationInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.POSITIVE_INFINITY, LengthUnit.FEET));
    }

    @Test
    public void testGenericConversionAllUnitConversions() {
        assertEquals(12.0,
                new Quantity<>(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES)
                , 1e-6);

        assertEquals(1.0,
                new Quantity<>(12.0, LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET)
                , 1e-6);

        assertEquals(3.0,
                new Quantity<>(1.0, LengthUnit.YARDS)
                        .convertTo(LengthUnit.FEET)
                , 1e-6);

        assertEquals(100.0,
                new Quantity<>(39.3701, LengthUnit.INCHES)
                        .convertTo(LengthUnit.CENTIMETERS)
                , 1e-3);

        // Weight Conversions
        assertEquals(1000.0,
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM)
                , 1e-6);

        assertEquals(1.0,
                new Quantity<>(1000.0, WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM)
                , 1e-6);

        assertEquals(453.592,
                new Quantity<>(1.0, WeightUnit.POUND)
                        .convertTo(WeightUnit.GRAM)
                , 1e-3);

        assertEquals(2.20462,
                new Quantity<>(1000.0, WeightUnit.GRAM)
                        .convertTo(WeightUnit.POUND)
                , 1e-3);

        assertEquals(1000000.0,
                new Quantity<>(1.0, WeightUnit.TONNE)
                        .convertTo(WeightUnit.GRAM)
                , 1e-6);

        assertEquals(1.0,
                new Quantity<>(1000000.0, WeightUnit.GRAM)
                        .convertTo(WeightUnit.TONNE)
                , 1e-6);
    }

    @Test
    public void testGenericQuantityAdditionAllUnitCombinations() {
        // Length: Feet + Inches -> Feet
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> lengthResult =
                length1.add(length2, LengthUnit.FEET);

        assertEquals(2.0, lengthResult.getValue(), 1e-6);

        // Length: Feet + Inches -> Inches
        lengthResult = length1.add(length2, LengthUnit.INCHES);

        assertEquals(24.0, lengthResult.getValue(), 1e-6);

        // Length: Yard + Foot -> Yard
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> foot = new Quantity<>(1.0, LengthUnit.FEET);

        lengthResult = yard.add(foot, LengthUnit.YARDS);

        assertEquals(1.333, lengthResult.getValue(), 1e-5);

        // Weight: Kilogram + Gram -> Kilogram
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> weightResult =
                kg.add(gram, WeightUnit.KILOGRAM);

        assertEquals(2.0, weightResult.getValue(), 1e-6);

        // Weight: Kilogram + Gram -> Gram
        weightResult = kg.add(gram, WeightUnit.GRAM);

        assertEquals(2000.0, weightResult.getValue(), 1e-6);

        // Weight: Pound + Kilogram -> Pound
        Quantity<WeightUnit> pound = new Quantity<>(2.204, WeightUnit.POUND);

        weightResult = pound.add(kg, WeightUnit.POUND);

        assertEquals(4.409, weightResult.getValue(), 1e-3);
    }

    @Test
    public void testQuantityMeasurementAppSimplifiedDemonstrationEquality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1000, WeightUnit.GRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1, WeightUnit.KILOGRAM);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(q1, q2));
    }

    @Test
    public void testQuantityMeasurementAppSimplifiedDemonstrationConversion() {
        Quantity<WeightUnit> weight = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> converted =
                QuantityMeasurementApp.demonstrateConversion(weight, WeightUnit.KILOGRAM);

        assertEquals(1.0, converted.getValue(), EPSILON);
    }

    @Test
    public void testQuantityMeasurementAppSimplifiedDemonstrationAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                QuantityMeasurementApp.demonstrateAddition(kg, gram);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    public void testScalabilityNewUnitEnumIntegration() {
        Quantity<VolumeUnit> lts = new Quantity<>(1, VolumeUnit.LITER);
        assertEquals(1000, lts.convertTo(VolumeUnit.MILLILITER));
    }

    @Test
    public void testScalabilityMultipleNewCategories() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(1, TemperatureUnit.CELSIUS);
        assertEquals(33.8, celsius.convertTo(TemperatureUnit.FAHRENHEIT));

        Quantity<TimeUnit> hrs = new Quantity<>(1, TimeUnit.HOUR);
        assertEquals(3600, hrs.convertTo(TimeUnit.SECOND));
    }

    @Test
    public void testHashCodeGenericQuantityConsistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    public void testEqualsGenericQuantityContractPreservation() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> c = new Quantity<>(30.48, LengthUnit.CENTIMETERS);

        assertTrue(a.equals(a));      // reflexive
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));      // symmetric
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));      // transitive
    }

    @Test
    public void testEnumAsUnitCarrierBehaviorEncapsulation() {
        IMeasurable unit = LengthUnit.FEET;

        assertEquals(24.0, unit.convertToBaseUnit(2), EPSILON);
    }

    @Test
    public void testTypeErasureRuntimeSafety() {
        Quantity<?> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<?> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    public void testCompositionOverInheritanceFlexibility() {
        Quantity<LengthUnit> length =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(5, WeightUnit.KILOGRAM);

        assertNotNull(length);
        assertNotNull(weight);
    }

    @Test
    public void testImmutability_GenericQuantity() {
        Quantity<LengthUnit> length =
                new Quantity<>(1, LengthUnit.FEET);

        double converted =
                length.convertTo(LengthUnit.INCHES);

        assertEquals(1.0, length.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, length.getUnit());

        assertEquals(12.0, converted, EPSILON);
    }
}
