package com.anhtester.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ForgotPasswordPage {
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By headerForgotPage = By.xpath("//h1[normalize-space()='Forgot Password']");
    private By inputEmailForgot = By.xpath("//input[@id='email']");
    private By buttonConfirm = By.xpath("//button[normalize-space()='Confirm']");
    private By errorEmail = By.xpath("//div[normalize-space()='Email not found']");

    public void clicklinkForgotPassword(){
        WebUI.clickElement(linkForgotPassword);
    }

    public void setEmail(String email){
        WebUI.setText(inputEmailForgot, email);
    }

    public void clickConfirmButton(){
        WebUI.clickElement(buttonConfirm);
    }

    public void verifyForgotPassPage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerForgotPage), "Không đến được trang Forgot Password.");
        Assert.assertEquals(WebUI.getTextElement(headerForgotPage), "Forgot Password", "Tiêu đề trang Forgot Password không đúng.");
    }

    public void verifyForgotPassSuccess(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Email đã được gửi để đặt lại mật khẩu. Vui lòng kiểm tra hộp thư đến của bạn.");
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("forgot_password"), "Gửi email không thành công. Vẫn đang ở trang Forgot Password.");
    }

    public void verifyForgotPassFail(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Lấy lại mật khẩu thất bại do không tìm thấy email.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorEmail), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorEmail), "Email not found", "Nội dung thông báo lỗi không đúng.");
    }

    public LoginPage forgotPasswordCRM(String email){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        clicklinkForgotPassword();
        verifyForgotPassPage();
        setEmail(email);
        clickConfirmButton();

        return new LoginPage();
    }
}
