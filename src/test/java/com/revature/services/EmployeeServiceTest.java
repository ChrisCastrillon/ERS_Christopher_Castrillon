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
    @Test
    public void loginSuccessfully( ) {
        LoginTemplate lt = new LoginTemplate("ccastrillon", "password");
        assertEquals(chris, testInstance.login(lt));
    }
    @Test
    public void loginUncessefully() {
        LoginTemplate lt = new LoginTemplate("castrillon", "password");
        Employee e = testInstance.login(lt);
        assertNull(e);
    }
    @Test
    public void ifEIsNullThenReturnNull() {
        LoginTemplate lt = new LoginTemplate("castrillon", "password");
        assertNull(testInstance.login(lt));
    }
    @Test
    public void ifWrongPasswordReturnNull() {
        LoginTemplate lt = new LoginTemplate("ccastrillon", "badPassword");
        assertNull(testInstance.login(lt));
    }
}
