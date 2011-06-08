package com.planetpope.ehcache.dao;


public interface BaseDao {
	
	/**
	 * Using the provided key return
	 * the associated Object from the data
	 * repository.
	 * @param key
	 * @return object having the associated key or
	 * null if no associated Object is found with the provided
	 * key
	 */
	Object getObject(String key);
	
	/**
	 * Get the number of times method getObject is 
	 * executed.  This is just for test purposes.
	 * @return number of times method getObject was executed
	 * by any BaseDao object.
	 */
	int getExecuteCount();
	
	/**
	 * Clears all objects
	 */
	void clearObjects();
	
	/**
	 * clears object by key
	 * @param key
	 */
	void clearObject(String key);

}
