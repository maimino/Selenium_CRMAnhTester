package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KnowledgeBasePage {

    //Knowledge Base page
    private By menuKnowledgeBase = By.xpath("//span[normalize-space()='Knowledge Base']");
    private By buttonNewArticle = By.xpath("//a[normalize-space()='New Article']");
    private By buttonGroup = By.xpath("//a[normalize-space()='Groups']");
    private By inputSearchArticle = By.xpath("//input[@class='form-control input-sm']");
    private By firstItemArticleOnTable = By.xpath("//tbody/tr[1]/td[1]/child::a");
    private By headerArticleForm = By.xpath("//form[@id='article-form']//h4//span");

    //Form Add new article
    private By inputArticleName = By.xpath("//input[@id='subject']");
    private By dropdownGroup = By.xpath("//div[@app-field-wrapper='articlegroup']//button[@data-id='articlegroup']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper='articlegroup']/descendant::div[@class='dropdown-menu open']//input");
    private By iframeArticleDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputArticleDescription = By.xpath("//body[@data-id='description']");
    private By buttonSaveArticle = By.xpath("//div[@class='panel-footer text-right']//button[@type='submit'][normalize-space()='Save']");
    private By errorArticleName = By.xpath("//p[@id='subject-error']");
    private By errorGroup = By.xpath("//p[@id='articlegroup-error']");
    private By alertAddArticleSuccess = By.xpath("//span[@class='alert-title']"); //Article added successfully.

    //Function view, edit, delete
    private By buttonViewArticle = By.xpath("//tbody/tr[1]/td[1]//child::div//a[contains(text(),'View')]");
    private By buttonEditArticle = By.xpath("//tr[@class='has-row-options odd'][1]//div//a[contains(text(),'Edit')]");
    private By buttonDeleteArticle = By.xpath("//tbody/tr[1]/td[1]//child::div//a[contains(text(),'Delete')]");
    private By alertEditArticleSuccess = By.xpath("//span[@class='alert-title']"); //Article updated successfully.
    private By alertDeleteArticleSuccess = By.xpath("//span[@class='alert-title']"); //Article deleted

    public KnowledgeBasePage clickMenuKnowledgeBase(){
        WebUI.waitForElementVisible(menuKnowledgeBase);
        WebUI.clickElement(menuKnowledgeBase);
        return new KnowledgeBasePage();
    }

    public void verifyKnowledgeBasePage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("knowledge_base"), "Không đến được trang Knowledge Base.");
    }

    public void clickButtonNewArticle(){
        WebUI.waitForElementVisible(buttonNewArticle);
        WebUI.clickElement(buttonNewArticle);
    }

    public void addNewArticle(String ARTICLE_NAME, String GROUP, String ARTICLE_DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerArticleForm), "Không đến được trang Add new article.");
        Assert.assertEquals(WebUI.getTextElement(headerArticleForm), "Add new article", "Tiêu đề trang Add new article không đúng.");
        WebUI.setText(inputArticleName, ARTICLE_NAME);
        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputSearchGroup, GROUP);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeArticleDescription));
        WebUI.setText(inputArticleDescription, ARTICLE_DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveArticle);
    }

    public void verifyAddArticleSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddArticleSuccess), "Thông báo thêm mới article thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddArticleSuccess), "Article added successfully.", "Nội dung thông báo thêm mới article thành công không đúng.");
        LogUtils.info("Thêm mới article thành công.");
    }

    public void searchLead(String ARTICLE_NAME){
        WebUI.clickElement(menuKnowledgeBase);
        WebUI.clickElement(inputSearchArticle);
        WebUI.setText(inputSearchArticle, ARTICLE_NAME);
        WebUI.waitForElementVisible(firstItemArticleOnTable);
        Assert.assertTrue(WebUI.checkElementExist(firstItemArticleOnTable), "Không tìm thấy article vừa tạo mới.");
        WebUI.clickElement(firstItemArticleOnTable);
        LogUtils.info("Tìm thấy thành công article vừa tạo mới.");
    }

    public void addArticleWithSubjectNull(String GROUP, String ARTICLE_DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerArticleForm), "Không đến được trang Add new article.");
        Assert.assertEquals(WebUI.getTextElement(headerArticleForm), "Add new article", "Tiêu đề trang Add new article không đúng.");
        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputSearchGroup, GROUP);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeArticleDescription));
        WebUI.setText(inputArticleDescription, ARTICLE_DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveArticle);
    }

    public void verifyAddArticleWithSubjectNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới article không thành công do bỏ trống trường bắt buộc Subject.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorArticleName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorArticleName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addArticleWithGroupNull(String ARTICLE_NAME, String ARTICLE_DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerArticleForm), "Không đến được trang Add new article.");
        Assert.assertEquals(WebUI.getTextElement(headerArticleForm), "Add new article", "Tiêu đề trang Add new article không đúng.");
        WebUI.setText(inputArticleName, ARTICLE_NAME);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeArticleDescription));
        WebUI.setText(inputArticleDescription, ARTICLE_DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveArticle);
    }

    public void verifyAddArticleWithGroupNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới article không thành công do bỏ trống trường bắt buộc Group.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorGroup), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorGroup), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void clickButtonEditArticle(){
        WebUI.hoverElement(firstItemArticleOnTable);
        //WebUI.waitForElementVisible(buttonEditArticle);
        WebUI.clickElement(buttonEditArticle);
    }

    public void editArticle(String ARTICLE_NAME, String GROUP, String ARTICLE_DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputArticleName);
        WebUI.setText(inputArticleName, ARTICLE_NAME);
        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputSearchGroup, GROUP);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeArticleDescription));
        WebUI.clearText(inputArticleDescription);
        WebUI.setText(inputArticleDescription, ARTICLE_DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveArticle);
    }

    public void verifyEditArticleSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertEditArticleSuccess), "Thông báo cập nhật article thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertEditArticleSuccess), "Article updated successfully.", "Nội dung thông báo cập nhật article thành công không đúng.");
        LogUtils.info("Cập nhật article thành công.");
    }

    public void clickButtonDeleteArticle(){
        WebUI.hoverElement(firstItemArticleOnTable);
        WebUI.waitForElementVisible(buttonDeleteArticle);
        WebUI.clickElement(buttonDeleteArticle);
        WebUI.acceptAlert();
    }

    public void verifyDeleteArticleSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteArticleSuccess), "Thông báo xóa article thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteArticleSuccess), "Article deleted", "Nội dung thông báo xóa article thành công không đúng.");
        LogUtils.info("Xóa article thành công.");
    }
}
