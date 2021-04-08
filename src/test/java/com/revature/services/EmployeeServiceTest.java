package com.revature.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.IEmployeeDAO;
import com.revature.templates.LoginTemplate;

public class EmployeeServiceTest {
    
    @Mock
    private IEmployeeDAO mockedDAO;
    private Employee chris;
    private Employee employee1;
    private EmployeeService testInstance;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
       
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testInstance = new EmployeeService(mockedDAO);
        
        employee1 = new Employee(2,"eemployee", "password","employee1FN","employeee1LN", new Role(2, "employee"),"employee1@ers.com" );
        chris = new Employee(1,"ccastrillon","password", "Christopher", "Castrillon", new Role(1, "finance manager"), "chriscastrillon@ers.com");
        when(mockedDAO.findByUsername("ccastrillon")).thenReturn(chris);
        when(mockedDAO.findByUsername("castrillon")).thenReturn(null);
    };

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
    }
    //Positive test
    @Test
    public void FinanceManagerLoginSuccessfully( ) {
        LoginTemplate lt = new LoginTemplate("ccastrillon", "password");
        assertEquals(chris, testInstance.login(lt));
    }
    //Negative test
    @Test
    public void FinanceManagerloginUncessefully() {
        LoginTemplate lt = new LoginTemplate("castrillon", "password");
        Employee e = testInstance.login(lt);
        assertNull(e);
    }
    //positive test
    @Test
    public void ifEIsNullThenReturnNull() {
        LoginTemplate lt = new LoginTemplate("castrillon", "password");
        assertNull(testInstance.login(lt));
    }
    //negative test
    @Test
    public void ifWrongPasswordReturnNull() {
        LoginTemplate lt = new LoginTemplate("ccastrillon", "badPassword");
        assertNull(testInstance.login(lt));
    }
    @Test
    public void EmployeeLoginSuccessfully() {
        LoginTemplate lt = new LoginTemplate("eemployee", "password");
        assertNull(testInstance.login(lt));
    }
}
