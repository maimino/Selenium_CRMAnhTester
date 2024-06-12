package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class TasksPage {

    //Task Page
    private By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By buttonAddNewTask = By.xpath("//a[normalize-space()='New Task']");
    private By inputSearchTask = By.xpath("//input[@class='form-control input-sm']");
    private By firstItemTaskOnTable = By.xpath("//tr[@class='has-row-options odd']//td[3]");
    private By headerEditTaskForm = By.xpath("//h4[@id='myModalLabel']");
    private By buttonTasksOverView = By.xpath("//a[normalize-space()='Tasks Overview']");

    //Form Add new task
    private By inputSubject = By.xpath("//input[@id='name']");
    private By inputStartDateTask = By.xpath("//input[@id='startdate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By dropdownPriority = By.xpath("//label[normalize-space()='Priority']/following-sibling::div//button[@data-id='priority']");
    private By optionLowPriority = By.xpath("//span[normalize-space()='Low']");
    private By dropdownFollowers = By.xpath("//label[normalize-space()='Followers']/following::button[@data-id='followers[]']");
    private By inputSearchFollower = By.xpath("//label[normalize-space()='Followers']/following-sibling::div//input[@type='search']");
    private By optionFollower = By.xpath("//ul[@class='dropdown-menu inner ']//child::a[@id='bs-select-10-1']//span[@class='text']");
    private By inputTagTask = By.xpath("//input[@placeholder='Tag']");
    private By formAddDescriptionTask = By.xpath("//div[@class='form-group no-mbot']//textarea[@id='description']");
    private By inputDescriptionTask = By.xpath("//body[@id='tinymce']");
    private By iframeDescriptionTask = By.xpath("//iframe[@id='description_ifr']");
    private By buttonSaveTask = By.xpath("//div[@role='document']//button[@type='submit'][normalize-space()='Save']");
    private By buttonCloseFormTask = By.xpath("//div[@class='modal-header task-single-header']//button[@aria-label='Close']");
    private By alertAddTaskSuccess = By.xpath("//span[@class='alert-title']");
    private By errorSubject = By.xpath("//p[@id='name-error']");

    //Function edit, delete
    private By buttonEditTask = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteTask = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Delete')]");
    private By alertDeleteTaskSuccess = By.xpath("//span[@class='alert-title']");
    private By alertEditTaskSuccess = By.xpath("//span[@class='alert-title']");

    //Task overview
    private By headerMonth = By.xpath("//h4[@class='bold tw-mb-6 text-success']");
    private By dropdownMonth = By.xpath("//div[@class='dropdown bootstrap-select bs3']//button[@data-id='month']");
    private By inputMonth = By.xpath("//div[@app-field-wrapper='month']/descendant::div[@class='dropdown-menu open']//input[@type='search']");
    //private By resultSearchMonth = By.xpath("//div[@app-field-wrapper='month']/descendant::div[@class='inner open']//ul//a[@role='option']");
    private By buttonFilter = By.xpath("//button[normalize-space()='Filter']");
    private By filterMonth = By.xpath("//div[@app-field-wrapper='month']//descendant::div[@class='filter-option-inner-inner']");

    public void verifyTasksPage(){
        WebUI.waitForElementVisible(headerTasksPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerTasksPage),"Không đến được trang Tasks.");
        Assert.assertEquals(WebUI.getTextElement(headerTasksPage), "Tasks Summary", "Tiêu đề trang Tasks không đúng.");
    }

    public void clickButtonNewTask(){
        WebUI.waitForElementVisible(buttonAddNewTask);
        WebUI.clickElement(buttonAddNewTask);
    }

    public void addNewTask(String SUBJECT, String HOURLY_RATE,String START_DATE, String DUE_DATE, String FOLLOWER){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.clearText(inputHourlyRate);
        WebUI.setText(inputHourlyRate, HOURLY_RATE);
        WebUI.clearText(inputStartDateTask);
        WebUI.setText(inputStartDateTask, START_DATE);
        WebUI.setText(inputDueDate, DUE_DATE);
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(optionLowPriority);
        WebUI.clickElement(dropdownFollowers);
        WebUI.setText(inputSearchFollower, FOLLOWER);
        WebUI.setKey(inputSearchFollower, Keys.ENTER);
        WebUI.clickElement(dropdownFollowers);
        WebUI.clickElement(buttonSaveTask);
    }

    public void verifyAddTaskSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddTaskSuccess), "Thông báo thêm mới task thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddTaskSuccess), "Task added successfully.", "Nội dung thông báo thêm mới task thành công không đúng.");
        LogUtils.info("Thêm mới task thành công.");
    }

    public void addNewTaskWithSubjectNull(String HOURLY_RATE,String START_DATE, String DUE_DATE, String FOLLOWER){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputHourlyRate);
        WebUI.setText(inputHourlyRate, HOURLY_RATE);
        WebUI.clearText(inputStartDateTask);
        WebUI.setText(inputStartDateTask, START_DATE);
        WebUI.setText(inputDueDate, DUE_DATE);
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(optionLowPriority);
        WebUI.clickElement(dropdownFollowers);
        WebUI.setText(inputSearchFollower, FOLLOWER);
        WebUI.setKey(inputSearchFollower, Keys.ENTER);
        WebUI.clickElement(dropdownFollowers);
        WebUI.clickElement(buttonSaveTask);
    }

    public void verifyAddTaskFail(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới task không thành công do bỏ trống trường bắt buộc Subject.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorSubject), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorSubject), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void deleteTask(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemTaskOnTable);
        WebUI.clickElement(buttonDeleteTask);
        WebUI.acceptAlert();
    }

    public void verifyDeleteTaskSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteTaskSuccess), "Thông báo xóa task thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteTaskSuccess), "Task deleted", "Nội dung thông báo xóa task thành công không đúng.");
        LogUtils.info("Xóa task thành công.");
    }

    public void searchTask(String SUBJECT){
        WebUI.sleep(5);
        WebUI.waitForElementVisible(buttonCloseFormTask);
        WebUI.clickElement(buttonCloseFormTask);
        WebUI.clickElement(inputSearchTask);
        WebUI.setText(inputSearchTask, SUBJECT);
        WebUI.waitForElementVisible(firstItemTaskOnTable);
        Assert.assertTrue(WebUI.checkElementExist(firstItemTaskOnTable), "Không tìm thấy task vừa tạo mới.");
        WebUI.clickElement(firstItemTaskOnTable);
        LogUtils.info("Tìm thấy thành công task vừa tạo mới.");
    }

    public void clickButtonEditTask(){
        WebUI.waitForPageLoaded();
        WebUI.hoverElement(firstItemTaskOnTable);
        WebUI.clickElement(buttonEditTask);
    }

    public void editTask(String SUBJECT, String START_DATE, String DUE_DATE){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerEditTaskForm), "Không đến được form Edit Task.");
        WebUI.clearText(inputSubject);
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.clearText(inputStartDateTask);
        WebUI.setText(inputStartDateTask, START_DATE);
        WebUI.clearText(inputDueDate);
        WebUI.setText(inputDueDate, DUE_DATE);
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(optionLowPriority);
        WebUI.clickElement(buttonSaveTask);
    }

    public void verifyEditTaskSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertEditTaskSuccess), "Thông báo cập nhật task thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertEditTaskSuccess), "Task updated successfully.", "Nội dung thông báo cập nhật task thành công không đúng.");
        LogUtils.info("Cập nhật task thành công.");
    }

    public void clickButtonTaskOverView(){
        WebUI.waitForElementVisible(buttonTasksOverView);
        WebUI.clickElement(buttonTasksOverView);
    }

    public void filterTaskByMonth(String MONTH){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonFilter);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownMonth);
        WebUI.setText(inputMonth, MONTH);
        WebUI.setKey(inputMonth, Keys.ENTER);
        WebUI.clickElement(buttonFilter);
    }

    public void verifyFilterTaskByMonth(){
        WebUI.waitForPageLoaded();
        Assert.assertEquals(WebUI.getTextElement(headerMonth), WebUI.getTextElement(filterMonth), "Kết quả lọc không đúng");
        LogUtils.info("Lọc thành công task theo tháng.");
    }
}
