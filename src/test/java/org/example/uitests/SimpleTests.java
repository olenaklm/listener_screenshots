package org.example.uitests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTests {

    @Test()
    public void testZero() {
        int a = 5;
        int b = 6;
        Assert.assertTrue(a < b);
    }

//    @Test(enabled = false)
    @Test(dependsOnMethods = "testZero")
    public void testOne() {
        int a = 5;
        int b = 6;
        Assert.assertTrue(a < b);
    }

    @Test(groups = {"regression"})
    public void testTwo() {
        int a = 5;
        int b = 6;
        Assert.assertTrue(a < b);
    }

    @Test(groups = {"smoke"})
    public void testThree() {
        int a = 5;
        int b = 6;
        Assert.assertTrue(a < b);
    }

    @Test(groups = {"smoke", "regression"})
    public void testFour() {
        int a = 5;
        int b = 6;
        Assert.assertTrue(a < b);
    }

    @Test(dependsOnGroups = {"regression.*", "smoke"})
//    @Test(dependsOnMethods = "testFour")
    public void testFive() {
        Assert.assertFalse(false);
    }

    @Test
    @Parameters("myName")
    public void parameterTest(String myName) {
        System.out.println("Parameterized value is : "
                + myName);
    }
}
