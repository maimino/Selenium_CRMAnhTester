package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.ForgotPasswordPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;

    @Test
    public void testForgotPasswordSuccess(){
        forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.forgotPasswordCRM(ConfigData.EMAIL);
        forgotPasswordPage.verifyForgotPassSuccess();
    }

    @Test
    public void testForgotPasswordWithEmailInvalid(){
        forgotPasswordPage = new ForgotPasswordPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        forgotPasswordPage.forgotPasswordCRM(
                excelHelper.getCellData("email",2)
        );
        forgotPasswordPage.verifyForgotPassFail();
    }
}
