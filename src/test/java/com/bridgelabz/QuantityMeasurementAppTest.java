package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private boolean output;

    @Test
    public void testEqualityFeetToFeetSameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertTrue(output);
    }

    @Test
    public void testEqualityInchToInchSameValue() {
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
    public void testEqualityFeetToFeetDifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        boolean output = length1.equals(length2);
        assertFalse(output);
    }

    @Test
    public void testEqualityInchToInchDifferentValue() {
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
}
