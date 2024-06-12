package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ExpensesPage {

    //Expenses Page
    private By buttonAddRecordExpense = By.xpath("//a[normalize-space()='Record Expense']");
    private By buttonImportRecordExpense = By.xpath("//a[normalize-space()='Import Expenses']']");
    private By inputSearchRecordExpense = By.xpath("//input[@class='form-control input-sm']");
    private By firstItemRecordOnTable = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]");
    private By headerExpenseCategory = By.xpath("//h3[@id='expenseCategory']");
    private By headerEditExpense = By.xpath("//h4[normalize-space()='Edit Expense']");

    //Form Add record expense
    private By headerAddNewExpense = By.xpath("//h4[normalize-space()='Add new Expense']");
    private By inputExpenseName = By.xpath("//input[@id='expense_name']");
    private By inputNote = By.xpath("//textarea[@id='note']");
    private By dropdownExpenseCategory = By.xpath("//label[@for='category']/following::div//button[@data-id='category']");
    private By inputSearchExpenseCategory = By.xpath("//label[@for='category']/following::div//input[@aria-controls='bs-select-2']");
    private By inputExpenseDate = By.xpath("//input[@id='date']");
    private By inputAmount = By.xpath("//input[@id='amount']");
    private By dropdownCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//input[@type='search']");
    private By resultSearchCustomer = By.xpath("(//button[@data-id='clientid']/following::ul[@class='dropdown-menu inner ']//a[@role='option'])[1]");
    private By dropdownProject = By.xpath("//label[normalize-space()='Project']//following::div//button[@data-id='project_id']");
    private By inputSearchProject = By.xpath("//label[normalize-space()='Project']//following::div//input[@aria-controls='bs-select-11']");
    private By resultSearchProject = By.xpath("(//div[@id='project_ajax_search_wrapper']/descendant::ul//a[@role='option'])[1]");
    private By buttonSaveRecordExpense = By.xpath("//div[@class='btn-bottom-toolbar text-right']//button[@type='submit']");
    private By dropdownPaymentMode = By.xpath("//label[normalize-space()='Payment Mode']/following::div//button[@data-id='paymentmode']");
    private By inputSearchPaymentMode = By.xpath("//label[normalize-space()='Payment Mode']//following::div//input[@aria-controls='bs-select-6']");

    private By errorExpenseCategory = By.xpath("//p[@id='category-error']");
    private By errorAmount = By.xpath("//p[@id='amount-error']");
    private By errorExpenseDate = By.xpath("//p[@id='date-error']");
    private By alertAddRecordExpenseSuccess = By.xpath("//span[@class='alert-title']");

    //Function view, edit, delete
    private By buttonViewRecordExpense = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'View')]");
    private By buttonEditRecordExpense = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteRecordExpense = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[normalize-space()='Delete']");
    private By alertEditRecordExpenseSuccess = By.xpath("//span[@class='alert-title']");
    private By alertDeleteRecordExpenseSuccess = By.xpath("//span[@class='alert-title']");

    public void verifyExpensesPage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("expenses"), "Không đến được trang Expenses.");
    }

    public void clickButtonAddRecordExpense(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddRecordExpense);
    }

    public void addRecordExpense(String EXPENSE_NAME, String NOTE, String EXPENSE_CATEGORY, String EXPENSE_DATE, String AMOUNT, String CUSTOMER, String PROJECT_NAME, String PAYMENT_MODE){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerAddNewExpense), "Không đến được trang Add new Expense.");
        Assert.assertEquals(WebUI.getTextElement(headerAddNewExpense), "Add new Expense", "Tiêu đề không đúng.");
        WebUI.setText(inputExpenseName, EXPENSE_NAME);
        WebUI.setText(inputNote, NOTE);
        WebUI.clickElement(dropdownExpenseCategory);
        WebUI.setText(inputSearchExpenseCategory, EXPENSE_CATEGORY);
        WebUI.setKey(inputSearchExpenseCategory, Keys.ENTER);
        WebUI.clearText(inputExpenseDate);
        WebUI.setText(inputExpenseDate, EXPENSE_DATE);
        WebUI.setText(inputAmount, AMOUNT);
        WebUI.scrollToElement(dropdownCustomer);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setText(inputSearchPaymentMode, PAYMENT_MODE);
        WebUI.setKey(inputSearchPaymentMode, Keys.ENTER);
        WebUI.clickElement(buttonSaveRecordExpense);
    }

    public void verifyAddRecordExpenseSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddRecordExpenseSuccess), "Thông báo thêm mới expense thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddRecordExpenseSuccess), "Expense added successfully.", "Nội dung thông báo thêm mới expense thành công không đúng.");
        LogUtils.info("Thêm mới record expense thành công.");
    }

    public void addRecordExpenseWithExpenseCategoryNull(String EXPENSE_NAME, String NOTE, String EXPENSE_DATE, String AMOUNT, String CUSTOMER, String PROJECT_NAME, String PAYMENT_MODE){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerAddNewExpense), "Không đến được trang Add new Expense.");
        Assert.assertEquals(WebUI.getTextElement(headerAddNewExpense), "Add new Expense", "Tiêu đề không đúng.");
        WebUI.setText(inputExpenseName, EXPENSE_NAME);
        WebUI.setText(inputNote, NOTE);
        WebUI.clearText(inputExpenseDate);
        WebUI.setText(inputExpenseDate, EXPENSE_DATE);
        WebUI.setText(inputAmount, AMOUNT);
        WebUI.scrollToElement(dropdownCustomer);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setText(inputSearchPaymentMode, PAYMENT_MODE);
        WebUI.setKey(inputSearchPaymentMode, Keys.ENTER);
        WebUI.clickElement(buttonSaveRecordExpense);
    }

    public void verifyAddRecordExpenseWithExpenseCategoryNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới expense không thành công do bỏ trống trường bắt buộc Expense Category.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorExpenseCategory), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorExpenseCategory), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addRecordExpenseWithAmountNull(String EXPENSE_NAME, String NOTE, String EXPENSE_CATEGORY, String EXPENSE_DATE, String CUSTOMER, String PROJECT_NAME, String PAYMENT_MODE){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerAddNewExpense), "Không đến được trang Add new Expense.");
        Assert.assertEquals(WebUI.getTextElement(headerAddNewExpense), "Add new Expense", "Tiêu đề không đúng.");
        WebUI.setText(inputExpenseName, EXPENSE_NAME);
        WebUI.setText(inputNote, NOTE);
        WebUI.clickElement(dropdownExpenseCategory);
        WebUI.setText(inputSearchExpenseCategory, EXPENSE_CATEGORY);
        WebUI.setKey(inputSearchExpenseCategory, Keys.ENTER);
        WebUI.clearText(inputExpenseDate);
        WebUI.setText(inputExpenseDate, EXPENSE_DATE);
        WebUI.scrollToElement(dropdownCustomer);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setText(inputSearchPaymentMode, PAYMENT_MODE);
        WebUI.setKey(inputSearchPaymentMode, Keys.ENTER);
        WebUI.clickElement(buttonSaveRecordExpense);
    }

    public void verifyAddRecordExpenseWithAmountNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới expense không thành công do bỏ trống trường bắt buộc Amount.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorAmount), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorAmount), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void clickButtonEditRecordExpense(){
        WebUI.hoverElement(firstItemRecordOnTable);
        WebUI.waitForElementVisible(buttonEditRecordExpense);
        WebUI.clickElement(buttonEditRecordExpense);
    }

    public void verifyEditExpensePage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerEditExpense), "Không đến được trang Edit Expense.");
        Assert.assertEquals(WebUI.getTextElement(headerEditExpense), "Edit Expense", "Tiêu đề trang Edit Expense không đúng.");
    }

    public void editRecordExpense(String EXPENSE_NAME, String NOTE, String EXPENSE_CATEGORY, String EXPENSE_DATE, String AMOUNT, String CUSTOMER, String PROJECT_NAME, String PAYMENT_MODE){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputExpenseName);
        WebUI.setText(inputExpenseName, EXPENSE_NAME);
        WebUI.clearText(inputNote);
        WebUI.setText(inputNote, NOTE);
        WebUI.clickElement(dropdownExpenseCategory);
        WebUI.setText(inputSearchExpenseCategory, EXPENSE_CATEGORY);
        WebUI.setKey(inputSearchExpenseCategory, Keys.ENTER);
        WebUI.clearText(inputExpenseDate);
        WebUI.setText(inputExpenseDate, EXPENSE_DATE);
        WebUI.clearText(inputAmount);
        WebUI.setText(inputAmount, AMOUNT);
        WebUI.scrollToElement(dropdownCustomer);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.waitForElementVisible(dropdownProject);
        WebUI.clickElement(dropdownProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        WebUI.waitForElementVisible(resultSearchProject);
        WebUI.clickElement(resultSearchProject);
        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setText(inputSearchPaymentMode, PAYMENT_MODE);
        WebUI.setKey(inputSearchPaymentMode, Keys.ENTER);
        WebUI.clickElement(buttonSaveRecordExpense);
    }

    public void verifyUpdateExpenseSuccess(){
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementDisplay(alertEditRecordExpenseSuccess), "Thông báo cập nhật expense thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertEditRecordExpenseSuccess), "Expense updated successfully.", "Nội dung thông báo cập nhật expense thành công không đúng.");
        LogUtils.info("Cập nhật expense thành công.");
    }

    public void deleteRecordExpense(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemRecordOnTable);
        WebUI.waitForElementVisible(buttonDeleteRecordExpense);
        WebUI.clickElement(buttonDeleteRecordExpense);
        WebUI.acceptAlert();
    }

    public void verifyDeleteRecordExpenseSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteRecordExpenseSuccess), "Thông báo xóa expense thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteRecordExpenseSuccess), "Expense deleted", "Nội dung thông báo xóa expense thành công không đúng.");
        LogUtils.info("Xóa expense thành công.");
    }

    public void searchRecordExpense(String EXPENSE_NAME){
        WebUI.clickElement(inputSearchRecordExpense);
        WebUI.setText(inputSearchRecordExpense, EXPENSE_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstItemRecordOnTable), "Không tìm thấy project vừa tạo mới.");
        WebUI.clickElement(firstItemRecordOnTable);
    }
}
