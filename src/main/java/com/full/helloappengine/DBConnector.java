package com.full.helloappengine;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;


public class DBConnector {
	
	private static DatastoreService ds = null;
	
	
	
	public static DatastoreService getConnector(){
		
		if(ds == null){
			System.out.println("Bio je null");
			ds = DatastoreServiceFactory.getDatastoreService();
		}
		return ds;
		
		
	}
	
	

}
