package com.epam.tat.module4;


import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initTest() {
        calculator = new Calculator();
        System.out.println("Start");
    }

    @BeforeMethod(alwaysRun = true)
    public void methodStart() {
        System.out.println("Method start.");
        Timeout.sleep(1);
    }

    @Test(testName = "Addition with long values", dataProvider = "sumLong", dataProviderClass = TestDataProvider.class,
            groups = {"Addition"})
    public void testAddWithLongValues(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.sum(a, b), expectedResult);
    }

    @Test(testName = "Addition with double values", dataProvider = "sumDouble", dataProviderClass = TestDataProvider.class,
            groups = {"Addition"})
    public void testAddWithDoubleValues(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.sum(a, b), expectedResult);
    }

    @Test(testName = "Subtraction with long values", dataProvider = "subLong", dataProviderClass = TestDataProvider.class,
            groups = {"Subtraction"})
    public void testSubWithLongValues(long a, long b, double expectedResult){
        Assert.assertEquals(calculator.sub(a, b), expectedResult);
    }

    @Test(testName = "Subtraction with double values", dataProvider = "subDouble", dataProviderClass = TestDataProvider.class,
            groups = {"Subtraction"})
    public void testSubWithDoubleValues(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.sub(a, b), expectedResult);
    }

    @Test(testName = "Multiplication with long values", dataProvider = "multiLong", dataProviderClass = TestDataProvider.class,
    groups = {"Multiplication and division"})
    public void testMultiWithLongValues(long a, long b, double expectedResult){
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }

    @Test(testName = "Multiplication with double values", dataProvider = "multiDouble", dataProviderClass = TestDataProvider.class,
            groups = {"Multiplication and division"})
    public void testMultiWithDoubleValues(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }

    @Test(testName = "Division with long values", dataProvider = "divLong", dataProviderClass = TestDataProvider.class,
            groups = {"Multiplication and division"})
    public void testDivWithLongValues(long a, long b, double expectedResult){
        Assert.assertEquals(calculator.div(a, b), expectedResult);
    }

    @Test(testName = "Division with double values", dataProvider = "divDouble", dataProviderClass = TestDataProvider.class,
            groups = {"Multiplication and division"})
    public void testDivWithDoubleValues(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, .00001, "Validation failed for operation: " + calculator.div(a, b));
    }

    @Test
    @DisplayName("Attempt to divide by zero")
    public void divByZeroShouldThrowException() {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(624, 0));
        System.out.println("Attempt to divide by zero");
    }

    @Test(testName = "Pow test pass",dataProvider = "powData", dataProviderClass = TestDataProvider.class,
    groups = { "power pass" })
    public void testPowValid(double a, double b) {
       double expected = Math.pow(a, b);
       double actual = calculator.pow(a, b);
       Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "invalidData", dataProviderClass = TestDataProvider.class,
    groups = {"power"})
    @DisplayName("Pow test fail")
    public void powTestInvalidValues(double a, double b) {
        Assert.assertEquals(calculator.pow(a, b), Double.NaN);

    }

    @Test(testName = "Square root test", dataProvider = "sqrtData", dataProviderClass = TestDataProvider.class,
    groups = {"Square root"})
    public void testSqrt(double value) {
        double expected = Math.sqrt(value);
        double actual = calculator.sqrt(value);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "otherData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Cosines test")
    public void testCos(double value, double expected) {
        expected = Math.sin(value);
        double actual = calculator.cos(value);
        Assert.assertEquals(actual, expected, 0.0001, "Cosines calculation failed");
    }

    @Test(dataProvider = "otherData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Sine test")
    public void testSin(double value, double expected) {
        expected = Math.sin(value);
        double actual = calculator.sin(value);
        Assert.assertEquals(actual, expected, 0.00001, "Sine calculation failed");
    }

    @Test(dataProvider = "tgData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Tangent test")
    public void testTg(double value, double expected) {
        expected = calculator.sin(value) / calculator.cos(value);
        double actual = calculator.tg(value);
        Assert.assertEquals(actual, expected, 0.00001, "Tangent calculation failed");
    }

    @Test(dataProvider = "otherData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Cotangent test")
    public  void testCotangent (double value,double expected) {
        expected = Math.tanh(value);
        double actual = calculator.ctg(value);
        Assert.assertEquals(actual, expected, 0.00001, "Cotangent calculation failed");
    }
    @Test(dataProvider = "isPositiveValueData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Positive value test")
    public  void testIsPositiveValue (long value, boolean expected) {
        boolean actual = calculator.isPositive(value);
        Assert.assertEquals(actual, expected, "Calculation failed" + value);
    }

    @Test(dataProvider = "isNegativeValueData", dataProviderClass = TestDataProvider.class)
    @DisplayName("Negative value test")
    public void testIsNegativeValue(long value, boolean expected) {
        boolean actual = calculator.isNegative(value);
        Assert.assertEquals(actual, expected, "Calculation failed" + value);
    }


    @AfterMethod
    public void methodEnd() {
        System.out.println("Method end.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("The end.");
    }
}
