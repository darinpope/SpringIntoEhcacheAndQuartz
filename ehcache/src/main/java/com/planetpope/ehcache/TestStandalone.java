package com.planetpope.ehcache;

public class TestStandalone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		EhcacheStandAloneTest standAlone = new EhcacheStandAloneTest();
		
		
		for (int i = 0; i < 20; i++) {		
			standAlone.getObject("jsmith");		
		}
		
		standAlone.clearObject("jsmith") ;
		
		for (int i = 0; i < 20; i++) {		
			standAlone.getObject("jsmith");		
		}

	}

}
