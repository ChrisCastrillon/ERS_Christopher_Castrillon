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

import com.revature.models.Reimbursement;
import com.revature.repositories.IReimbursementDAO;
import com.revature.templates.ReimbursementTemplate;

public class ReimbursementServiceTest {
    @Mock
    private IReimbursementDAO mockedDAO;
    private Reimbursement testReimbursement;
    private ReimbursementService testInstance;
    private ReimbursementTemplate testReimbursementTemplate;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
       
        testInstance = new ReimbursementService(mockedDAO);
        testReimbursement = new Reimbursement();
//        testReimbursementTemplate = new ReimbursementTemplate("1", "eemployeefn", "eemployeeln", "2", "eemployee@ers.com", "travel jet blue sale", "68");
        when(mockedDAO.insert(testReimbursement)).thenReturn(testReimbursement);
    }

    @After
    public void tearDown() throws Exception {
    }

   

}
