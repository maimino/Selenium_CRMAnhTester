package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.ForgotPasswordPage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ForgotPasswordPage forgotPasswordPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");
//
//        loginPage.loginCRM(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email",2),
                excelHelper.getCellData("password", 2)
        );
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email",3),
                excelHelper.getCellData("password", 3)
        );
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithEmailNull(){
        loginPage = new LoginPage();
        loginPage.loginWithEmailNull(ConfigData.PASSWORD);
        loginPage.verifyLoginEmailNull();
    }

    @Test
    public void testLoginWithPasswordNull(){
        loginPage = new LoginPage();
        loginPage.loginWithPasswordNull(ConfigData.EMAIL);
        loginPage.verifyLoginPasswordNull();
    }

    @Test
    public void testForgotPassword(){
        loginPage = new LoginPage();
        forgotPasswordPage = loginPage.forgotPassCRM();
        forgotPasswordPage.verifyForgotPassPage();
    }
}
