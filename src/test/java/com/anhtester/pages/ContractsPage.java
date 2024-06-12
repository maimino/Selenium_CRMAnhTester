package com.anhtester.pages;

import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ContractsPage {
    private By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    private By headerContractsPage = By.xpath("//span[normalize-space()='Contract Summary']");
    private By buttonAddContract = By.xpath("//a[normalize-space()='New Contract']");
    private By inputSearchContract = By.xpath("//input[@class='form-control input-sm']");
    private By firstItemContractOnTable = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]");

    //Form Add new contract
    private By headerFormContract = By.xpath("//h4[normalize-space()='Contract Information']");
    private By dropdownCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//input[@type='search']");
    private By resultSearchCustomer = By.xpath("//button[@data-id='clientid']/following::ul[@class='dropdown-menu inner ']//a[@role='option']");
    private By dropdownProject = By.xpath("//label[normalize-space()='Project']//following::div//button[@data-id='project_id']");
    private By inputSearchProject = By.xpath("(//label[normalize-space()='Project']//following::div//input[@aria-autocomplete='list'])[1]");
    private By resultSearchProject = By.xpath("(//div[@id='project_ajax_search_wrapper']/descendant::ul//a[@role='option'])[1]");
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By inputContractValue = By.xpath("//label[normalize-space()='Contract Value']/following-sibling::div//input[@type='number']");
    private By dropdownContractType = By.xpath("//label[normalize-space()='Contract type']/following::div//button[@data-id='contract_type']");
    private By inputSearchContractType = By.xpath("//div[@class='dropdown-menu open']//descendant::input[@class='form-control' and @aria-controls='bs-select-1']");
    private By inputStartDate = By.xpath("//input[@id='datestart']");
    private By inputEndDate = By.xpath("//input[@id='dateend']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By buttonSaveContract = By.xpath("//div[@class='btn-bottom-toolbar text-right']//button[normalize-space()='Save']");
    private By alertAddContractSuccess = By.xpath("//span[@class='alert-title']");

    private By errorCustomer = By.xpath("//p[@id='clientid-error']");
    private By errorSubject = By.xpath("//p[@id='subject-error']");
    private By errorStartDate = By.xpath("//p[@id='datestart-error']");

    //Function view, edit, delete
    private By buttonViewContract = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'View')]");
    private By buttonEditContract = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteContract = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Delete')]");
    private By alertEditContractSuccess = By.xpath("//span[@class='alert-title']"); //Contract updated successfully.
    private By alertDeleteContractSuccess = By.xpath("//span[@class='alert-title']");

    public ContractsPage clickMenuContracts(){
        WebUI.waitForElementVisible(menuContracts);
        WebUI.clickElement(menuContracts);
        return new ContractsPage();
    }

    public void verifyContractsPage(){
        WebUI.waitForElementVisible(headerContractsPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerContractsPage),"Không đến được trang Contracts.");
        Assert.assertEquals(WebUI.getTextElement(headerContractsPage), "Contract Summary", "Tiêu đề trang Contracts không đúng.");
    }

    public void clickButtonAddNewContract(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddContract);
    }

    public void addNewContract(String CUSTOMER, String PROJECT_NAME, String SUBJECT, String CONTRACT_VALUE, String CONTRACT_TYPE, String START_DATE, String END_DATE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerFormContract), "Không đến được trang Contract Information.");
        Assert.assertEquals(WebUI.getTextElement(headerFormContract), "Contract Information", "Tiêu đề không đúng.");
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.setText(inputContractValue, CONTRACT_VALUE);
        WebUI.clickElement(dropdownContractType);
        WebUI.setText(inputSearchContractType, CONTRACT_TYPE);
        WebUI.setKey(inputSearchContractType, Keys.ENTER);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputEndDate, END_DATE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveContract);
    }

    public void verifyAddNewContractSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddContractSuccess), "Thông báo thêm mới contract thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddContractSuccess), "Contract added successfully.", "Nội dung thông báo thêm mới contract thành công không đúng.");
        LogUtils.info("Thêm mới contract thành công.");
    }

    public void addContractWithCustomerNull(String SUBJECT, String CONTRACT_VALUE, String CONTRACT_TYPE, String START_DATE, String END_DATE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerFormContract), "Không đến được trang Contract Information.");
        Assert.assertEquals(WebUI.getTextElement(headerFormContract), "Contract Information", "Tiêu đề không đúng.");
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.setText(inputContractValue, CONTRACT_VALUE);
        WebUI.clickElement(dropdownContractType);
        WebUI.setText(inputSearchContractType, CONTRACT_TYPE);
        WebUI.setKey(inputSearchContractType, Keys.ENTER);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputEndDate, END_DATE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveContract);
    }

    public void verifyAddContractWithCustomerNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contract không thành công do bỏ trống trường bắt buộc Customer.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorCustomer), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorCustomer), "Select and begin typing", "Nội dung thông báo lỗi không đúng.");
    }

    public void addContractWithSubjectNull(String CUSTOMER, String PROJECT_NAME, String CONTRACT_VALUE, String CONTRACT_TYPE, String START_DATE, String END_DATE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerFormContract), "Không đến được trang Contract Information.");
        Assert.assertEquals(WebUI.getTextElement(headerFormContract), "Contract Information", "Tiêu đề không đúng.");
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.setText(inputContractValue, CONTRACT_VALUE);
        WebUI.clickElement(dropdownContractType);
        WebUI.setText(inputSearchContractType, CONTRACT_TYPE);
        WebUI.setKey(inputSearchContractType, Keys.ENTER);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputEndDate, END_DATE);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveContract);
    }

    public void verifyAddContractWithSubjectNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contract không thành công do bỏ trống trường bắt buộc Subject.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorSubject), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorSubject), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void deleteContract(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemContractOnTable);
        WebUI.waitForElementVisible(buttonDeleteContract);
        WebUI.clickElement(buttonDeleteContract);
        WebUI.acceptAlert();
    }

    public void verifyDeleteContractSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteContractSuccess), "Thông báo xóa contract thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteContractSuccess), "Contract deleted", "Nội dung thông báo xóa contract thành công không đúng.");
        LogUtils.info("Xóa contract thành công.");
    }

    public void searchContract(String SUBJECT){
        WebUI.clickElement(inputSearchContract);
        WebUI.setText(inputSearchContract, SUBJECT);
        Assert.assertTrue(WebUI.checkElementExist(firstItemContractOnTable), "Không tìm thấy contract vừa tạo mới.");
        LogUtils.info("Tìm thấy thành công contract vừa tạo mới.");
        WebUI.clickElement(firstItemContractOnTable);
    }

    public void clickButtonEditContract(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemContractOnTable);
        WebUI.waitForElementVisible(buttonEditContract);
        WebUI.clickElement(buttonEditContract);
    }

    public void editContract(String CUSTOMER, String PROJECT_NAME, String SUBJECT, String CONTRACT_VALUE, String CONTRACT_TYPE, String START_DATE, String END_DATE, String DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.clearText(inputSubject);
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.clearText(inputContractValue);
        WebUI.setText(inputContractValue, CONTRACT_VALUE);
        WebUI.clickElement(dropdownContractType);
        WebUI.setText(inputSearchContractType, CONTRACT_TYPE);
        WebUI.setKey(inputSearchContractType, Keys.ENTER);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.clearText(inputEndDate);
        WebUI.setText(inputEndDate, END_DATE);
        WebUI.clearText(inputDescription);
        WebUI.setText(inputDescription, DESCRIPTION);
        WebUI.clickElement(buttonSaveContract);
    }

    public void verifyUpdateContractSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertEditContractSuccess), "Thông báo cập nhật contract thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertEditContractSuccess), "Contract updated successfully.", "Nội dung thông báo cập nhật contract thành công không đúng.");
        LogUtils.info("Cập nhật contract thành công.");
    }
}
