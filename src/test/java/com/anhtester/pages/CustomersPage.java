package com.anhtester.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Set;

public class CustomersPage {
    String headerText = "Customers Summary";

    //Customer Page
    private By menuCutomers = By.xpath("//span[normalize-space()='Customers']");
    private By headerCustomersPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer =  By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer =  By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts =  By.xpath("//a[contains(@href,'clients/all_contacts')]");
    private By inputSearchCustomer =  By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");
    private By secondItemCustomerOnTable = By.xpath("((//tr[@class='has-row-options even'])[1]//td)[3]/child::a");

    //Form Add new customer
    private By inputCompanyName =  By.xpath("//input[@id='company']");
    private By inputVatNumber =  By.xpath("//input[@id='vat']");
    private By inputPhone =  By.xpath("//input[@id='phonenumber']");
    private By inputWebsite =  By.xpath("//input[@id='website']");
    private By dropdownGroups =  By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup =  By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency =  By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency =  By.xpath("//div[@app-field-wrapper='default_currency']//input[@type='search']");
    private By dropdownLanguage =  By.xpath("//button[@data-id='default_language']");
    private By optionVietnamese =  By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress =  By.xpath("//textarea[@id='address']");
    private By inputCity =  By.xpath("//input[@id='city']");
    private By inputState =  By.xpath("//input[@id='state']");
    private By inputZipCode =  By.xpath("//input[@id='zip']");
    private By dropdownCountry =  By.xpath("//button[@data-id='country']");
    private By inputSearchCountry =  By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");
    private By buttonSaveAndCreateContact =  By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer =  By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    private By errorCompany = By.xpath("//p[@id='company-error']");

    private By idCompany = By.xpath("//span[@class='tw-truncate']");
    private By alertAddCustomerSuccess = By.xpath("//span[@class='alert-title']");
    private By alertUpdateCustomerSuccess = By.xpath("//span[@class='alert-title']");

    //Function view, contact, delete
    private By buttonViewProfileCustomer = By.xpath("(//td[@class='sorting_1'])[1]//div//a[contains(text(),'View')]");
    private By buttonDeleteCustomer = By.xpath("(//td[@class='sorting_1'])[1]//div//a[contains(text(),'Delete')]");
    private By buttonDeleteSecondCustomer = By.xpath("((//tr[@class='has-row-options even'])[1]//td)[3]//child::div//a[contains(text(),'Delete')]");
    private By headerProfileCustomer = By.xpath("//h4[normalize-space()='Profile']");
    private By alertDeleteCustomerSuccess = By.xpath("//span[@class='alert-title']");

    //Contact page
    private By menuContacts = By.xpath("//a[@data-group='contacts']");
    private By headerContactPage = By.xpath("//h4[normalize-space()='Contacts']");
    private By buttonAddNewContact = By.xpath("//a[normalize-space()='New Contact']");
    private By inputSearchContact = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");
    private By firstItemContactOnTable = By.xpath("//td[@class='sorting_1']/a");
    private By firstContactNameOnTable = By.xpath("(//td[@class='sorting_1']/following-sibling::td/a)[1]");

    //Form Add new contact
    private By headerAddNewContactDialog = By.xpath("//h4[normalize-space()='Add new contact']");
    private By companyName = By.xpath("//h4[normalize-space()='Add new contact']/following-sibling::p");
    private By inputProfileImage = By.xpath("//input[@id='profile_image']");
    private By inputFirstName = By.xpath("//input[@id='firstname']");
    private By inputLastName = By.xpath("//input[@id='lastname']");
    private By inputPosition = By.xpath("//input[@id='title']");
    private By inputEmailContact = By.xpath("//input[@id='email']");
    private By inputPhoneContact = By.xpath("//input[@id='phonenumber']");
    private By dropdownDirection = By.xpath("//button[@data-id='direction']");
    private By optionLTR = By.xpath("//span[normalize-space()='LTR']");
    private By inputPasswordContact = By.xpath("//input[@name='password']");
    private By buttonGeneratePassword = By.xpath("//a[@class='generate_password']");
    private By buttonShowPassword = By.xpath("//a[@class='show_password']");
    private By checkboxDoNotSendEmail = By.xpath("//label[normalize-space()='Do not send welcome email']");
    private By buttonSaveContact = By.xpath("//form[@id='contact-form']//button[normalize-space()='Save']");

