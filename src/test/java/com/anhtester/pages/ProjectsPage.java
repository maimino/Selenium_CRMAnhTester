package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ProjectsPage {

    //Projects Page
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By headerProjectsPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By buttonAddNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By inputSearchProject = By.xpath("//div[@id='projects_filter']//input[@type='search']");
    private By firstItemProjectOnTable = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::a");

    //Form Add new project
    private By headerAddNewProject = By.xpath("//h4[normalize-space()='Add new project']");
    private By inputProjectName = By.xpath("//label[normalize-space()='* Project Name']//following-sibling::input");
    private By dropdownCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//button");
    private By inputSearchCustomer = By.xpath("//label[@for='clientid']//following-sibling::div//input[@type='search']");
    private By resultSearchCustomer = By.xpath("//div[@class='dropdown-menu open']//descendant::ul//a[@id='bs-select-6-0']//span[@class='text']");
    private By checkboxCaculateProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By sliderProgress = By.xpath("//label[contains(normalize-space(),'Progress')]//following-sibling::div//span[contains(@class,'slider')]");
    private By dropdownBillingType = By.xpath("//label[@for='billing_type']/following-sibling::div//button[@data-id='billing_type']");
    //private By dropdownBillingType = By.xpath("//label[@for='billing_type']//following-sibling::div[contains(@class,'dropdown')]");
    private By optionFixedRate = By.xpath("//span[normalize-space()='Fixed Rate']");
    private By dropdownStatus = By.xpath("//label[normalize-space()='Status']//following-sibling::div[contains(@class,'dropdown')]");
    private By optionInProgress = By.xpath("//span[normalize-space()='In Progress']");
    private By inputTotalRate = By.xpath("//label[normalize-space()='Total Rate']//following-sibling::input");
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By dropdownMembers = By.xpath("//label[@for='project_members[]']//following-sibling::div[contains(@class,'dropdown')]");
    private By inputSearchMembers = By.xpath("//label[@for='project_members[]']//following-sibling::div//input[@type='search']");
    private By optionMember = By.xpath("//ul[@class='dropdown-menu inner ']//child::a[@id='bs-select-3-1']//span[@class='text']");
    private By inputStartDate = By.xpath("//label[@for='start_date']//following-sibling::div//input");
    private By inputDeadline = By.xpath("//label[@for='deadline']//following-sibling::div//input");
    private By inputTag = By.xpath("//label[normalize-space()='Tags']//following-sibling::ul//input");
    private By inputDescription = By.xpath("//body[@data-id='description']");
    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By checkboxSendEmail = By.xpath("//input[@id='send_created_email']");
    private By buttonSaveProject = By.xpath("//button[normalize-space()='Save']");

    private By errorProjectName = By.xpath("//p[@id='name-error']");
    private By errorCustomer = By.xpath("//p[@id='clientid-error']");
    private By errorBillingType = By.xpath("//p[@id='billing_type-error']");
    private By alertAddProjectSuccess = By.xpath("//span[@class='alert-title']");

    //Function view, edit, delete
    private By buttonViewProject = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'View')]");
    private By buttonCoppyProject = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Copy Project')]");
    private By buttonEditProject = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteProject = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[2]/child::div//a[contains(text(),'Delete')]");
    private By alertUpdateProjectSuccess = By.xpath("//span[@class='alert-title']");
    private By alertDeleteProjectSuccess = By.xpath("//span[@class='alert-title']");
    private By headerEditProjectPage = By.xpath("//h4[normalize-space()='Edit Project']");

    //Detail project
    private By headerProjectNameDetail = By.xpath("//div[@id='project_view_name']//descendant::div[@class='filter-option-inner-inner']");
    private By headerCutomerDetail = By.xpath("//div[@id='project_view_name']//descendant::div[@class='filter-option-inner-inner']//small");
    private By statusProjectCurrent = By.xpath("//div[@id='project_view_name']/following-sibling::span");
    private By buttonNewTask = By.xpath("//div[@class='col-md-5 text-right']//a[normalize-space()='New Task']");
    private By buttonMore = By.xpath("//div[@class='col-md-5 text-right']//button[normalize-space()='More']");
    private By optionStatusMarkOnHold = By.xpath("//button[@data-toggle='dropdown']//following-sibling::ul//a[@data-name='On Hold']");
    private By optionStatusMarkInProgress = By.xpath("//button[@data-toggle='dropdown']//following-sibling::ul//a[@data-name='In Progress']");
    private By buttonConfirmChangeStatusProject = By.xpath("//div[@class='modal-content']//button[@id='project_mark_status_confirm']");
    private By alertUpdateStatusProjectSuccess = By.xpath("//span[@class='alert-title']");

    //Form Add new task
    private By inputSubject = By.xpath("(//label[@for='name']/following-sibling::input[@id='name'])[3]");
    private By inputStartDateTask = By.xpath("//input[@id='startdate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
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
    private By buttonTask = By.xpath("//a[@data-group='project_tasks']");
    private By headerTaskPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By searchTask = By.xpath("//div[@id='related_tasks_filter']//input[@type='search']");
    private By firstItemTaskOnTable = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[3]/child::a");
    private By buttonEditTask = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Edit')]");
    private By buttonDeleteTask = By.xpath("((//tr[@class='has-row-options odd'])[1]//td)[3]/child::div//a[contains(text(),'Delete')]");
    private By alertDeleteTaskSuccess = By.xpath("//span[@class='alert-title']");


    public void verifyProjectsPage(){
        WebUI.waitForElementVisible(headerProjectsPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerProjectsPage),"Không đến được trang Projects.");
        Assert.assertEquals(WebUI.getTextElement(headerProjectsPage), "Projects Summary", "Tiêu đề trang Projects không đúng.");
    }

    public void clickButtonNewProject(){
        WebUI.waitForElementVisible(buttonAddNewProject);
        WebUI.clickElement(buttonAddNewProject);
    }

    public void verifyAddNewProjectPage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerAddNewProject), "Không đến được trang Add new project.");
        Assert.assertEquals(WebUI.getTextElement(headerAddNewProject), "Add new project", "Tiêu đề không đúng.");
    }

    public void addNewProject(String PROJECT_NAME, String CUSTOMER, String TOTAL_RATE, String ESTIMATE_HOUR, String START_DATE,String DEADLINE, String DESCRIPTION){
        WebUI.setText(inputProjectName, PROJECT_NAME);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.clickElement(dropdownBillingType);
        WebUI.clickElement(optionFixedRate);
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(optionInProgress);
        WebUI.setText(inputTotalRate, TOTAL_RATE);
        WebUI.setText(inputEstimatedHours, ESTIMATE_HOUR);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputDeadline, DEADLINE);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeDescription));
        WebUI.setText(inputDescription, DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveProject);
    }

    public void verifyAddProjectSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddProjectSuccess), "Thông báo thêm mới project thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddProjectSuccess), "Project added successfully.", "Nội dung thông báo thêm mới project thành công không đúng.");
        LogUtils.info("Thêm mới project thành công.");
    }

    public void addNewProjectWithProjectNameNull(String CUSTOMER, String TOTAL_RATE, String ESTIMATE_HOUR, String START_DATE,String DEADLINE, String DESCRIPTION){
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.clickElement(dropdownBillingType);
        WebUI.clickElement(optionFixedRate);
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(optionInProgress);
        WebUI.setText(inputTotalRate, TOTAL_RATE);
        WebUI.setText(inputEstimatedHours, ESTIMATE_HOUR);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputDeadline, DEADLINE);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeDescription));
        WebUI.setText(inputDescription, DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveProject);
    }

    public void verifyAddProjectWithProjectNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới project không thành công do bỏ trống trường bắt buộc Project Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorProjectName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorProjectName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addNewProjectWithCustomerNull(String PROJECT_NAME, String TOTAL_RATE, String ESTIMATE_HOUR, String START_DATE,String DEADLINE, String DESCRIPTION){
        WebUI.setText(inputProjectName, PROJECT_NAME);
        WebUI.clickElement(dropdownBillingType);
        WebUI.clickElement(optionFixedRate);
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(optionInProgress);
        WebUI.setText(inputTotalRate, TOTAL_RATE);
        WebUI.setText(inputEstimatedHours, ESTIMATE_HOUR);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.setText(inputDeadline, DEADLINE);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeDescription));
        WebUI.setText(inputDescription, DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveProject);
    }

    public void verifyAddProjectWithCustomerNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới project không thành công do bỏ trống trường bắt buộc Customer.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorCustomer), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorCustomer), "Select and begin typing", "Nội dung thông báo lỗi không đúng.");
    }

    public void clickButtonEditProject(){
        WebUI.hoverElement(firstItemProjectOnTable);
        WebUI.waitForElementVisible(buttonEditProject);
        WebUI.clickElement(buttonEditProject);
    }

    public void verifyEditProjectPage(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerEditProjectPage), "Không đến được trang Edit Project.");
        Assert.assertEquals(WebUI.getTextElement(headerEditProjectPage), "Edit Project", "Tiêu đề trang Edit Project không đúng.");
    }

    public void editProject(String PROJECT_NAME, String CUSTOMER, String TOTAL_RATE, String ESTIMATE_HOUR, String START_DATE,String DEADLINE, String DESCRIPTION){
        WebUI.clearText(inputProjectName);
        WebUI.setText(inputProjectName, PROJECT_NAME);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer, CUSTOMER);
        WebUI.waitForElementVisible(resultSearchCustomer);
        WebUI.clickElement(resultSearchCustomer);
        WebUI.clickElement(dropdownBillingType);
        WebUI.clickElement(optionFixedRate);
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(optionInProgress);
        WebUI.clearText(inputTotalRate);
        WebUI.setText(inputTotalRate, TOTAL_RATE);
        WebUI.clearText(inputEstimatedHours);
        WebUI.setText(inputEstimatedHours, ESTIMATE_HOUR);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate, START_DATE);
        WebUI.clearText(inputDeadline);
        WebUI.setText(inputDeadline, DEADLINE);
        DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeDescription));
        WebUI.clearText(inputDescription);
        WebUI.setText(inputDescription, DESCRIPTION);
        DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveProject);
    }

    public void verifyUpdateProjectSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateProjectSuccess), "Thông báo cập nhật project thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateProjectSuccess), "Project updated successfully.", "Nội dung thông báo cập nhật project thành công không đúng.");
        LogUtils.info("Cập nhật project thành công.");
    }

    public void deleteProject(){
        WebUI.hoverElement(firstItemProjectOnTable);
        WebUI.waitForElementVisible(buttonDeleteProject);
        WebUI.clickElement(buttonDeleteProject);
        WebUI.acceptAlert();
    }

    public void verifyDeleteProjectSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteProjectSuccess), "Thông báo xóa project thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteProjectSuccess), "Project deleted", "Nội dung thông báo xóa project thành công không đúng.");
        LogUtils.info("Xóa project thành công.");
    }

    //Tim kiem project vua tao moi
    public void searchAndVerifyProject(String PROJECT_NAME){
        WebUI.clickElement(menuProjects);
        WebUI.clickElement(inputSearchProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstItemProjectOnTable), "Không tìm thấy project vừa tạo mới.");
        LogUtils.info("Tìm thấy thành công project vừa tạo mới.");
    }

    public void searchProject(String PROJECT_NAME){
        WebUI.clickElement(inputSearchProject);
        WebUI.setText(inputSearchProject, PROJECT_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstItemProjectOnTable), "Không tìm thấy project vừa tạo mới.");
        WebUI.clickElement(firstItemProjectOnTable);
    }

    public void clickButtonViewProject(){
        WebUI.hoverElement(firstItemProjectOnTable);
        WebUI.waitForElementVisible(buttonViewProject);
        WebUI.clickElement(buttonViewProject);
    }

    public void changeStatusProject(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonMore);
        WebUI.clickElement(optionStatusMarkOnHold);
        WebUI.clickElement(buttonConfirmChangeStatusProject);
    }

    public void verifyChangeStatusPojectSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateStatusProjectSuccess), "Thông báo thay đổi trạng thái project thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateStatusProjectSuccess), "Project marked as On Hold successfully", "Nội dung thông báo thay đổi trạng thái project thành công không đúng.");
        LogUtils.info("Thay đổi trạng thái project thành công.");
    }

    public void clickButtonNewTask(){
        WebUI.waitForElementClickable(buttonNewTask);
        WebUI.clickElement(buttonNewTask);
    }

    public void addNewTask(String SUBJECT, String START_DATE, String DUE_DATE, String FOLLOWER, String TASK_DESCRIPTION){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.clearText(inputStartDateTask);
        WebUI.setText(inputStartDateTask, START_DATE);
        WebUI.setText(inputDueDate, DUE_DATE);
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(optionLowPriority);
        WebUI.clickElement(dropdownFollowers);
        WebUI.setText(inputSearchFollower, FOLLOWER);
        WebUI.setKey(inputSearchFollower, Keys.ENTER);
        WebUI.clickElement(dropdownFollowers);
        WebUI.clickElement(formAddDescriptionTask);
        //DriverManager.getDriver().switchTo().frame(WebUI.getWebElement(iframeDescriptionTask));
        //WebUI.setText(inputDescriptionTask, TASK_DESCRIPTION);
        //DriverManager.getDriver().switchTo().parentFrame();
        WebUI.clickElement(buttonSaveTask);
    }

    public void searchTask(String SUBJECT){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(buttonCloseFormTask);
        WebUI.clickElement(buttonCloseFormTask);
        WebUI.clickElement(buttonTask);
        Assert.assertTrue(WebUI.checkElementDisplay(headerTaskPage));
        WebUI.clickElement(searchTask);
        WebUI.setText(searchTask, SUBJECT);
        WebUI.waitForElementVisible(firstItemTaskOnTable);
        Assert.assertTrue(WebUI.checkElementExist(firstItemTaskOnTable), "Không tìm thấy task vừa tạo mới.");
        WebUI.clickElement(firstItemTaskOnTable);
        LogUtils.info("Tìm thấy thành công task vừa tạo mới.");
    }

    public void clickTask(){
        WebUI.clickElement(buttonTask);
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
}
