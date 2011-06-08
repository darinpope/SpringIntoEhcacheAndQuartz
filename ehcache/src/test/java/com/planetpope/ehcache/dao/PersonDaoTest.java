package com.planetpope.ehcache.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonDaoTest {
	
	@Autowired
	BaseDao personDao ;

	/**
	 * Calls the getObject method 
	 * numerous times to confirm that the 
	 * @cacheable annotation on the method
	 * means the getObject method actually
	 * only gets executed once.
	 */
	@Test
	public void testGetPerson() {
		
		/*
		 * The first call populates the cache
		 * and every subsequent calls get from the cache
		 */
		for (int i = 0; i < 20; i++) {		
			personDao.getObject("jsmith");		
		}
			
		//check to make sure only 1 miss happened
		assertEquals("Execute count for method getObject is not 1 but should be.", 1, personDao.getExecuteCount() );
		
		/*
		 * Cache should be emptied
		 */
		personDao.clearObject("jsmith") ;
		
		/*
		 * Call getPerson another 20 times
		 * but the method should only execute once.
		 */
		for (int i = 0; i < 20; i++) {	
			personDao.getObject("jsmith");	
		}
		
		//now we have 2 misses
		assertEquals("Execute count for method getPerson is not 2 but should be.", 2, personDao.getExecuteCount() );
	}
}
