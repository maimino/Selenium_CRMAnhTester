package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class LeadsPage {

    //Lead Page
    private By buttonAddNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By inputSearchLead = By.xpath("//input[@class='form-control input-sm']");
    private By firstItemLeadOnTable = By.xpath("((//tr[@class='info has-row-options odd'])[1]//td)[3]/child::a");

    //Form Add new lead
    private By headerAddLeadForm = By.xpath("//h4[normalize-space()='Add new lead']");
    private By dropdownStatus = By.xpath("//label[@for='status']//following::button[@data-id='status']");
    private By inputSearchStatus = By.xpath("//div[@app-field-wrapper='status']/descendant::div//input[@type='search']");
    private By dropdownSource = By.xpath("//label[@for='source']/following::button[@data-id='source']");
    private By inputSearchSource = By.xpath("//div[@app-field-wrapper='source']/descendant::div//input[@type='search']");
    private By inputTags = By.xpath("//div[@id='inputTagsWrapper']//li[@class='tagit-new']");
    private By inputLeadName = By.xpath("(//div[@app-field-wrapper='name']//child::input[@id='name'])[2]");
    private By inputPosition = By.xpath("//div[@app-field-wrapper='title']//input[@id='title']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputLeadValue = By.xpath("//input[@name='lead_value']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By dropdownCountry = By.xpath("//div[@app-field-wrapper='country']//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']/descendant::div//input[@type='search']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By buttonSaveLead = By.xpath("//button[@id='lead-form-submit']");

    private By errorStatus = By.xpath("//p[@id='status-error']");
    private By errorSource = By.xpath("//p[@id='source-error']");
    private By errorLeadName = By.xpath("//p[@id='name-error']");
    private By alertAddLeadSuccess = By.xpath("//span[@class='alert-title']");
    private By headerLeadDialog = By.xpath("//div[@id='lead-modal']//h4[@class='modal-title']");
    private By buttonCloseLeadInfor = By.xpath("//div[@class='modal-content data']//span[@aria-hidden='true'][normalize-space()='×']");

    //Function view, edit, delete
    private By buttonViewLead = By.xpath("((//tr[@class='info has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'View')]");
    private By buttonEditLead = By.xpath("((//tr[@class='info has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteLead = By.xpath("((//tr[@class='info has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Delete')]");
    private By alertEditLeadSuccess = By.xpath("//span[@class='alert-title']");
    private By alertDeleteLeadSuccess = By.xpath("//span[@class='alert-title']");

    public void verifyLeadsPage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("leads"),"Không đến được trang Leads.");
    }

    public void clickButtonNewLead(){
        WebUI.waitForElementVisible(buttonAddNewLead);
        WebUI.clickElement(buttonAddNewLead);
    }

    public void addNewLead(String STATUS, String SOURCE, String LEAD_NAME, String POSITION, String EMAIL_ADDRESS, String WEBSITE, String PHONE, String LEAD_VALUE, String COMPANY, String ADDRESS, String CITY, String STATE, String COUNTRY, String ZIP_CODE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownStatus);
        WebUI.setText(inputSearchStatus, STATUS);
        WebUI.setKey(inputSearchStatus, Keys.ENTER);
        WebUI.clickElement(dropdownSource);
        WebUI.setText(inputSearchSource, SOURCE);
        WebUI.setKey(inputSearchSource, Keys.ENTER);
        WebUI.setText(inputLeadName, LEAD_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailAddress, EMAIL_ADDRESS);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputLeadValue, LEAD_VALUE);
        WebUI.setText(inputCompany, COMPANY);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveLead);
    }

    public void verifyAddLeadSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddLeadSuccess), "Thông báo thêm mới lead thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddLeadSuccess), "Lead added successfully.", "Nội dung thông báo thêm mới lead thành công không đúng.");
        LogUtils.info("Thêm mới lead thành công.");
    }

    public void addLeadWithStatusNull(String SOURCE, String LEAD_NAME, String POSITION, String EMAIL_ADDRESS, String WEBSITE, String PHONE, String LEAD_VALUE, String COMPANY, String ADDRESS, String CITY, String STATE, String COUNTRY, String ZIP_CODE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownSource);
        WebUI.setText(inputSearchSource, SOURCE);
        WebUI.setKey(inputSearchSource, Keys.ENTER);
        WebUI.setText(inputLeadName, LEAD_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailAddress, EMAIL_ADDRESS);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputLeadValue, LEAD_VALUE);
        WebUI.setText(inputCompany, COMPANY);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveLead);
    }

    public void verifyAddLeadWithStatusNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới lead không thành công do bỏ trống trường bắt buộc Status.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorStatus), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorStatus), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addLeadWithSourceNull(String STATUS, String LEAD_NAME, String POSITION, String EMAIL_ADDRESS, String WEBSITE, String PHONE, String LEAD_VALUE, String COMPANY, String ADDRESS, String CITY, String STATE, String COUNTRY, String ZIP_CODE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownStatus);
        WebUI.setText(inputSearchStatus, STATUS);
        WebUI.setKey(inputSearchStatus, Keys.ENTER);
        WebUI.setText(inputLeadName, LEAD_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailAddress, EMAIL_ADDRESS);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputLeadValue, LEAD_VALUE);
        WebUI.setText(inputCompany, COMPANY);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveLead);
    }

    public void verifyAddLeadWithSourceNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới lead không thành công do bỏ trống trường bắt buộc Source.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorSource), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorSource), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addLeadWithNameNull(String STATUS, String SOURCE, String POSITION, String EMAIL_ADDRESS, String WEBSITE, String PHONE, String LEAD_VALUE, String COMPANY, String ADDRESS, String CITY, String STATE, String COUNTRY, String ZIP_CODE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownStatus);
        WebUI.setText(inputSearchStatus, STATUS);
        WebUI.setKey(inputSearchStatus, Keys.ENTER);
        WebUI.clickElement(dropdownSource);
        WebUI.setText(inputSearchSource, SOURCE);
        WebUI.setKey(inputSearchSource, Keys.ENTER);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailAddress, EMAIL_ADDRESS);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputLeadValue, LEAD_VALUE);
        WebUI.setText(inputCompany, COMPANY);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveLead);
    }

    public void verifyAddLeadWithNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới lead không thành công do bỏ trống trường bắt buộc Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorLeadName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorLeadName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void clickButtonEditLead(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemLeadOnTable);
        WebUI.waitForElementClickable(buttonEditLead);
        WebUI.clickElement(buttonEditLead);
    }

    public void editLead(String STATUS, String SOURCE, String LEAD_NAME, String POSITION, String EMAIL_ADDRESS, String WEBSITE, String PHONE, String LEAD_VALUE, String COMPANY, String ADDRESS, String CITY, String STATE, String COUNTRY, String ZIP_CODE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownStatus);
        WebUI.setText(inputSearchStatus, STATUS);
        WebUI.setKey(inputSearchStatus, Keys.ENTER);
        WebUI.clickElement(dropdownSource);
        WebUI.setText(inputSearchSource, SOURCE);
        WebUI.setKey(inputSearchSource, Keys.ENTER);
        WebUI.clearText(inputLeadName);
        WebUI.setText(inputLeadName, LEAD_NAME);
        WebUI.clearText(inputPosition);
        WebUI.setText(inputPosition, POSITION);
        WebUI.clearText(inputEmailAddress);
        WebUI.setText(inputEmailAddress, EMAIL_ADDRESS);
        WebUI.clearText(inputWebsite);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, PHONE);
        WebUI.clearText(inputLeadValue);
        WebUI.setText(inputLeadValue, LEAD_VALUE);
        WebUI.clearText(inputCompany);
        WebUI.setText(inputCompany, COMPANY);
        WebUI.clearText(inputAddress);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.clearText(inputCity);
        WebUI.setText(inputCity, CITY);
        WebUI.clearText(inputState);
        WebUI.setText(inputState, STATE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clearText(inputZipCode);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.clearText(inputDescription);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveLead);
    }

    public void verifyEditLeadSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertEditLeadSuccess), "Thông báo cập nhật lead thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertEditLeadSuccess), "Lead updated successfully.", "Nội dung thông báo cập nhật lead thành công không đúng.");
        LogUtils.info("Cập nhật lead thành công.");
    }

    public void deleteLead(){
        WebUI.hoverElement(firstItemLeadOnTable);
        WebUI.waitForElementVisible(buttonDeleteLead);
        WebUI.clickElement(buttonDeleteLead);
        WebUI.acceptAlert();
    }

    public void verifyDeleteProjectSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteLeadSuccess), "Thông báo xóa lead thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteLeadSuccess), "Lead deleted", "Nội dung thông báo xóa lead thành công không đúng.");
        LogUtils.info("Xóa lead thành công.");
    }

    public void searchLead(String LEAD_NAME){
        WebUI.sleep(5);
        WebUI.waitForElementVisible(buttonCloseLeadInfor);
        WebUI.clickElement(buttonCloseLeadInfor);
        WebUI.clickElement(inputSearchLead);
        WebUI.setText(inputSearchLead, LEAD_NAME);
        WebUI.waitForElementVisible(firstItemLeadOnTable);
        Assert.assertTrue(WebUI.checkElementExist(firstItemLeadOnTable), "Không tìm thấy lead vừa tạo mới.");
        WebUI.clickElement(firstItemLeadOnTable);
        LogUtils.info("Tìm thấy thành công lead vừa tạo mới.");
    }
}
