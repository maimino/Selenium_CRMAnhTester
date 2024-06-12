package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.LoginPage;
import com.anhtester.pages.TasksPage;
import org.testng.annotations.Test;

public class TasksTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TasksPage tasksPage;

    @Test
    public void testAddNewTask(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();

        tasksPage.clickButtonNewTask();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Task");
        tasksPage.addNewTask(
                excelHelper.getCellData("SUBJECT", 1),
                excelHelper.getCellData("HOURLY_RATE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DUE_DATE", 1),
                excelHelper.getCellData("FOLLOWER", 1)
        );

        tasksPage.verifyAddTaskSuccess();

        tasksPage.searchTask(excelHelper.getCellData("SUBJECT", 1));
    }

    @Test
    public void testAddTaskWithSubjectNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();

        tasksPage.clickButtonNewTask();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Task");
        tasksPage.addNewTaskWithSubjectNull(
                excelHelper.getCellData("HOURLY_RATE", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DUE_DATE", 1),
                excelHelper.getCellData("FOLLOWER", 1)
        );

        tasksPage.verifyAddTaskFail();
    }

    @Test
    public void testUdateTask(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();

        tasksPage.clickButtonEditTask();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Task");
        tasksPage.editTask(
                excelHelper.getCellData("SUBJECT", 1),
                excelHelper.getCellData("START_DATE", 1),
                excelHelper.getCellData("DUE_DATE", 1)
        );

        tasksPage.verifyEditTaskSuccess();
    }

    @Test
    public void testDeleteTask(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();

        tasksPage.deleteTask();
        tasksPage.verifyDeleteTaskSuccess();
    }

    @Test
    public void testFilterTaskByMonth(){

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyTasksPage();

        tasksPage.clickButtonTaskOverView();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Task");
        tasksPage.filterTaskByMonth(
                excelHelper.getCellData("MONTH", 1)
        );

        tasksPage.verifyFilterTaskByMonth();
    }
}
