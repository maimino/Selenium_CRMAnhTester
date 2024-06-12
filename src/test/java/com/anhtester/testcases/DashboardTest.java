package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.pages.*;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    ExpensesPage expensesPage;
    ContractsPage contractsPage;
    ProjectsPage projectsPage;
    TasksPage tasksPage;
    LeadsPage leadsPage;
    KnowledgeBasePage knowledgeBasePage;
    EditProfilePage editProfilePage;

    @Test
    public void testOpenCustomersPage() {
        //Login
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        //Click menu Customers
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();
    }


    @Test
    public void testOpenExpensesPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyExpensesPage();
    }

    @Test
    public void testOpenContractsPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        contractsPage = dashboardPage.clickMenuContracts();
        contractsPage.verifyContractsPage();
    }

    @Test
    public void testOpenProjectsPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();
    }

    @Test
    public void testOpenTasksPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();
    }


    @Test
    public void testOpenLeadsPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        leadsPage = dashboardPage.clickMenuLeads();
        leadsPage.verifyLeadsPage();
    }

    @Test
    public void testOpenKnowledgePage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        knowledgeBasePage = dashboardPage.clickMenuKnowledgeBase();
        knowledgeBasePage.verifyKnowledgeBasePage();
    }

    @Test
    public void testOpenEditProfile(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        editProfilePage = dashboardPage.viewEditProfile();
        editProfilePage.verifyEditProfilePage();
    }

    @Test
    public void testLogoutCRM(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        dashboardPage.logOut();
    }
}
