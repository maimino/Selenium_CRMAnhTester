package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.LoginPage;
import com.anhtester.pages.ProjectsPage;
import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectsPage projectsPage;

    @Test
    public void testAddNewProject(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.clickButtonNewProject();
        projectsPage.verifyAddNewProjectPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.addNewProject(
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("TOTAL_RATE", 1),
                excelHelper.getCellData("ESTIMATE_HOUR", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DEADLINE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        projectsPage.verifyAddProjectSuccess();

        projectsPage.searchAndVerifyProject(excelHelper.getCellData("PROJECT_NAME", 1));
    }

    @Test
    public void testAddNewProjectWithProjectNameNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.clickButtonNewProject();
        projectsPage.verifyAddNewProjectPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.addNewProjectWithProjectNameNull(
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("TOTAL_RATE", 1),
                excelHelper.getCellData("ESTIMATE_HOUR", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DEADLINE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        projectsPage.verifyAddProjectWithProjectNameNull();
    }

    @Test
    public void testAddNewProjectWithCustomerNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.clickButtonNewProject();
        projectsPage.verifyAddNewProjectPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.addNewProjectWithCustomerNull(
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("TOTAL_RATE", 1),
                excelHelper.getCellData("ESTIMATE_HOUR", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DEADLINE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        projectsPage.verifyAddProjectWithCustomerNull();
    }

    @Test
    public void testUpdateProject(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.clickButtonEditProject();
        projectsPage.verifyEditProjectPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.editProject(
                excelHelper.getCellData("PROJECT_NAME", 1),
                excelHelper.getCellData("CUSTOMER", 1),
                excelHelper.getCellData("TOTAL_RATE", 1),
                excelHelper.getCellData("ESTIMATE_HOUR", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DEADLINE", 1),
                excelHelper.getCellData("DESCRIPTION", 1)
        );

        projectsPage.verifyUpdateProjectSuccess();
    }

    @Test
    public void testDeleteProject(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.deleteProject();
        projectsPage.verifyDeleteProjectSuccess();
    }

    @Test
    public void testChangeStatusProject(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        projectsPage.clickButtonViewProject();

        projectsPage.changeStatusProject();
        projectsPage.verifyChangeStatusPojectSuccess();
    }

    @Test
    public void testAddNewTask(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.searchProject(excelHelper.getCellData("PROJECT_NAME", 1));

        projectsPage.clickButtonNewTask();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Task_Project");
        projectsPage.addNewTask(
                excelHelper.getCellData("SUBJECT", 2),
                excelHelper.getCellData("START_DATE", 2),
                excelHelper.getCellData("DUE_DATE", 2),
                excelHelper.getCellData("FOLLOWER", 2),
                excelHelper.getCellData("TASK_DESCRIPTION", 2)
        );

        projectsPage.searchTask(excelHelper.getCellData("SUBJECT", 2));
    }

    @Test
    public void testDeleteTask(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        projectsPage = dashboardPage.clickMenuProjects();
        projectsPage.verifyProjectsPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Project");
        projectsPage.searchProject(excelHelper.getCellData("PROJECT_NAME", 1));

        projectsPage.clickTask();

        projectsPage.deleteTask();
        projectsPage.verifyDeleteTaskSuccess();
    }
}
