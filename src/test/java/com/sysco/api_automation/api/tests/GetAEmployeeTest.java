package com.sysco.api_automation.api.tests;

import com.jayway.restassured.response.Response;
import com.sysco.api_automation.api.common.StatusCodes;
import com.sysco.api_automation.api.response.model.EmployeeModel;
import com.sysco.api_automation.api.util.TestBase;
import com.sysco.api_automation.api.requests.functions.Project;
import com.sysco.api_automation.api.util.ResponseUtil;
import org.json.JSONException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class GetAEmployeeTest extends TestBase {

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "  AEmployeeData - ValidAEmployeeData");
    }

    @Test(description = "Get employee data", alwaysRun = true)
    public static void testGetEmployeesData() throws JSONException{
        Response employeeList = Project.getEmployeeProjects();
        String data = ResponseUtil.getValueFromResponse(employeeList, "data");
        EmployeeModel employeeModel = (EmployeeModel) ResponseUtil.getDataObjectValueInDataArray(data, 0, EmployeeModel.class);
        softAssert.assertEquals(ResponseUtil.getStatus(employeeList), StatusCodes.SUCCESS_200_CODE, "Status is wrong");
        softAssert.assertEquals(employeeModel.id, employeeData.getID(), "Employee ID is incorrect");
        softAssert.assertEquals(employeeModel.getEmployee_name(), employeeData.getEmployee_name(), "Employee name is incorrect");
        softAssert.assertEquals(employeeModel.getEmployee_salary(), employeeData.getEmployee_salary(), "Employee salary it incorrect");
        softAssert.assertEquals(employeeModel.getEmployee_age(), employeeData.getEmployee_age(), "Employee age is incorrect");
        softAssert.assertEquals(employeeModel.getProfile_image(), employeeData.getProfile_image(), "profile image not loaded");
        softAssert.assertAll();
    }
}
