package com.sysco.api_automation.api.util;

import com.sysco.api_automation.api.data.EmployeeData;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class TestBase {

    private SyscoLabListener testListeners;
    protected static SoftAssert softAssert = new SoftAssert();
    protected static EmployeeData employeeData = new EmployeeData();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        testListeners = new SyscoLabListener();
        System.out.println("Running " + this.getClass().toString());
    }


    @AfterMethod(alwaysRun = true)
    public void updateQCenter(ITestContext iTestContext) {
    }
}
