package com.planetpope.ehcache;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.planetpope.ehcache.model.Person;


public class EhcacheStandAloneTest {
	
	private final CacheManager cacheManager = new CacheManager("src/test/resources/ehcache.xml");
	private static int cacheMisses = 0;

	public Person getObject(String key) {		
		//get a handle on the Cache
		//done for you with Spring
		Cache myCache = cacheManager.getCache("Person");
		Person person = null;
		
		if (!checkInCache(key, myCache)) {	
			person = buildPerson(key);
			cacheMisses++;
			//done for you with Spring
			myCache.put(new Element(key, person));
			System.out.println("Cache has been missed " + cacheMisses + " time(s).");
		}
		
		return person;
	}

	//stubbed data building
	private Person buildPerson(String key) {
		Person person = new Person();
		person.setPersonId(key);
		person.setFirstName("Joe");
		person.setLastName("Smith");
		return person;
	}
	
	//check to see if the key is in the cache
	//done for you with Spring
	private boolean checkInCache(String key, Cache myCache) {
		boolean returnValue = false;
		
		Element element = myCache.get(key);
		if (element != null) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public void clearObject(String key) {
		Cache myCache = cacheManager.getCache("Person");
		myCache.remove(key);
		System.out.println("Object removed from cache...");
	}
	
	public int getExecuteCount() {
		return cacheMisses;
	}
}
