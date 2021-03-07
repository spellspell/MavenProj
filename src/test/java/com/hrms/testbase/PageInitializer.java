package com.hrms.testbase;

import com.hrms.pages.*;


public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static personalDetailsPage personalDetailPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;
    public static PIMConfigurationPage pimConfigurationPage;
    public static DependentsPage dependentsPage;

    public static void initializePageObjects(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        personalDetailPage=new personalDetailsPage();
        addEmployeePage=new AddEmployeePage();
        employeeListPage=new EmployeeListPage();
        pimConfigurationPage=new PIMConfigurationPage();
        dependentsPage = new DependentsPage();

    }
}
