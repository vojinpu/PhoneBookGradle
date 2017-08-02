package com.full.helloappengine;
import java.util.ArrayList;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;



public class Contact {

	private String name;
	private ArrayList <String> phones;
	private ArrayList <String> emails;
	private Key key;
	
	
	
	public Contact(String names){
		
		this.name = name;
		phones = new ArrayList<>();
		emails = new ArrayList<>();

		
	}
	
	
	public Contact(String name, ArrayList<String> ph, ArrayList<String> em, Key key2){
		
		this.name = name;
		phones = ph;
		emails = em;
		key = key2;
		
	}
	
	public void addPhone(String phone){
		
		phones.add(phone);
		
	}
	
	public void addEmail(String mail){
		
		emails.add(mail);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public boolean Contains(String query){

		
		if(name.toUpperCase().contains(query.toUpperCase()))
			return true;
		
		for(String num : phones)
			if(num.contains(query))
				return true;
		
		for(String help : emails)
			if(help.toUpperCase().contains(query.toUpperCase()))
				return true;
		
		
		
		
		
		return false;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getPhones() {
		return phones;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void editName(String str) {
		
		name = str;
		
	}

	public void deletePhone(int i) {
		
		phones.remove(i);
		
	}
	
	public void deleteEmails(int i) {
		
		emails.remove(i);
		
	}
	
	
	public static void ADD(String query){
		
		
		
		
		JSONObject obj;
		try {
			obj = new JSONObject(query);
	
			
			DatastoreService ds = DBConnector.getConnector();
			Entity entity = new Entity("Contact");
		
		
			String name =  obj.getString("nameText");
			entity.setProperty("name", name);
		
			
			JSONArray arrPhone = obj.getJSONArray("phonesText");
			JSONArray arrMail = obj.getJSONArray("mailsText");
			
			
			Contact contact = new Contact(name);
			for(int i = 0; i < arrPhone.length(); i++)
				contact.addPhone(arrPhone.get(i).toString());
			for(int i = 0; i < arrMail.length(); i++)
				contact.addEmail(arrMail.get(i).toString());
			

			entity.setProperty("phones", contact.getPhones());
			entity.setProperty("mails", contact.getEmails());
			ds.put(entity);
			
			System.out.println("Contact added");
		
			

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*public static void UPDATE(String query){
		
		
		JSONObject obj;
		try {
			obj = new JSONObject(query);
	
			
			DatastoreService ds = DBConnector.getConnector();
			
		
		
			String name =  obj.getString("nameText");
			
			
			String keyString = obj.getString("key");
			Key  key1= KeyFactory.createKey("Contact", Long.parseLong(keyString));
		
			
			JSONArray arrPhone = obj.getJSONArray("phonesText");
			JSONArray arrMail = obj.getJSONArray("mailsText");
			
			Entity entity = new Entity(key1);
			entity.setProperty("name", name);
			
			
			Contact contact = new Contact(name);
			for(int i = 0; i < arrPhone.length(); i++)
				contact.addPhone(arrPhone.get(i).toString());
			for(int i = 0; i < arrMail.length(); i++)
				contact.addEmail(arrMail.get(i).toString());
			

			entity.setProperty("phones", contact.getPhones());
			entity.setProperty("mails", contact.getEmails());
			entity.setProperty("Key", key1);
			
			ds.put(entity);
			
			

			System.out.println("Contact updated");
			

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}*/
	
	public static ArrayList<Contact> SEARCH(String queryString){
		
		//PhoneBook phoneBook = PhoneBook.getPhoneBook();
		ArrayList<Contact> contacts = new ArrayList<>();
		
		
		DatastoreService ds = DBConnector.getConnector();
		
		
		Query q = new Query("Contact");
		
		q.addFilter("name", FilterOperator.GREATER_THAN_OR_EQUAL, queryString);
		System.out.println(queryString);
		char c = (char) ((int)(queryString.charAt(queryString.length() - 1)) + 1);
		queryString = queryString.substring(0, queryString.length() - 1) + c;
		System.out.println(queryString);
		q.addFilter("name", FilterOperator.LESS_THAN, queryString);
		
		 
		PreparedQuery pq = ds.prepare(q);
		
		for(Entity u1 : pq.asIterable()){
			
			
			String name = u1.getProperty("name").toString();
			ArrayList<String> phones = (ArrayList<String>) u1.getProperty("phones");
			ArrayList<String> mails = (ArrayList<String>) u1.getProperty("mails");
			Contact ct = new Contact(name, phones, mails, u1.getKey());

			contacts.add(ct);
			
		
		}
		

		System.out.println("Contact searched");
		return contacts;
	}
	
	public static void DELETE(String query){
		

		DatastoreService ds = DBConnector.getConnector();
		
		ds.delete(KeyFactory.createKey("Contact", Long.parseLong(query)));


		System.out.println("Contact deleted");
	}
	
	public static ArrayList<Contact> getContacts(){
		
		//PhoneBook phoneBook = PhoneBook.getPhoneBook();
		ArrayList<Contact> contacts = new ArrayList<>();
		
		System.out.println("1");
		DatastoreService ds = DBConnector.getConnector();
		System.out.println("2.1");
		Query q = new Query("Contact");
		System.out.println("2.5");
		PreparedQuery pq = ds.prepare(q);
		System.out.println("3");
		System.out.println(pq);
		for(Entity u1:pq.asIterable()){
			
			
			String name = u1.getProperty("name").toString();
			ArrayList<String> phones = (ArrayList<String>) u1.getProperty("phones");
			ArrayList<String> mails = (ArrayList<String>) u1.getProperty("mails");
			Contact ct = new Contact(name, phones, mails, u1.getKey());

			contacts.add(ct);
			
			System.out.println("4");
		}
		System.out.println("5");

		System.out.println("Contacts returned");
		return contacts;
		
		
	}
	
	
	public static Contact getContact(String query){
		
		
		
		DatastoreService ds = DBConnector.getConnector();
		

		Key  key = KeyFactory.createKey("Contact", Long.parseLong(query));
		Contact ct = null;
		Entity u1;
		try {
			u1 = ds.get(key);
			
			
			
			
			String name = u1.getProperty("name").toString();
			ArrayList<String> phones = (ArrayList<String>) u1.getProperty("phones");
			ArrayList<String> mails = (ArrayList<String>) u1.getProperty("mails");
			ct = new Contact(name, phones, mails, u1.getKey());
			
			
			
			
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

		System.out.println("Contact returned");
		return ct;
		
		
		
		
	}
	
	
	
}
