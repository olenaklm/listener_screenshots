package org.example.uitests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionTests {

    @Test(expectedExceptions = ArithmeticException.class)
//    @Test
    public void testDivision() {
        int a = 5;
        int b = 0;
        Assert.assertEquals(a / b, 0 );
    }
}
