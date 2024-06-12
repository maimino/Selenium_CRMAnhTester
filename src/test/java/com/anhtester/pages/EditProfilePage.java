package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EditProfilePage {

    //Form profile
    private By userName = By.xpath("//form[@id='staff_profile_table']/preceding-sibling::h4");
    private By deleteImageProfile = By.xpath("//div[@class='panel-body']/descendant::i[@class='fa fa-remove']");
    private By inputFileUpload = By.xpath("//input[@id='profile_image']");
    private By inputFirstName = By.xpath("//input[@name='firstname']");
    private By inputLastName = By.xpath("//input[@name='lastname']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By optionSystemDefault = By.xpath("//span[normalize-space()='System Default']");
    private By dropdownDirection = By.xpath("//button[@data-id='direction']");
    private By optionLTR = By.xpath("//span[normalize-space()='LTR']");
    private By inputFacebook = By.xpath("//input[@name='facebook']");
    private By inputLinkedln = By.xpath("//input[@name='linkedin']");
    private By inputSkype = By.xpath("//input[@name='skype']");
    private By inputEmailSignature = By.xpath("//textarea[@id='email_signature']");
    private By buttonSaveEditProfile = By.xpath("(//div[@class='panel-footer text-right'])[1]//button");
    private By errorFirstName = By.xpath("//p[@id='firstname-error']");
    private By errorLastName = By.xpath("//p[@id='lastname-error']");
    private By alertUpdateProfileSuccess = By.xpath("//span[@class='alert-title']");

    //Change password
    private By inputOldPassword = By.xpath("//input[@id='oldpassword']");
    private By inputNewPassword = By.xpath("//input[@id='newpassword']");
    private By inputRepeatNewPassword = By.xpath("//input[@id='newpasswordr']");
    private By buttonSavePassword = By.xpath("//div[@class='panel-footer']//button");
    private By errorOldPassword = By.xpath("//p[@id='oldpassword-error']");
    private By errorNewPassword = By.xpath("//p[@id='newpassword-error']");
    private By errorRepeatNewPassword = By.xpath("//p[@id='newpasswordr-error']");
    private By alertUpdatePasswordSuccess = By.xpath("//span[@class='alert-title']");
    private By alertUpdatePasswordFail = By.xpath("//span[@class='alert-title']");

    //Two Factor Authentication
    private By radioDisabled = By.xpath("//input[@id='two_factor_auth_disabled']");
    private By radioEnableEmail = By.xpath("//label[normalize-space()='Enable Email Two Factor Authentication']");
    private By radioEnableGoogle = By.xpath("//input[@id='google_two_factor_auth_enabled']");
    private By alertUpdateAuthenSuccess = By.xpath("//span[@class='alert-title']");

    public void verifyEditProfilePage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("edit_profile"), "Không đến được trang Edit Profile.");
    }

    public void verifyUpdateProfileSuccess(){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(userName);
        WebUI.waitForElementVisible(alertUpdateProfileSuccess);
        Assert.assertEquals(WebUI.getTextElement(userName), WebUI.getAttributeElement(inputFirstName, "value") + " " + WebUI.getAttributeElement(inputLastName, "value"), "Chỉnh sửa profile không thành công.");
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateProfileSuccess), "Thông báo cập nhật profile thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateProfileSuccess), "Your Profile has Been Updated", "Nội dung thông báo cập nhật profile thành công không đúng.");
        LogUtils.info("Cập nhật profile thành công.");
    }

    public void verifyProfileAfterEdit(String FIRST_NAME, String LAST_NAME, String PHONE, String FACEBOOK, String LINKEDLN, String SKYPE, String EMAIL_SIGNATURE){
        WebUI.waitForPageLoaded();
        Assert.assertEquals(WebUI.getAttributeElement(inputFirstName, "value"), FIRST_NAME, "First Name không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputLastName, "value"), LAST_NAME, "Last Name không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputPhone, "value"), PHONE, "Phone không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(dropdownLanguage, "title"), "System Default", "Language không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(dropdownDirection, "title"), "LTR", "Direction không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputFacebook, "value"), FACEBOOK, "Facebook không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputLinkedln, "value"), LINKEDLN, "Linkedln không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputSkype, "value"), SKYPE, "Skype không đúng.");
        Assert.assertEquals(WebUI.getTextElement(inputEmailSignature), EMAIL_SIGNATURE, "Email signature không đúng.");
    }

    public void verifyUpdateProfileFirstNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Chỉnh sửa profile không thành công do bỏ trống trường bắt buộc First Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorFirstName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorFirstName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void verifyUpdateProfileLastNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Chỉnh sửa profile không thành công do bỏ trống trường bắt buộc Last Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorLastName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorLastName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void updateProfile(String FIRST_NAME, String LAST_NAME, String PHONE, String FACEBOOK, String LINKEDLN, String SKYPE, String EMAIL_SIGNATURE){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(deleteImageProfile);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputFileUpload, System.getProperty("user.dir") + "/src/test/resources/testdata/chimmy.jpg");
        WebUI.clearText(inputFirstName);
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.clearText(inputLastName);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, PHONE);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionSystemDefault);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.clearText(inputFacebook);
        WebUI.setText(inputFacebook, FACEBOOK);
        WebUI.clearText(inputLinkedln);
        WebUI.setText(inputLinkedln, LINKEDLN);
        WebUI.clearText(inputSkype);
        WebUI.setText(inputSkype, SKYPE);
        WebUI.clearText(inputEmailSignature);
        WebUI.setText(inputEmailSignature, EMAIL_SIGNATURE);
        WebUI.clickElement(buttonSaveEditProfile);
    }

    public void updateProfileWithFirstNameNull(String LAST_NAME, String PHONE, String FACEBOOK, String LINKEDLN, String SKYPE, String EMAIL_SIGNATURE){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(deleteImageProfile);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputFileUpload, System.getProperty("user.dir") + "/src/test/resources/testdata/chimmy.jpg");
        WebUI.clearText(inputFirstName);
        WebUI.clearText(inputLastName);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, PHONE);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionSystemDefault);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.clearText(inputFacebook);
        WebUI.setText(inputFacebook, FACEBOOK);
        WebUI.clearText(inputLinkedln);
        WebUI.setText(inputLinkedln, LINKEDLN);
        WebUI.clearText(inputSkype);
        WebUI.setText(inputSkype, SKYPE);
        WebUI.clearText(inputEmailSignature);
        WebUI.setText(inputEmailSignature, EMAIL_SIGNATURE);
        WebUI.clickElement(buttonSaveEditProfile);
    }

    public void updateProfileWithLastNameNull(String FIRST_NAME, String PHONE, String FACEBOOK, String LINKEDLN, String SKYPE, String EMAIL_SIGNATURE){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(deleteImageProfile);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputFileUpload, System.getProperty("user.dir") + "/src/test/resources/testdata/chimmy.jpg");
        WebUI.clearText(inputFirstName);
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.clearText(inputLastName);
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, PHONE);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionSystemDefault);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.clearText(inputFacebook);
        WebUI.setText(inputFacebook, FACEBOOK);
        WebUI.clearText(inputLinkedln);
        WebUI.setText(inputLinkedln, LINKEDLN);
        WebUI.clearText(inputSkype);
        WebUI.setText(inputSkype, SKYPE);
        WebUI.clearText(inputEmailSignature);
        WebUI.setText(inputEmailSignature, EMAIL_SIGNATURE);
        WebUI.clickElement(buttonSaveEditProfile);
    }

    public void verifyChangePasswordSuccess(){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(alertUpdatePasswordSuccess);
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdatePasswordSuccess), "Thông báo thay đổi password thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdatePasswordSuccess), "Your password has been changed", "Nội dung thông báo thay đổi password thành công không đúng.");
        LogUtils.info("Thay đổi password thành công");
    }

    public void changePassword(String OLD_PASSWORD, String NEW_PASSWORD){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputOldPassword, OLD_PASSWORD);
        WebUI.setText(inputNewPassword, NEW_PASSWORD);
        WebUI.setText(inputRepeatNewPassword, NEW_PASSWORD);
        WebUI.clickElement(buttonSavePassword);
    }

    public void verifyChangePassOldpassNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thay đổi password không thành công do bỏ trống trường bắt buộc Old password.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorOldPassword), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorOldPassword), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void changePasswordWithOldPassNull(String NEW_PASSWORD){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputNewPassword,NEW_PASSWORD);
        WebUI.setText(inputRepeatNewPassword, NEW_PASSWORD);
        WebUI.clickElement(buttonSavePassword);
    }

    public void verifyChangePassNewpassNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thay đổi password không thành công do bỏ trống trường bắt buộc New password.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorNewPassword), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorNewPassword), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void changePasswordWithNewPassNull(String OLD_PASSWORD){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputOldPassword,OLD_PASSWORD);
        WebUI.clickElement(buttonSavePassword);
    }

    public void verifyChangePassRepeatpassNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thay đổi password không thành công do bỏ trống trường Repeat new password.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorRepeatNewPassword), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorRepeatNewPassword), "Please enter the same value again.", "Nội dung thông báo lỗi không đúng.");
    }

    public void changePasswordWithRepeatPassNull(String OLD_PASSWORD, String NEW_PASSWORD){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputOldPassword,OLD_PASSWORD);
        WebUI.setText(inputNewPassword,NEW_PASSWORD);
        WebUI.clickElement(buttonSavePassword);
    }

    public void verifyUpdatePasswordFail(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Lỗi mật khẩu cũ không chính xác.");
        WebUI.waitForElementVisible(alertUpdatePasswordFail);
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdatePasswordFail), "Thông báo mật khẩu cũ sai không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdatePasswordFail), "Your old password is incorrect", "Nội dung thông báo mật khẩu cũ sai không đúng.");
    }

    public void verifyUpdateAuthenSuccess(){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(alertUpdateAuthenSuccess);
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateAuthenSuccess), "Thông báo cập nhật xác thực 2 yếu tố thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateAuthenSuccess), "Successfully updated two factor authentication settings", "Nội dung thông báo cập nhật xác thực 2 yếu tố thành công không đúng.");
        LogUtils.info("Cập nhật cài đặt xác thực 2 yếu tố thành công");
    }

//    public void selectDisabledTwoFactorAuth() {
//        WebElement checkRadioEnableEmail = WebUI.getWebElement(radioEnableEmail); // Tìm kiếm radio button "Disabled" trên trang web và lưu nó vào biến radioDisabledButton
//        if (!checkRadioEnableEmail.isSelected()) { // Kiểm tra xem radio button "Disabled" đã được chọn hay chưa
//            WebUI.clickElement(radioEnableEmail); // Nếu radio button "Disabled" chưa được chọn, thực hiện thao tác click để chọn nó
//        }
//    }
}
