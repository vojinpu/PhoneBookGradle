package com.full.helloappengine;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet{
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		String id = req.getParameter("id");
		String search = req.getParameter("search");
		
		String strJson = "";
		
		if(id != null && id.equals("all"))
			strJson = gson.toJson(Contact.getContacts());
		
		else if(id != null)
			strJson = gson.toJson(Contact.getContact(id));
		
		else if(search != null){
			strJson = gson.toJson(Contact.SEARCH(search));
		}
		

		System.out.println("Jesmo li stigli ovde?");
		
		resp.setContentType("text/html");
		resp.getWriter().println(strJson);
		

	}
	


	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		Contact.DELETE(req.getParameter("deleteContact"));
		System.out.println("Ovde ne bi trebalo da budemo");
		resp.setContentType("text/html");
		resp.getWriter().println("Wuhu");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Contact.ADD(req.getReader().readLine());
	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Contact.UPDATE(req.getReader().readLine());
	
	}
	
	
	
	
	
}