    private By alertAddContactSuccess = By.xpath("//span[@class='alert-title']");
    private By errorFistName = By.xpath("//p[@id='firstname-error']");
    private By errorLastName = By.xpath("//p[@id='lastname-error']");
    private By errorEmail = By.xpath("//p[@id='email-error']");
    private By errorPassword = By.xpath("//p[@id='password-error']");
    private By errorEmailExisted = By.xpath("//p[@id='email-error']");
    private By alertUpdateContactSuccess = By.xpath("//span[@class='alert-title']");
    private By buttonDeleteContact = By.xpath("(//td[@class='sorting_1']//a[contains(text(),'Delete')])[1]");
    private By alertCustomerExisted = By.xpath("//div[@id='company_exists_info']//div[@class='alert alert-info']");
    //private By firstItemContactOnTable = By.xpath("//table[@id='DataTables_Table_0']/descendant::td[@class='sorting_1']");

    //Note page
    private By menuNotes = By.xpath("//a[@data-group='notes']");
    private By headerNotePage = By.xpath("//h4[contains(@class,'customer-profile')]//div[contains(@class, 'tw-flex')]");
    private By buttonNewNote = By.xpath("//a[normalize-space()='New Note']");
    private By inputSearchNote = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");
    private By inputDescriptionNote = By.xpath("//textarea[@id='description']");
    private By buttonSaveNote = By.xpath("//button[normalize-space()='Save']");

    private By inputEditDescriptionNote = By.xpath("(//textarea[@name='description'])[2]");
    private By buttonSaveUpdateNote = By.xpath("((//div[@class='text-right mtop15'])[1])//button[2]");
    private By buttonEditNote = By.xpath("((//tr[@class='odd']/descendant::td)[4])//a[contains(@onclick, 'edit')]");
    private By buttonDeleteNote = By.xpath("((//tr[@class='odd']/descendant::td)[4])//a[contains(@class,'delete')]");

    private By alertAddNoteSuccess = By.xpath("//span[@class='alert-title']");
    private By alertUpdateNoteSuccess = By.xpath("//span[@class='alert-title']");
    private By alertDeleteNoteSuccess = By.xpath("//span[@class='alert-title']");

