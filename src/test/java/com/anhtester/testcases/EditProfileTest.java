package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.EditProfilePage;
import com.anhtester.pages.LoginPage;
import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {
    LoginPage loginPage;
    EditProfilePage editProfilePage;
    DashboardPage dashboardPage;

    @Test
    public void testUpdateProfile() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.updateProfile(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("FACEBOOK", 1),
                excelHelper.getCellData("LINKEDLN", 1),
                excelHelper.getCellData("SKYPE", 1),
                excelHelper.getCellData("EMAIL_SIGNATURE", 1)
        );

        editProfilePage.verifyUpdateProfileSuccess();
    }

    @Test
    public void testUpdateProfileWithFirstNameNull() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.updateProfileWithFirstNameNull(
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("FACEBOOK", 1),
                excelHelper.getCellData("LINKEDLN", 1),
                excelHelper.getCellData("SKYPE", 1),
                excelHelper.getCellData("EMAIL_SIGNATURE", 1)
        );

        editProfilePage.verifyUpdateProfileFirstNameNull();
    }

    @Test
    public void testUpdateProfileWithLastNameNull() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.updateProfileWithLastNameNull(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("FACEBOOK", 1),
                excelHelper.getCellData("LINKEDLN", 1),
                excelHelper.getCellData("SKYPE", 1),
                excelHelper.getCellData("EMAIL_SIGNATURE", 1)
        );

        editProfilePage.verifyUpdateProfileLastNameNull();
    }

    @Test
    public void testChangePassword() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.changePassword(
                excelHelper.getCellData("OLD_PASSWORD", 1),
                excelHelper.getCellData("NEW_PASSWORD", 1)
        );

        editProfilePage.verifyChangePasswordSuccess();


    }

    @Test
    public void testChangePasswordWithOldPassNull() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.changePasswordWithOldPassNull(
                excelHelper.getCellData("NEW_PASSWORD", 1)
        );

        editProfilePage.verifyChangePassOldpassNull();
    }

    @Test
    public void testChangePasswordWithNewPassNull() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.changePasswordWithNewPassNull(
                excelHelper.getCellData("OLD_PASSWORD", 1)
        );

        editProfilePage.verifyChangePassNewpassNull();
    }

    @Test
    public void testChangePasswordWithRepeatPassNull() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.changePasswordWithRepeatPassNull(
                excelHelper.getCellData("OLD_PASSWORD", 1),
                excelHelper.getCellData("NEW_PASSWORD", 1)
        );

        editProfilePage.verifyChangePassRepeatpassNull();
    }

    @Test
    public void testChangePasswordWithOldPassInvalid() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.changePassword(
                excelHelper.getCellData("OLD_PASSWORD", 2),
                excelHelper.getCellData("NEW_PASSWORD", 2)
        );

        editProfilePage.verifyUpdatePasswordFail();
    }

//    @Test
//    public void testSelectDisabledTwoFactorAuth() {
//        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
//        loginPage.verifyLoginSuccess();
//
//        editProfilePage = dashboardPage.viewEditProfile();
//        editProfilePage.verifyEditProfilePage();
//
//        editProfilePage.selectDisabledTwoFactorAuth();
//    }


    @Test
    public void testProfileAfterEdit() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "EditProfile");
        editProfilePage.verifyProfileAfterEdit(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("FACEBOOK", 1),
                excelHelper.getCellData("LINKEDLN", 1),
                excelHelper.getCellData("SKYPE", 1),
                excelHelper.getCellData("EMAIL_SIGNATURE", 1)
        );
    }
}
