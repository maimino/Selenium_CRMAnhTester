package com.anhtester.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    //Khai báo các element dạng đối tượng By(phương thức tìm kiếm)
    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By checkboxRemember = By.xpath("//input[@id='remember']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessage = By.xpath("//div[@id='alerts']");
    private By errorNoEmail = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By errorNoPassword = By.xpath("//div[normalize-space()='The Password field is required.']");

    private void setEmail(String email){
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password){
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton(){
        WebUI.clickElement(buttonLogin);
    }

    public ForgotPasswordPage clicklinkForgotPassword(){
        WebUI.clickElement(linkForgotPassword);
        return new ForgotPasswordPage();
    }

    public void verifyHeaderLoginPage(){
        WebUI.waitForElementVisible(headerLoginPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerLoginPage), "Không đến được trang Login.");
        Assert.assertEquals(WebUI.getTextElement(headerLoginPage), "Login","Tiêu đề trang Login không đúng.");
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Vẫn đang ở trang Login.");
        LogUtils.info("Đăng nhập thành công");
    }

    public void verifyLoginFail(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Đăng nhập thất bại");
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Không còn ở trang Login.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorMessage), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorMessage), "Invalid email or password", "Nội dung thông báo lỗi không đúng.");
    }

    public void verifyLoginEmailNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Đăng nhập thất bại do để trống trường Email.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorNoEmail),"Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorNoEmail), "The Email Address field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void verifyLoginPasswordNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Đăng nhập thất bại do để trống trường Password.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorNoPassword),"Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorNoPassword), "The Password field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    //Cac ham xu ly chinh cho trang login
    public DashboardPage loginCRM(String email, String password){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        verifyHeaderLoginPage();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage(); //tao lien ket giua cac trang
    }

    public void loginWithEmailNull(String password){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        verifyHeaderLoginPage();
        setPassword(password);
        clickLoginButton();
    }

    public void loginWithPasswordNull(String email){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        verifyHeaderLoginPage();
        setEmail(email);
        clickLoginButton();
    }

    public ForgotPasswordPage forgotPassCRM(){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        verifyHeaderLoginPage();
        clicklinkForgotPassword();
        return new ForgotPasswordPage();
    }
}