    public void verifyCustomersPage(){
        WebUI.waitForElementVisible(headerCustomersPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerCustomersPage), "Không đến được trang Customers.");
        Assert.assertEquals(WebUI.getTextElement(headerCustomersPage), headerText, "Tiêu đề trang Customers không đúng.");
    }

    public void clickButtonAddNewCustomer(){
        WebUI.waitForElementVisible(buttonAddNewCustomer);
        WebUI.clickElement(buttonAddNewCustomer);
    }

    //ADD CUSTOMER
    //Nhap data vao form Add new customer
    public void inputFormData(String COMPANY_NAME, String VAT_NUMBER, String PHONE, String WEBSITE, String GROUPS, String CURRENCY,String ADDRESS, String CITY, String STATE, String ZIP_CODE, String COUNTRY){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputCompanyName,COMPANY_NAME);
        WebUI.setText(inputVatNumber, VAT_NUMBER);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, GROUPS);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.clickElement(dropdownCurrency);
        WebUI.setText(inputSearchCurrency, CURRENCY);
        WebUI.setKey(inputSearchCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionVietnamese);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }
    
    public void verifyAddNewCustomerSuccess(){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(idCompany);
        Assert.assertTrue(WebUI.getTextElement(idCompany).contains(WebUI.getAttributeElement(inputCompanyName, "value")), "Tên company vừa thêm mới không chính xác.");
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddCustomerSuccess), "Thông báo thêm mới customer thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddCustomerSuccess), "Customer added successfully.", "Nội dung thông báo thêm mới customer thành công không đúng.");
        LogUtils.info("Thêm mới customer thành công.");
    }

    public void verifyAddNewCustomerFail(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới customer thất bại do bỏ trống trường bắt buộc Company.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorCompany), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorCompany), "This field is required.", "Nội dung thông báo lỗi không đúng");
    }

    public void inputFormDataWithCompanyNull(String VAT_NUMBER, String PHONE, String WEBSITE, String GROUPS, String CURRENCY,String ADDRESS, String CITY, String STATE, String ZIP_CODE, String COUNTRY){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputVatNumber, VAT_NUMBER);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, GROUPS);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.clickElement(dropdownCurrency);
        WebUI.setText(inputSearchCurrency, CURRENCY);
        WebUI.setKey(inputSearchCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionVietnamese);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    //Tim kiem customer vua tao moi
    public void searchAndVerifyCustomer(String COMPANY_NAME){
        WebUI.clickElement(menuCutomers);
        WebUI.clickElement(inputSearchCustomer);
        WebUI.setText(inputSearchCustomer, COMPANY_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstItemCustomerOnTable), "Không tìm thấy customer vừa tạo mới.");
        LogUtils.info("Tìm thấy thành công customer vừa tạo mới.");
    }

    //Tim kiem customer
    public void searchCustomer(String COMPANY_NAME){
        WebUI.clickElement(inputSearchCustomer);
        WebUI.setText(inputSearchCustomer, COMPANY_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstItemCustomerOnTable), "Không tìm thấy customer vừa tạo mới.");
        WebUI.waitForElementVisible(firstItemCustomerOnTable);
        WebUI.clickElement(firstItemCustomerOnTable);
    }

    public void verifyCustomerDetail(String COMPANY_NAME, String VAT_NUMBER, String PHONE, String WEBSITE, String GROUPS, String CURRENCY,String ADDRESS, String CITY, String STATE, String ZIP_CODE, String COUNTRY){
        WebUI.waitForPageLoaded();
        WebUI.waitForElementClickable(firstItemCustomerOnTable);
        WebUI.clickElement(firstItemCustomerOnTable);
        //Kiem tra gia tri sau khi tao moi
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getAttributeElement(inputCompanyName, "value"), COMPANY_NAME, "Tên Company không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputVatNumber, "value"), VAT_NUMBER, "Vat number không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputPhone, "value"), PHONE, "Phone không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputWebsite, "value"), WEBSITE, "Website không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownGroups, "title"), GROUPS, "Groups không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownCurrency, "title"), CURRENCY, "Currency không đúng.");
        softAssert.assertEquals(WebUI.getTextElement(dropdownLanguage), "Vietnamese", "Default language không đúng.");
        softAssert.assertEquals(WebUI.getTextElement(inputAddress), ADDRESS, "Address không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputCity, "value"), CITY, "City không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputState, "value"), STATE, "State không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputZipCode, "value"), ZIP_CODE, "Zip code không đúng.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownCountry, "title"), COUNTRY, "Country không đúng.");
        softAssert.assertAll();
        LogUtils.info("Thông tin chi tiết của customer vừa tạo mới chính xác.");
    }

    public void inputFormDataWithCustomerExisted(String COMPANY_NAME, String VAT_NUMBER, String PHONE, String WEBSITE, String GROUPS, String CURRENCY,String ADDRESS, String CITY, String STATE, String ZIP_CODE, String COUNTRY){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputCompanyName,COMPANY_NAME);
        WebUI.setText(inputVatNumber, VAT_NUMBER);
        WebUI.setText(inputPhone, PHONE);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, GROUPS);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.clickElement(dropdownCurrency);
        WebUI.setText(inputSearchCurrency, CURRENCY);
        WebUI.setKey(inputSearchCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionVietnamese);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.setText(inputCity, CITY);
        WebUI.setText(inputState, STATE);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
    }

    public void checkCustomerExisted(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertCustomerExisted), "Thông báo customer đã tồn tại không hiển thị");
        LogUtils.info("Tên customer đã tồn tại.");
    }

    public void viewDetailProfileCustomer(){
        WebUI.hoverElement(firstItemCustomerOnTable);
        WebUI.waitForElementVisible(buttonViewProfileCustomer);
        WebUI.clickElement(buttonViewProfileCustomer);
        Assert.assertTrue(WebUI.checkElementDisplay(headerProfileCustomer), "Không đến được trang Profile của customer.");
        Assert.assertEquals(WebUI.getTextElement(headerProfileCustomer), "Profile", "Tiêu đề trang Profile của customer không đúng.");
        LogUtils.info("Đã đến được trang profile của customer.");
    }

    public void deleteCustomer(){
        WebUI.hoverElement(firstItemCustomerOnTable);
        WebUI.waitForElementVisible(buttonDeleteCustomer);
        WebUI.clickElement(buttonDeleteCustomer);
        WebUI.acceptAlert();
    }

    public void verifyDeleteCustomerSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteCustomerSuccess), "Thông báo xóa khách hàng thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteCustomerSuccess), "Customer deleted", "Nội dung thông báo xóa khách hàng thành công không đúng.");
        LogUtils.info("Xóa khách hàng thành công.");
    }

    //Cap nhat thong tin customer
    public void updateProfileCustomer(String COMPANY_NAME, String VAT_NUMBER, String PHONE, String WEBSITE, String GROUPS, String CURRENCY,String ADDRESS, String CITY, String STATE, String ZIP_CODE, String COUNTRY){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputCompanyName);
        WebUI.setText(inputCompanyName,COMPANY_NAME);
        WebUI.clearText(inputVatNumber);
        WebUI.setText(inputVatNumber, VAT_NUMBER);
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, PHONE);
        WebUI.clearText(inputWebsite);
        WebUI.setText(inputWebsite, WEBSITE);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, GROUPS);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.clickElement(dropdownCurrency);
        WebUI.setText(inputSearchCurrency, CURRENCY);
        WebUI.setKey(inputSearchCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionVietnamese);
        WebUI.clearText(inputAddress);
        WebUI.setText(inputAddress, ADDRESS);
        WebUI.clearText(inputCity);
        WebUI.setText(inputCity, CITY);
        WebUI.clearText(inputState);
        WebUI.setText(inputState, STATE);
        WebUI.clearText(inputZipCode);
        WebUI.setText(inputZipCode, ZIP_CODE);
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, COUNTRY);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public void verifyUpdateProfileCustomerSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateCustomerSuccess), "Thông báo cập nhật khách hàng thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateCustomerSuccess), "Customer updated successfully.", "Nội dung thông báo cập nhật khách hàng thành công không đúng.");
        LogUtils.info("Cập nhật khách hàng thành công.");
    }

    public void searchCustomer2(String COMPANY_NAME){
        WebUI.clickElement(inputSearchCustomer);
        WebUI.setText(inputSearchCustomer, COMPANY_NAME);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded();
    }

    //Kiểm tra giá trị khi tìm kiếm trong table
    public void checkSearchTableByColumn(int column, String value) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);

            System.out.print(value + " - "); //Expected
            System.out.println(elementCheck.getText()); //Actual
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }


    //ADD CONTACT
    public void clickMenuContacts(){
        WebUI.waitForElementVisible(menuContacts);
        WebUI.clickElement(menuContacts);
    }

    public void verifyContactsPage(){
        WebUI.waitForElementVisible(headerContactPage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerContactPage), "Không đến được trang Contacts.");
        Assert.assertEquals(WebUI.getTextElement(headerContactPage), "Contacts", "Tiêu đề trang Contacts không đúng.");
    }

    public void clickButtonAddNewContact(){
        WebUI.waitForElementClickable(buttonAddNewContact);
        WebUI.clickElement(buttonAddNewContact);
    }

    public void verifyContactDialog(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(headerAddNewContactDialog), "Không phải form tạo mới contact.");
        Assert.assertEquals(WebUI.getTextElement(headerAddNewContactDialog), "Add new contact", "Tiêu đề form tạo mới contact sai.");
    }

    //Tao moi contact cho customer vua tao moi
    public void addNewContact(String FIRST_NAME, String LAST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT, String PASSWORD_CONTACT){
        WebUI.setText(inputProfileImage, System.getProperty("user.dir") + "/src/test/resources/testdata/cooky.jpg");
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailContact, EMAIL_CONTACT);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.setText(inputPasswordContact, PASSWORD_CONTACT);
        WebUI.clickElement(checkboxDoNotSendEmail);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyAddNewContactSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddContactSuccess), "Thông báo thêm mới contact thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddContactSuccess), "Contact added successfully.", "Nội dung thông báo thêm mới contact thành công không đúng.");
        LogUtils.info("Thêm mới contact thành công.");
    }

    //Tim kiem contact vua tao moi
    public void searchAndVerifyContact(String CONTACT_NAME){
        WebUI.clickElement(menuCutomers);
        WebUI.clickElement(inputSearchCustomer);
        WebUI.setText(inputSearchCustomer, CONTACT_NAME);
        Assert.assertTrue(WebUI.checkElementExist(firstContactNameOnTable), "Không tìm thấy contact vừa tạo mới.");
        LogUtils.info("Tìm thấy thành công contact vừa tạo mới.");
        WebUI.clickElement(firstContactNameOnTable);
    }

    public void verifyContactDetail(String FIRST_NAME, String LAST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT, String DIRECTION){
        WebUI.waitForPageLoaded();

        Set<String> windows = DriverManager.getDriver().getWindowHandles(); //Hàm getWindowHandle dùng để lấy mã số của cửa sổ hiện tại, trả về String.  Dùng hàm getWindowHandles để lấy hết tất cả các cửa sổ đang mở. Khi chúng ta lick vào 1 đường link ở page hiện tại, nó open 1 cửa sổ mới. Mỗi browser này sẽ có 1 mã số để phân biệt chúng với nhau. Và chúng ta dùng kiểu dữ liệu Set trong Java để lưu trữ tất cả các mã số lại.
        String firstWindow = windows.toArray()[0].toString(); //Cửa sổ đầu, firstWindow ý nghĩa là main window (cái cần lưu đầu tiên)
        String secondWindow = windows.toArray()[1].toString(); //Cửa sổ thứ hai

        DriverManager.getDriver().switchTo().window(secondWindow); //chuyen huong sang cua so thu 2

        //Kiem tra gia tri sau khi tao moi
        Assert.assertEquals(WebUI.getAttributeElement(inputFirstName, "value"), FIRST_NAME, "First Name không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputLastName, "value"), LAST_NAME, "Last Name không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputPosition, "value"), POSITION, "Position không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputEmailContact, "value"), EMAIL_CONTACT, "Email contact không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(inputPhoneContact, "value"), "+84"  + PHONE_CONTACT, "Phone contact không đúng.");
        Assert.assertEquals(WebUI.getAttributeElement(dropdownDirection, "title"), DIRECTION, "Direction không đúng.");
        LogUtils.info("Thông tin chi tiết của contact vừa tạo mới chính xác.");

        DriverManager.getDriver().close(); //dong cua so hien tai
        DriverManager.getDriver().switchTo().window(firstWindow); //chuyen huong ve cua so chinh
    }

    public void addNewContactWithFirstNameNull(String LAST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT, String PASSWORD_CONTACT){
        WebUI.setText(inputProfileImage, System.getProperty("user.dir") + "/src/test/resources/testdata/cooky.jpg");
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailContact, EMAIL_CONTACT);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.setText(inputPasswordContact, PASSWORD_CONTACT);
        WebUI.clickElement(checkboxDoNotSendEmail);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyAddContactWithFirstNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contact không thành công do bỏ trống trường bắt buộc First Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorFistName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorFistName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addNewContactWithLastNameNull(String FIRST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT, String PASSWORD_CONTACT){
        WebUI.setText(inputProfileImage, System.getProperty("user.dir") + "/src/test/resources/testdata/cooky.jpg");
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailContact, EMAIL_CONTACT);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.setText(inputPasswordContact, PASSWORD_CONTACT);
        WebUI.clickElement(checkboxDoNotSendEmail);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyAddContactWithLastNameNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contact không thành công do bỏ trống trường bắt buộc Last Name.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorLastName), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorLastName), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addNewContactWithEmailNull(String FIRST_NAME, String LAST_NAME, String POSITION, String PHONE_CONTACT, String PASSWORD_CONTACT){
        WebUI.setText(inputProfileImage, System.getProperty("user.dir") + "/src/test/resources/testdata/cooky.jpg");
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.setText(inputPasswordContact, PASSWORD_CONTACT);
        WebUI.clickElement(checkboxDoNotSendEmail);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyAddContactWithEmailNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contact không thành công do bỏ trống trường bắt buộc Email.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorEmail), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorEmail), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void addNewContactWithPasswordNull(String FIRST_NAME, String LAST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT){
        WebUI.setText(inputProfileImage, System.getProperty("user.dir") + "/src/test/resources/testdata/cooky.jpg");
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.setText(inputPosition, POSITION);
        WebUI.setText(inputEmailContact, EMAIL_CONTACT);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.clickElement(checkboxDoNotSendEmail);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyAddContactWithPasswordNull(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contact không thành công do bỏ trống trường bắt buộc Password.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorPassword), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorPassword), "This field is required.", "Nội dung thông báo lỗi không đúng.");
    }

    public void verifyAddContactWithEmailExisted(){
        WebUI.waitForPageLoaded();
        LogUtils.info("Thêm mới contact không thành công do nhập email đã tồn tại.");
        Assert.assertTrue(WebUI.checkElementDisplay(errorEmailExisted), "Thông báo lỗi không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(errorEmailExisted), "Email already exists", "Nội dung thông báo lỗi không đúng.");
    }

    public void clickNewContact(){
        WebUI.waitForElementVisible(firstItemContactOnTable);
        WebUI.clickElement(firstItemContactOnTable);
    }

    //Cap nhat contact vua tao moi
    public void updateNewContact(String FIRST_NAME, String LAST_NAME, String POSITION, String EMAIL_CONTACT, String PHONE_CONTACT, String PASSWORD_CONTACT){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputFirstName);
        WebUI.setText(inputFirstName, FIRST_NAME);
        WebUI.clearText(inputLastName);
        WebUI.setText(inputLastName, LAST_NAME);
        WebUI.clearText(inputPosition);
        WebUI.setText(inputPosition, POSITION);
        WebUI.clearText(inputEmailContact);
        WebUI.setText(inputEmailContact, EMAIL_CONTACT);
        WebUI.clearText(inputPhoneContact);
        WebUI.setText(inputPhoneContact, PHONE_CONTACT);
        WebUI.clickElement(dropdownDirection);
        WebUI.clickElement(optionLTR);
        WebUI.clearText(inputPasswordContact);
        WebUI.setText(inputPasswordContact, PASSWORD_CONTACT);
        WebUI.clickElement(buttonSaveContact);
    }

    public void verifyUpdateContactSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateContactSuccess), "Thông báo cập nhật contact thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateContactSuccess), "Contact updated successfully.", "Nội dung thông báo cập nhật contact thành công không đúng.");
        LogUtils.info("Cập nhật contact thành công.");
    }

    public void deleteContact(){
        WebUI.hoverElement(firstItemContactOnTable);
        WebUI.waitForElementVisible(buttonDeleteContact);
        WebUI.clickElement(buttonDeleteContact);
        WebUI.acceptAlert();
        LogUtils.info("Xóa contact thành công.");
    }

    //ADD NOTE
    public void clickMenuNotes(){
        WebUI.waitForElementVisible(menuNotes);
        WebUI.clickElement(menuNotes);
    }

    public void verifyNotePage(){
        WebUI.waitForElementVisible(headerNotePage);
        Assert.assertTrue(WebUI.checkElementDisplay(headerNotePage), "Không đến được trang Notes.");
        Assert.assertTrue(WebUI.getTextElement(headerNotePage).contains("Notes"), "Tiêu đề trang Notes không đúng.");
    }

    public void clickButtonAddNewNote(){
        WebUI.waitForElementClickable(buttonNewNote);
        WebUI.clickElement(buttonNewNote);
    }

    public void addNewNote(String DESCRIPTION_NOTE){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputDescriptionNote, DESCRIPTION_NOTE);
        WebUI.clickElement(buttonSaveNote);
    }

    public void editNote(String DESCRIPTION_NOTE){
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputEditDescriptionNote);
        WebUI.setText(inputEditDescriptionNote, DESCRIPTION_NOTE);
        WebUI.clickElement(buttonSaveUpdateNote);
    }

    public void deleteNote(){
        WebUI.waitForElementClickable(buttonDeleteNote);
        WebUI.clickElement(buttonDeleteNote);
        WebUI.acceptAlert();
    }

    public void clickEditNote(){
        WebUI.waitForElementVisible(buttonEditNote);
        WebUI.clickElement(buttonEditNote);
    }

    public void verifyAddNoteSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertAddNoteSuccess), "Thông báo thêm mới note thành công không hiển thị");
        Assert.assertEquals(WebUI.getTextElement(alertAddNoteSuccess), "Note added successfully.", "Nội dung thông báo thêm mới note thành công không đúng.");
        LogUtils.info("Thêm mới note thành công.");
    }

    public void verifyUpdateNoteSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertUpdateNoteSuccess), "Thông báo cập nhật note thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertUpdateNoteSuccess), "Note updated successfully", "Nội dung thông báo cập nhật note thành công không đúng.");
        LogUtils.info("Cập nhật note thành công.");
    }

    public void verifyDeleteNoteSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplay(alertDeleteNoteSuccess), "Thông báo xóa note thành công không hiển thị.");
        Assert.assertEquals(WebUI.getTextElement(alertDeleteNoteSuccess), "Note deleted", "Nội dung thông báo xóa note thành công không đúng.");
        LogUtils.info("Xóa ghi chú thành công.");
    }
}