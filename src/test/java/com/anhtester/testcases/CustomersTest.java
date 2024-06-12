package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.keywords.WebUI;
import com.anhtester.pages.CustomersPage;
import com.anhtester.pages.DashboardPage;
import com.anhtester.pages.LoginPage;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomersTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.clickButtonAddNewCustomer();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.inputFormData(
                excelHelper.getCellData("COMPANY_NAME", 1),
                excelHelper.getCellData("VAT_NUMBER", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("GROUPS", 1),
                excelHelper.getCellData("CURRENCY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("COUNTRY", 1)
        );

        customersPage.verifyAddNewCustomerSuccess();
        customersPage.searchAndVerifyCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.verifyCustomerDetail(
                excelHelper.getCellData("COMPANY_NAME", 1),
                excelHelper.getCellData("VAT_NUMBER", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("GROUPS", 1),
                excelHelper.getCellData("CURRENCY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("COUNTRY", 1)
        );
    }

    @Test
    public void testAddNewCustomerWithCompanyNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.clickButtonAddNewCustomer();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.inputFormDataWithCompanyNull(
                excelHelper.getCellData("VAT_NUMBER", 2),
                excelHelper.getCellData("PHONE", 2),
                excelHelper.getCellData("WEBSITE", 2),
                excelHelper.getCellData("GROUPS", 2),
                excelHelper.getCellData("CURRENCY", 2),
                excelHelper.getCellData("ADDRESS", 2),
                excelHelper.getCellData("CITY", 2),
                excelHelper.getCellData("STATE", 2),
                excelHelper.getCellData("ZIP_CODE", 2),
                excelHelper.getCellData("COUNTRY", 2)
        );
        customersPage.verifyAddNewCustomerFail();
    }

    @Test
    public void testAddCustomerWithCompanyExist(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.clickButtonAddNewCustomer();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.inputFormDataWithCustomerExisted(
                excelHelper.getCellData("COMPANY_NAME", 1),
                excelHelper.getCellData("VAT_NUMBER", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("GROUPS", 1),
                excelHelper.getCellData("CURRENCY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("COUNTRY", 1)
        );

        customersPage.checkCustomerExisted();
    }

    @Test
    public void testViewProfileCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.viewDetailProfileCustomer();
    }

    @Test
    public void testDeleteCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.deleteCustomer();
        customersPage.verifyDeleteCustomerSuccess();
    }

    @Test
    public void testUpdateCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.viewDetailProfileCustomer();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.updateProfileCustomer(
                excelHelper.getCellData("COMPANY_NAME", 1),
                excelHelper.getCellData("VAT_NUMBER", 1),
                excelHelper.getCellData("PHONE", 1),
                excelHelper.getCellData("WEBSITE", 1),
                excelHelper.getCellData("GROUPS", 1),
                excelHelper.getCellData("CURRENCY", 1),
                excelHelper.getCellData("ADDRESS", 1),
                excelHelper.getCellData("CITY", 1),
                excelHelper.getCellData("STATE", 1),
                excelHelper.getCellData("ZIP_CODE", 1),
                excelHelper.getCellData("COUNTRY", 1)
        );

        customersPage.verifyUpdateProfileCustomerSuccess();
    }

    @Test
    public void testCheckDataOnTable(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        customersPage.searchCustomer2("Công ty TNHH ABC");

        customersPage.checkSearchTableByColumn(3, "Công ty TNHH");//so sanh chua
    }

    @Test
    public void testAddNewContact(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContact(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_CONTACT", 1),
                excelHelper.getCellData("PHONE_CONTACT", 1),
                excelHelper.getCellData("PASSWORD_CONTACT", 1)
        );

        customersPage.verifyAddNewContactSuccess();

        customersPage.searchAndVerifyContact(excelHelper.getCellData("FIRST_NAME", 1) + excelHelper.getCellData("LAST_NAME",1));

        customersPage.verifyContactDetail(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_CONTACT", 1),
                excelHelper.getCellData("PHONE_CONTACT", 1),
                excelHelper.getCellData("DIRECTION", 1)
        );
    }

    @Test
    public void testAddNewContactWithFirstNameNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContactWithFirstNameNull(
                excelHelper.getCellData("LAST_NAME", 2),
                excelHelper.getCellData("POSITION", 2),
                excelHelper.getCellData("EMAIL_CONTACT", 2),
                excelHelper.getCellData("PHONE_CONTACT", 2),
                excelHelper.getCellData("PASSWORD_CONTACT", 2)
        );

        customersPage.verifyAddContactWithFirstNameNull();
    }

    @Test
    public void testAddNewContactWithLastNameNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContactWithLastNameNull(
                excelHelper.getCellData("FIRST_NAME", 3),
                excelHelper.getCellData("POSITION", 3),
                excelHelper.getCellData("EMAIL_CONTACT", 3),
                excelHelper.getCellData("PHONE_CONTACT", 3),
                excelHelper.getCellData("PASSWORD_CONTACT", 3)
        );

        customersPage.verifyAddContactWithLastNameNull();
    }

    @Test
    public void testAddNewContactWithEmailNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContactWithEmailNull(
                excelHelper.getCellData("FIRST_NAME", 3),
                excelHelper.getCellData("LAST_NAME", 3),
                excelHelper.getCellData("POSITION", 3),
                excelHelper.getCellData("PHONE_CONTACT", 3),
                excelHelper.getCellData("PASSWORD_CONTACT", 3)
        );

        customersPage.verifyAddContactWithEmailNull();
    }

    @Test
    public void testAddNewContactWithPasswordNull(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContactWithPasswordNull(
                excelHelper.getCellData("FIRST_NAME", 3),
                excelHelper.getCellData("LAST_NAME", 3),
                excelHelper.getCellData("POSITION", 3),
                excelHelper.getCellData("EMAIL_CONTACT", 3),
                excelHelper.getCellData("PHONE_CONTACT", 3)
        );

        customersPage.verifyAddContactWithPasswordNull();
    }

    @Test
    public void testAddNewContactWithEmailExisted(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickButtonAddNewContact();
        customersPage.verifyContactDialog();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewContact(
                excelHelper.getCellData("FIRST_NAME", 1),
                excelHelper.getCellData("LAST_NAME", 1),
                excelHelper.getCellData("POSITION", 1),
                excelHelper.getCellData("EMAIL_CONTACT", 1),
                excelHelper.getCellData("PHONE_CONTACT", 1),
                excelHelper.getCellData("PASSWORD_CONTACT", 1)
        );

        customersPage.verifyAddContactWithEmailExisted();
    }

    @Test
    public void testUpdateNewContact(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.clickNewContact();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.updateNewContact(
                excelHelper.getCellData("FIRST_NAME", 2),
                excelHelper.getCellData("LAST_NAME", 2),
                excelHelper.getCellData("POSITION", 2),
                excelHelper.getCellData("EMAIL_CONTACT", 2),
                excelHelper.getCellData("PHONE_CONTACT", 2),
                excelHelper.getCellData("PASSWORD_CONTACT", 2)
        );

        customersPage.verifyUpdateContactSuccess();
    }

    @Test
    public void testDeleteContact(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuContacts();
        customersPage.verifyContactsPage();

        customersPage.deleteContact();
    }

    @Test
    public void testAddNewNote(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuNotes();
        customersPage.verifyNotePage();

        customersPage.clickButtonAddNewNote();

        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.addNewNote(excelHelper.getCellData("DESCRIPTION_NOTE", 1));

        customersPage.verifyAddNoteSuccess();
    }

    @Test
    public void testUpdateNote(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuNotes();
        customersPage.verifyNotePage();

        customersPage.clickEditNote();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Contact");
        customersPage.editNote(excelHelper.getCellData("DESCRIPTION_NOTE", 1));
        customersPage.verifyUpdateNoteSuccess();
    }

    @Test
    public void testDeleteNote(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomersPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM_DATA.xlsx", "Customer");
        customersPage.searchCustomer(excelHelper.getCellData("COMPANY_NAME", 1));

        customersPage.clickMenuNotes();
        customersPage.verifyNotePage();

        customersPage.deleteNote();
        customersPage.verifyDeleteNoteSuccess();
    }

    @Test
    public void testCheckPaginationOnTable(){

        String searchValue = "CMC";

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customersPage = dashboardPage.clickMenuCustomers();
        //customerPage.checkPageTotal(4);
        //customerPage.checkSearchTableByColumn(3, "cty"); //so sanh contains

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='clients_length']")));

        select.selectByVisibleText("10");
        WebUI.sleep(3);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        //WebUI.setText(By.xpath("//input[@type='search']"), searchValue);
        customersPage.searchCustomer2(searchValue); //tra ra 14 item

        //Get total item
        String strTotal = WebUI.getTextElement(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            customersPage.checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[normalize-space()='Next']"));
                WebUI.sleep(2);
            }
        }
    }
}
