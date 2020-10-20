package com.revature.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.Reimbursement;
import com.revature.repositories.IReimbursementDAO;

public class ReimbursementServiceTest {
    @Mock
    private IReimbursementDAO mockedDAO;
    private Reimbursement testReimbursement;
    private ReimbursementService testInstance;
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
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
