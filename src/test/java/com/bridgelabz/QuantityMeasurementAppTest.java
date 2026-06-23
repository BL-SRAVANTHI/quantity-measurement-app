package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        boolean actualValue = feet1.equals(feet2);
        assertTrue(actualValue);
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);
        boolean actualValue = feet1.equals(feet2);
        assertFalse(actualValue);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        boolean actualValue = feet1.equals(null);
        assertFalse(actualValue);
    }

    @Test
    public void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        boolean actualValue = feet1.equals("hello");
        assertFalse(actualValue);
    }

    @Test
    public void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        boolean actualValue = feet1.equals(feet1);
        assertTrue(actualValue);
    }

    @Test
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(1.0);
        boolean actualValue = inch1.equals(inch2);
        assertTrue(actualValue);
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(2.0);
        boolean actualValue = inch1.equals(inch2);
        assertFalse(actualValue);
    }

    @Test
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        boolean actualValue = inches.equals(null);
        assertFalse(actualValue);
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        boolean actualValue = inches.equals("hello");
        assertFalse(actualValue);
    }

    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        boolean actualValue = inches.equals(inches);
        assertTrue(actualValue);
    }
}
