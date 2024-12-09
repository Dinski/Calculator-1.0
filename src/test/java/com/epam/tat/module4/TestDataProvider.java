package com.epam.tat.module4;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "sumLong")
    public static Object[][] sumLong() {
        return new Object[][] {
                {1234567890123456789L, 987654321098765432L , 2.22222221122222234E18},
        };
    }

    @DataProvider(name = "sumDouble")
    public static Object[][] sumDouble() {
        return new Object[][] {
                {2859.36, 147859.47, 150718.83},
        };
    }
    @DataProvider(name = "subLong")
    public static Object[][] subLong() {
        return new Object[][] {
                {1234567890123456789L, 987654321098765432L , 2.4691356902469136E17},
        };
    }

    @DataProvider(name = "subDouble")
    public static Object[][] subDouble() {
        return new Object[][] {
                {147859.47, 2859.36, 145000.11000000002 },
        };
    }

    @DataProvider(name = "multiLong")
    public static Object[][] multiLong() {
        return new Object[][] {
                {1234567890123456789L, 987654321098765432L , -8.7920952570261494E18},
        };
    }

    @DataProvider(name = "multiDouble")
    public static Object[][] multiDouble() {
        return new Object[][] {
                {124.0, 938.0, 116312.00 },
        };
    }


    @DataProvider(name = "divLong")
    public static Object[][] divLong() {
        return new Object[][] {
                {9223372036854775807L, 1234567890123456789L , 7.0},
        };
    }

    @DataProvider(name = "divDouble")
    public static Object[][] divDouble() {
        return new Object[][] {
                {124.0, 938.0, 0.13219616204690832 },
                {124.0, 0, 0.13219616204690832}
        };
    }

    @DataProvider(name = "powData")
    public static Object[][] powData() {
        return new Object[][] {
                {3.0, 4.0},
                {2.32, 6}
        };
    }

    @DataProvider(name = "sqrtData")
    public static Object[][] sqrtData() {
        return new Object[][] {
                {144.0},
                {11.0},
                {4.0}
        };
    }

    @DataProvider(name = "otherData")
    public static Object[][] othertData() {
        return new Object[][] {
                {0, 0.0},
                {Math.PI / 4, 1.0},
                {Math.PI, 0.0},
                {-Math.PI / 4, -1.0},
                {Math.PI / 3, Math.sqrt(3)},
        };
    }

    @DataProvider(name = "tgData")
    public static Object[][] tgData() {
        return new Object[][] {
                {0, 0.0},
                {4/8, 0.5},
                {Math.PI, 0.0},
                {-6, -0.10510424},
                {Math.PI / 3, Math.sqrt(3)},
        };
    }

    @DataProvider(name = "invalidData")
    public static Object[][] invalidData() {
        return new Object[][] {
                {Double.NaN, 1},
                {Double.NaN, Double.NaN,}
        };
    }

    @DataProvider(name = "isPositiveValueData")
    public static Object[][] isPositiveValueData() {
        return new Object[][]{
                {0L, false},
                {1L, true},
                {-1L, false},
                {9223372036854775807L, true},
                {-9223372036854775808L, false}
        };
    }

    @DataProvider(name = "isNegativeValueData")
    public static Object[][] isNegativeValueData() {
        return new Object[][]{
                {0L, false},
                {1L, false},
                {-1L, true},
                {9223372036854775807L, false},
                {-9223372036854775808L, true}
        };
    }

}