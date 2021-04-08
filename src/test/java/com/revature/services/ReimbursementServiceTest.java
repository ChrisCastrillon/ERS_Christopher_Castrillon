package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.templates.ReimbursementUpdateTemplate;

public class ReimbursementServiceTest {
    @Mock
    private IReimbursementDAO mockedDAO;
    private Reimbursement testReimbursement;
    private Reimbursement testReimbursement2;
    private Reimbursement testReimbursement3;
    private ReimbursementService testInstance;
    private ReimbursementTemplate testReimbursementTemplate;
    private ReimbursementUpdateTemplate testReimbursementUpdateTemplate;
    private List<Reimbursement> testAllReimbursements;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testReimbursement = new Reimbursement(0, 100.00, null, null, "description text", null, 1,2, 1, 1 );
        testReimbursement2 = new Reimbursement(0, 100.00, null, null, "description text", null, 2,2, 2, 2 );
        testReimbursement3 = new Reimbursement(3, 300.00, null, null, "description text 3", null, 3,2,3,3 );
        testReimbursementTemplate = new ReimbursementTemplate("1", "testEmployee1FN", "testEmployee1LN","1","email@ers.com", "description text", "100.00", null);
        testReimbursementUpdateTemplate = new ReimbursementUpdateTemplate("0","2","3");
        testAllReimbursements = new ArrayList<Reimbursement>();
        testAllReimbursements.add(testReimbursement);
        testAllReimbursements.add(testReimbursement2);
        testAllReimbursements.add(testReimbursement3);
        
        testInstance = new ReimbursementService(mockedDAO);
        when(mockedDAO.update(testReimbursement)).thenReturn(testReimbursement);
        when(mockedDAO.insert(testReimbursement)).thenReturn(null);
        when(mockedDAO.findById(0)).thenReturn(testReimbursement);
        when(mockedDAO.findAll()).thenReturn(testAllReimbursements);

    }

    @After
    public void tearDown() throws Exception {
    
    }
    
    //test correct input
    @Test
    public void testUpdateReimbursement() {
        assertEquals(testReimbursement, testInstance.updateReimbursement(testReimbursement));
    }
    @Test
    public void testReimbursementUpdateFormToReimbursement() {
        assertNotEquals(testReimbursement, testInstance.reimbursementUpdateFormToReimbursement(testReimbursementUpdateTemplate));
    }
    @Test
    public void testReimbursmentFormToReimbursement() {
        Reimbursement tr = testInstance.reimbursementFormToReimbursement(testReimbursementTemplate);
        assertEquals(testReimbursement.getType(), (testInstance.reimbursementFormToReimbursement(testReimbursementTemplate)).getType());
        assertNotNull(testInstance.reimbursementFormToReimbursement(testReimbursementTemplate));
    }
    
    @Test
    public void testSubmitReimbursement() {
        assertNull(testInstance.submitReimbursement(testReimbursementTemplate));
    }
    @Test
    public void testGetAllReimbursments() {
        ArrayList<Reimbursement> reimbList = new ArrayList<Reimbursement>(testInstance.getAllReimbursements());
        assertEquals(testReimbursement, reimbList.get(0));
    }

}
