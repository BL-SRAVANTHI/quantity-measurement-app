package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testInchesEquality() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testEqualityInchToFeetEquivalentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testFeetInequality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testInchesInequality() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(3.0, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testCrossUnitInEquality() {
        Length length1 = new Length(1, Length.LengthUnit.FEET);
        Length length2 = new Length(4, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void yardEquals36Inches() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length length1 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(39.3701, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void threeFeetEqualToInches() {
        Length length1 = new Length(3.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.YARDS);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void yardNotEqualToInches() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testEqualityWithNull() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        boolean output = length.equals(null);
        assertFalse(output);
    }

    @Test
    public void testEqualitySameReference() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        boolean output = length.equals(length);
        assertTrue(output);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length3 = new Length(30.48, Length.LengthUnit.CENTIMETERS);

        // Reflexive
        assertTrue(length1.equals(length1));

        // Symmetric
        assertTrue(length1.equals(length2));
        assertTrue(length2.equals(length1));

        // Transitive
        assertTrue(length1.equals(length2));
        assertTrue(length2.equals(length3));
        assertTrue(length1.equals(length3));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        boolean output = QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES
        );
        assertTrue(output);
    }

    @Test
    public void convertFeetToInches() {
        Length lengthInInches = QuantityMeasurementApp.
                demonstrateLengthConversion(3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        Length expectedLength = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionInchesToFeetUsingOverloadedMethod() {
        Length lengthInInches = new Length(24.0, Length.LengthUnit.INCHES);
        Length lengthInFeet = QuantityMeasurementApp.demonstrateLengthConversion(lengthInInches, Length.LengthUnit.INCHES);
        Length expectedLength = new Length(2.0, Length.LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInFeet, expectedLength));
    }

    @Test
    public void testConversionInchesToYards() {
        Length lengthInYards = QuantityMeasurementApp.
                demonstrateLengthConversion(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        Length expectedLength = new Length(2.0, Length.LengthUnit.YARDS);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInYards, expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length lengthInYards = new Length(2.0, Length.LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, Length.LengthUnit.INCHES);
        Length expectedLength = new Length(72.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionCentimetersToInches() {
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        Length expectedLength = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionFeetToYardsUsingOverloadedMethod() {
        Length lengthInFeet = new Length(6.0, Length.LengthUnit.FEET);
        Length lengthInYards = QuantityMeasurementApp.demonstrateLengthConversion(lengthInFeet, Length.LengthUnit.YARDS);
        Length expectedLength = new Length(2.0, Length.LengthUnit.YARDS);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInYards, expectedLength));
    }

    @Test
    public void testConversionRoundTripPreservesValue() {
        Length originalLength = new Length(2, Length.LengthUnit.YARDS);
        Length centimeters =
                QuantityMeasurementApp.demonstrateLengthConversion(originalLength, Length.LengthUnit.CENTIMETERS);
        Length convertedBack =
                QuantityMeasurementApp.demonstrateLengthConversion(centimeters, Length.LengthUnit.YARDS);
        assertTrue(originalLength.equals(convertedBack));
    }

    @Test
    public void testConversionZeroValue() {
        Length length = new Length(0.0, Length.LengthUnit.FEET);
        Length lengthInInches = length.convertTo(Length.LengthUnit.INCHES);
        Length expectedLength = new Length(0.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionNegativeValue() {
        Length length = QuantityMeasurementApp.demonstrateLengthConversion(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        Length expectedLength = new Length(-12.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length, expectedLength));
    }

    @Test
    public void testConversionInvalidUnitThrows() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> length.convertTo(null)
        );
        assertEquals("Target unit cannot be null", exception.getMessage());
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(Double.NaN,
                        Length.LengthUnit.FEET)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(Double.POSITIVE_INFINITY,
                        Length.LengthUnit.FEET)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(Double.NEGATIVE_INFINITY,
                        Length.LengthUnit.FEET)
        );
    }

    @Test
    public void testConversion_PrecisionTolerance() {

        Length length = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length converted = length.convertTo(Length.LengthUnit.INCHES);

        double expected = 39.37;
        double epsilon = 1e-6;

        assertEquals(
                expected,
                converted.getValue(),
                epsilon
        );
    }

    @Test
    public void testAdditionSameUnitFeetPlusFeet() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);

        Length expectedOutput = new Length(3.0, Length.LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionSameUnitInchPlusInch() {
        Length length1 = new Length(6.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(6.0, Length.LengthUnit.INCHES);

        Length expectedOutput = new Length(12.0, Length.LengthUnit.INCHES);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitFeetPlusInches() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length expectedOutput = new Length(2.0, Length.LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitInchPlusFeet() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        Length expectedOutput = new Length(24.0, Length.LengthUnit.INCHES);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitYardPlusFeet() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        Length expectedOutput = new Length(2.0, Length.LengthUnit.YARDS);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitCentimeterPlusInch() {
        Length length1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length expectedOutput = new Length(5.08, Length.LengthUnit.CENTIMETERS);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCommutativity() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length sum1 = length1.add(length2);
        Length sum2 = length2.add(length1);

        assertTrue(sum1.equals(sum2));
    }

    @Test
    public void testAdditionWithZero() {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length expectedOutput = new Length(5.0, Length.LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionNegativeValues() {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length expectedOutput = new Length(3.0, Length.LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAddition_NullSecondOperand() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null)
        );
    }

    @Test
    public void testAdditionLargeValues() {
        Length length1 = new Length(1e6, Length.LengthUnit.FEET);
        Length length2 = new Length(1e6, Length.LengthUnit.FEET);

        Length expectedOutput = new Length(2e6, Length.LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionSmallValues() {
        Length length1 = new Length(0.001, Length.LengthUnit.FEET);
        Length length2 = new Length(0.002, Length.LengthUnit.FEET);

        Length sum = length1.add(length2);

        double expectedValue = 0.003;
        double epsilon = 1e-6;

        assertEquals(expectedValue, sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionExplicitTargetUnitFeet() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitInches() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitYards() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.YARDS);

        assertEquals(0.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitCentimeters() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSameAsFirstOperand() {
        Length length1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = length1.add(length2, Length.LengthUnit.YARDS);

        assertEquals(3.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSameAsSecondOperand() {
        Length length1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = length1.add(length2, Length.LengthUnit.FEET);

        assertEquals(9.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitCommutativity() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length sum1 = length1.add(length2, Length.LengthUnit.YARDS);
        Length sum2 = length2.add(length1, Length.LengthUnit.YARDS);

        assertEquals(sum1.getValue(), sum2.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitWithZero() {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.YARDS);

        assertEquals(1.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitNegativeValues() {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = length1.add(length2, Length.LengthUnit.INCHES);

        assertEquals(36.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitNullTargetUnit() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> length1.add(length2, null)
        );
    }

    @Test
    public void testAdditionExplicitTargetUnitLargeToSmallScale() {
        Length length1 = new Length(1000.0, Length.LengthUnit.FEET);
        Length length2 = new Length(500.0, Length.LengthUnit.FEET);

        Length result = length1.add(length2, Length.LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSmallToLargeScale() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = length1.add(length2, Length.LengthUnit.YARDS);

        assertEquals(0.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitAllUnitCombinations() {
        for (Length.LengthUnit unit1 : Length.LengthUnit.values()) {
            for (Length.LengthUnit unit2 : Length.LengthUnit.values()) {
                for (Length.LengthUnit target : Length.LengthUnit.values()) {

                    Length length1 = new Length(1.0, unit1);
                    Length length2 = new Length(1.0, unit2);

                    Length result = length1.add(length2, target);

                    assertNotNull(result);
                }
            }
        }
    }

    @Test
    public void testAdditionExplicitTargetUnitPrecisionTolerance() {
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = length1.add(length2, Length.LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), 1e-4);
    }
}
