package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testInchesEquality() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testEqualityInchToFeetEquivalentValue() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testFeetInequality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testInchesInequality() {
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(3.0, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testCrossUnitInEquality() {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(4, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void yardEquals36Inches() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(36.0, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length length1 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length2 = new Length(39.3701, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void threeFeetEqualToInches() {
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.YARDS);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length length1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void yardNotEqualToInches() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testEqualityWithNull() {
        Length length = new Length(1.0, LengthUnit.FEET);
        boolean output = length.equals(null);
        assertFalse(output);
    }

    @Test
    public void testEqualitySameReference() {
        Length length = new Length(1.0, LengthUnit.FEET);
        boolean output = length.equals(length);
        assertTrue(output);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length length3 = new Length(30.48, LengthUnit.CENTIMETERS);

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
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        boolean output = QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES
        );
        assertTrue(output);
    }

    @Test
    public void convertFeetToInches() {
        Length lengthInInches = QuantityMeasurementApp.
                demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        Length expectedLength = new Length(36.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionInchesToFeetUsingOverloadedMethod() {
        Length lengthInInches = new Length(24.0, LengthUnit.INCHES);
        Length lengthInFeet = QuantityMeasurementApp.demonstrateLengthConversion(lengthInInches, LengthUnit.INCHES);
        Length expectedLength = new Length(2.0, LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInFeet, expectedLength));
    }

    @Test
    public void testConversionInchesToYards() {
        Length lengthInYards = QuantityMeasurementApp.
                demonstrateLengthConversion(72.0, LengthUnit.INCHES, LengthUnit.YARDS);
        Length expectedLength = new Length(2.0, LengthUnit.YARDS);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInYards, expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length lengthInYards = new Length(2.0, LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);
        Length expectedLength = new Length(72.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionCentimetersToInches() {
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        Length expectedLength = new Length(1.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionFeetToYardsUsingOverloadedMethod() {
        Length lengthInFeet = new Length(6.0, LengthUnit.FEET);
        Length lengthInYards = QuantityMeasurementApp.demonstrateLengthConversion(lengthInFeet, LengthUnit.YARDS);
        Length expectedLength = new Length(2.0, LengthUnit.YARDS);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInYards, expectedLength));
    }

    @Test
    public void testConversionRoundTripPreservesValue() {
        Length originalLength = new Length(2, LengthUnit.YARDS);
        Length centimeters =
                QuantityMeasurementApp.demonstrateLengthConversion(originalLength, LengthUnit.CENTIMETERS);
        Length convertedBack =
                QuantityMeasurementApp.demonstrateLengthConversion(centimeters, LengthUnit.YARDS);
        assertTrue(originalLength.equals(convertedBack));
    }

    @Test
    public void testConversionZeroValue() {
        Length length = new Length(0.0, LengthUnit.FEET);
        Length lengthInInches = length.convertTo(LengthUnit.INCHES);
        Length expectedLength = new Length(0.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void testConversionNegativeValue() {
        Length length = QuantityMeasurementApp.demonstrateLengthConversion(-1.0, LengthUnit.FEET, LengthUnit.INCHES);
        Length expectedLength = new Length(-12.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length, expectedLength));
    }

    @Test
    public void testConversionInvalidUnitThrows() {
        Length length = new Length(1.0, LengthUnit.FEET);

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
                        LengthUnit.FEET)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(Double.POSITIVE_INFINITY,
                        LengthUnit.FEET)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(Double.NEGATIVE_INFINITY,
                        LengthUnit.FEET)
        );
    }

    @Test
    public void testConversion_PrecisionTolerance() {

        Length length = new Length(100.0, LengthUnit.CENTIMETERS);
        Length converted = length.convertTo(LengthUnit.INCHES);

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
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);

        Length expectedOutput = new Length(3.0, LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionSameUnitInchPlusInch() {
        Length length1 = new Length(6.0, LengthUnit.INCHES);
        Length length2 = new Length(6.0, LengthUnit.INCHES);

        Length expectedOutput = new Length(12.0, LengthUnit.INCHES);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitFeetPlusInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length expectedOutput = new Length(2.0, LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitInchPlusFeet() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        Length expectedOutput = new Length(24.0, LengthUnit.INCHES);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitYardPlusFeet() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length expectedOutput = new Length(2.0, LengthUnit.YARDS);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCrossUnitCentimeterPlusInch() {
        Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        Length expectedOutput = new Length(5.08, LengthUnit.CENTIMETERS);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionCommutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sum1 = length1.add(length2);
        Length sum2 = length2.add(length1);

        assertTrue(sum1.equals(sum2));
    }

    @Test
    public void testAdditionWithZero() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);

        Length expectedOutput = new Length(5.0, LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionNegativeValues() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);

        Length expectedOutput = new Length(3.0, LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAddition_NullSecondOperand() {
        Length length = new Length(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null)
        );
    }

    @Test
    public void testAdditionLargeValues() {
        Length length1 = new Length(1e6, LengthUnit.FEET);
        Length length2 = new Length(1e6, LengthUnit.FEET);

        Length expectedOutput = new Length(2e6, LengthUnit.FEET);
        Length sum = length1.add(length2);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum, expectedOutput));
    }

    @Test
    public void testAdditionSmallValues() {
        Length length1 = new Length(0.001, LengthUnit.FEET);
        Length length2 = new Length(0.002, LengthUnit.FEET);

        Length sum = length1.add(length2);

        double expectedValue = 0.003;
        double epsilon = 1e-6;

        assertEquals(expectedValue, sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionExplicitTargetUnitFeet() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitYards() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitCentimeters() {
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSameAsFirstOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result = length1.add(length2, LengthUnit.YARDS);

        assertEquals(3.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSameAsSecondOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result = length1.add(length2, LengthUnit.FEET);

        assertEquals(9.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitCommutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sum1 = length1.add(length2, LengthUnit.YARDS);
        Length sum2 = length2.add(length1, LengthUnit.YARDS);

        assertEquals(sum1.getValue(), sum2.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitWithZero() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.YARDS);

        assertEquals(1.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitNegativeValues() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);

        Length result = length1.add(length2, LengthUnit.INCHES);

        assertEquals(36.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitNullTargetUnit() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> length1.add(length2, null)
        );
    }

    @Test
    public void testAdditionExplicitTargetUnitLargeToSmallScale() {
        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);

        Length result = length1.add(length2, LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitSmallToLargeScale() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue());
    }

    @Test
    public void testAdditionExplicitTargetUnitAllUnitCombinations() {
        for (LengthUnit unit1 : LengthUnit.values()) {
            for (LengthUnit unit2 : LengthUnit.values()) {
                for (LengthUnit target : LengthUnit.values()) {

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
        Length length1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        Length result = length1.add(length2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), 1e-4);
    }

    @Test
    public void kilogramEquals1000Grams() {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000, WeightUnit.GRAM);

        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight weight1 = new Weight(1, WeightUnit.POUND);
        Weight weight2 = new Weight(453.592, WeightUnit.GRAM);

        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void tonneEquals1000000Grams() {
        Weight weight1 = new Weight(1, WeightUnit.TONNE);
        Weight weight2 = new Weight(1000000, WeightUnit.GRAM);

        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void kilogramNotEqualsPound() {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1, WeightUnit.POUND);

        assertFalse(weight1.equals(weight2));
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(2, WeightUnit.KILOGRAM);
        Weight expectedOutput = new Weight(3, WeightUnit.KILOGRAM);
        assertEquals(expectedOutput, weight1.add(weight2));
    }

    @Test
    public void testEqualityKgToKgSameValue() {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1, WeightUnit.KILOGRAM);

        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEqualityKgToGramEquivalentValue() {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight expectedValue = new Weight(1000, WeightUnit.GRAM);
        Weight actualValue = weight1.convertTo(WeightUnit.GRAM);

        assertTrue(expectedValue.equals(actualValue));
    }

    @Test
    public void testEqualityWeightVsLengthInCompatible() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);
        Length length = new Length(1.0, LengthUnit.FEET);

        assertFalse(weight.equals(length));
    }

    @Test
    public void testEqualityNullComparison() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);
        assertFalse(weight.equals(null));
    }

    @Test
    public void testEqualityWeightSameReference() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight.equals(weight));
    }

    @Test
    public void testEqualityNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Weight(1.0, null)
        );
    }

    @Test
    public void testEqualityTransitiveProperty() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000, WeightUnit.GRAM);
        Weight weight3 = new Weight(1, WeightUnit.KILOGRAM);
        boolean aEqualsB = weight1.equals(weight2);
        boolean bEqualsC = weight2.equals(weight3);
        assertEquals(aEqualsB, bEqualsC);
    }

    @Test
    public void testEqualityNegativeWeight() {
        Weight weight1 = new Weight(-1.0, WeightUnit.KILOGRAM);
        Weight expectedOutput = new Weight(-1000, WeightUnit.GRAM);
        assertTrue(expectedOutput.equals(weight1.convertTo(WeightUnit.GRAM)));
    }

    @Test
    public void testConversionPoundToKilogram() {
        Weight weight = new Weight(2.20462, WeightUnit.POUND);
        Weight expectedValue = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight convertedValue = weight.convertTo(WeightUnit.KILOGRAM);
        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), convertedValue.getValue(), epsilon);
    }

    @Test
    public void testConversionKgToPound() {
        Weight weight = new Weight(1, WeightUnit.KILOGRAM);
        Weight expectedValue = new Weight(2.20, WeightUnit.POUND);
        Weight convertedValue = weight.convertTo(WeightUnit.POUND);
        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), convertedValue.getValue(), epsilon);
    }

    @Test
    public void testConversionSameUnit() {
        Weight weight = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight expectedValue = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight convertedValue = weight.convertTo(WeightUnit.KILOGRAM);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), convertedValue.getValue(), epsilon);
    }

    @Test
    public void testConversionWeightZeroValue() {
        Weight weight = new Weight(0.0, WeightUnit.KILOGRAM);
        Weight expectedValue = new Weight(0.0, WeightUnit.GRAM);
        Weight convertedValue = weight.convertTo(WeightUnit.GRAM);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), convertedValue.getValue(), epsilon);
    }

    @Test
    public void testConversionWeightNegativeValue() {
        Weight weight = new Weight(-1.0, WeightUnit.KILOGRAM);
        Weight expectedValue = new Weight(-1000.0, WeightUnit.GRAM);
        Weight convertedValue = weight.convertTo(WeightUnit.GRAM);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), convertedValue.getValue(), epsilon);
    }

    @Test
    public void testConversionRoundTrip() {
        Weight weight = new Weight(1.5, WeightUnit.KILOGRAM);

        Weight converted = weight.convertTo(WeightUnit.GRAM);
        Weight roundTrip = converted.convertTo(WeightUnit.KILOGRAM);

        double epsilon = 1e-6;
        assertEquals(weight.getValue(), roundTrip.getValue(), epsilon);
    }

    @Test
    public void testAdditionSameUnitKilogramPlusKilogram() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(2.0, WeightUnit.KILOGRAM);

        Weight expectedValue = new Weight(3.0, WeightUnit.KILOGRAM);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionCrossUnitKilogramPlusGram() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight expectedValue = new Weight(2.0, WeightUnit.KILOGRAM);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionCrossUnitPoundPlusKilogram() {
        Weight weight1 = new Weight(2.20462, WeightUnit.POUND);
        Weight weight2 = new Weight(1.0, WeightUnit.KILOGRAM);

        Weight expectedValue = new Weight(4.40924, WeightUnit.POUND);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-2;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionExplicitTargetUnitKilogram() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight expectedValue = new Weight(2000.0, WeightUnit.GRAM);
        Weight sum = weight1.add(weight2, WeightUnit.GRAM);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionWeightCommutativity() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight sum1 = weight1.add(weight2);
        Weight sum2 = weight2.add(weight1);

        Weight sum2InKg = sum2.convertTo(WeightUnit.KILOGRAM);

        double epsilon = 1e-6;
        assertEquals(sum1.getValue(), sum2InKg.getValue(), epsilon);
    }

    @Test
    public void testAdditionWeightWithZero() {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(0.0, WeightUnit.GRAM);

        Weight expectedValue = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionWeightNegativeValues() {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(-2000.0, WeightUnit.GRAM);

        Weight expectedValue = new Weight(3.0, WeightUnit.KILOGRAM);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }

    @Test
    public void testAdditionWeightLargeValues() {
        Weight weight1 = new Weight(1_000_000.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1_000_000.0, WeightUnit.KILOGRAM);

        Weight expectedValue = new Weight(2_000_000.0, WeightUnit.KILOGRAM);
        Weight sum = weight1.add(weight2);

        double epsilon = 1e-6;
        assertEquals(expectedValue.getValue(), sum.getValue(), epsilon);
    }
}
