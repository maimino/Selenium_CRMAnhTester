package com.anhtester.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class DashboardPage {

    //Menu
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuSales = By.xpath("//li[@class='menu-item-sales']//descendant::span[normalize-space()='Sales']");
    private By menuSubscriptions = By.xpath("//span[normalize-space()='Subscriptions']");
    private By menuExpenses = By.xpath("//li[@class='menu-item-expenses']/descendant::span[normalize-space()='Expenses']");
    private By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    private By menuSupport = By.xpath("//span[normalize-space()='Support']");
    private By menuLeads = By.xpath("//li[@class='menu-item-leads']/descendant::span[normalize-space()='Leads']");
    private By menuEstimateRequest = By.xpath("//span[normalize-space()='Estimate Request']");
    private By menuKnowledgeBase = By.xpath("//span[normalize-space()='Knowledge Base']");
    private By menuUltilities = By.xpath("//span[normalize-space()='Utilities']");
    private By menuReports = By.xpath("//span[normalize-space()='Reports']");

    //Profile
    private By inputSearchDashboard = By.xpath("//input[@id='search_input']");
    private By dropdownProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By optionMyProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");
    private By optionMyTimesheets = By.xpath("(//a[normalize-space()='My Timesheets'])[2]");
    private By optionEditProfile = By.xpath("(//a[normalize-space()='Edit Profile'])[2]");
    private By optionLanguage = By.xpath("//a[normalize-space()='Language']");
    private By optionLogout = By.xpath("(//a[normalize-space()='Logout'])[2]");

    //Add New To Do
    private By buttonNewToDo = By.xpath("//a[normalize-space()='New To Do']");
    private By headerAddNewToDoForm = By.xpath("//span[normalize-space()='Add New Todo']");
    private By inputDescription = By.xpath("(//textarea[@id='description'])[1]");
    private By buttonSaveNewToDo = By.xpath("//form[@id='add_new_todo_item']/descendant::button[@type='submit']");

    public void clickMenuDashboard(){
        WebUI.waitForElementVisible(menuDashboard);
        WebUI.clickElement(menuDashboard);
    }

    public CustomersPage clickMenuCustomers(){
        WebUI.waitForElementVisible(menuCustomers);
        WebUI.clickElement(menuCustomers);
        return new CustomersPage();
    }

    public ExpensesPage clickMenuExpenses(){
        WebUI.waitForElementVisible(menuExpenses);
        WebUI.clickElement(menuExpenses);
        return new ExpensesPage();
    }

    public ContractsPage clickMenuContracts(){
        WebUI.waitForElementVisible(menuContracts);
        WebUI.clickElement(menuContracts);
        return new ContractsPage();
    }

    public ProjectsPage clickMenuProjects(){
        WebUI.waitForElementVisible(menuProjects);
        WebUI.clickElement(menuProjects);
        return new ProjectsPage();
    }

    public TasksPage clickMenuTasks(){
        WebUI.waitForElementVisible(menuTasks);
        WebUI.clickElement(menuTasks);
        return new TasksPage();
    }

    public LeadsPage clickMenuLeads(){
        WebUI.waitForElementVisible(menuLeads);
        WebUI.clickElement(menuLeads);
        return new LeadsPage();
    }

    public KnowledgeBasePage clickMenuKnowledgeBase(){
        WebUI.waitForElementVisible(menuKnowledgeBase);
        WebUI.clickElement(menuKnowledgeBase);
        return new KnowledgeBasePage();
    }

    public void viewMyProfile(){
        WebUI.clickElement(dropdownProfile);
        WebUI.waitForElementVisible(optionMyProfile);
        WebUI.clickElement(optionMyProfile);
    }

    public void viewMyTimesheets(){
        WebUI.clickElement(dropdownProfile);
        WebUI.waitForElementVisible(optionMyTimesheets);
        WebUI.clickElement(optionMyTimesheets);
    }

    public EditProfilePage viewEditProfile(){
        WebUI.clickElement(dropdownProfile);
        WebUI.waitForElementVisible(optionEditProfile);
        WebUI.clickElement(optionEditProfile);
        return new EditProfilePage();
    }

    public void changeLanguage(){
        WebUI.clickElement(dropdownProfile);
        WebUI.waitForElementVisible(optionLanguage);
        WebUI.clickElement(optionLanguage);
    }

    public LoginPage logOut(){
        WebUI.clickElement(dropdownProfile);
        WebUI.waitForElementVisible(optionLogout);
        WebUI.clickElement(optionLogout);
        return new LoginPage();
    }
}