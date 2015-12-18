package base;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.RateDomainModel;

public class Rate_Test {

	private static RateDomainModel per1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// Create test case for j units
		per1 = new RateDomainModel();
		per1.setRateID(64);
		per1.setMinCreditScore(800);
		per1.setInterestRate(3.0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		RateDomainModel per;	
		RateDAL.deleteRate(per1.getRateID());
		per = RateDAL.getFullRate(per1.getRateID());
		assertNull("The Person is not in the database",per);		
	}
	
	public void assertTrueTest() {
		// test getRate method 
		assertTrue(per1.getInterestRate()==25);
		assertTrue(per1.getInterestRate()==RateDAL.getRate(per1.getMinCreditScore()));
		System.out.println(RateDAL.getRate(per1.getMinCreditScore()));
		
		
	}

	@Test
	public void AddRateTest()
	{		
		// test to see if rate is being added to table and if the getRate method in the DAL works
		per1 = new RateDomainModel();
		per1.setRateID(6694);
		per1.setMinCreditScore(800);
		per1.setInterestRate(3.0);
		RateDomainModel per = RateDAL.getFullRate(per1.getRateID());
		assertNull("The Person is not the database",per);		
		RateDAL.addRate(per1);	
		assertNotNull("The Person is in the database",per1);
	}
	
	
}
