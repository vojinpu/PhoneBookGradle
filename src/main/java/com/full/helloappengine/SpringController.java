package com.full.helloappengine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

///YourActionName
///YouActionName

@RestController
@RequestMapping(value = "/contacts")
public class SpringController  {


	//*********** GET **********

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView searchContact(@RequestParam("query") String query) {

		
		
		System.out.println("Get request - search contact");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strJson = gson.toJson(Contact.SEARCH(query));
		System.out.println(strJson);
		ModelAndView model = new ModelAndView();
		return new ModelAndView("test", "msg", strJson);
		
		
	}
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		
		
		
		
		System.out.println("Get request - ALL");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String strJson = gson.toJson(Contact.getContacts());
		System.out.println(strJson);
		ModelAndView model = new ModelAndView();
		
		
		
		System.out.println("Let's game begin");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		return new ModelAndView("test", "msg", strJson);
		
		
		
		
	}
	

	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	protected ModelAndView getContact(@PathVariable("id") String id) {

		
		
		System.out.println("Get request - get contact");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strJson = gson.toJson(Contact.getContact(id));
		System.out.println(strJson);
		ModelAndView model = new ModelAndView();
		return new ModelAndView("test", "msg", strJson);
		
		
	}
	
	

	
	
	
	//*********** POST **********
	
	@RequestMapping(method = RequestMethod.POST)
	protected void createContact(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

			System.out.println("POST");
			Contact.ADD(arg0.getReader().readLine());
		


	
	}
	
	
	
	//*********** PUT **********	
	
	@RequestMapping(method = RequestMethod.PUT)
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("PUT - Contact Updated");
		Contact.UPDATE(req.getReader().readLine());
	
	}


	//*********** DELETE **********

	@RequestMapping(method = RequestMethod.DELETE)
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("DELETE - Contact deleted");
		Contact.DELETE(req.getParameter("deleteContact"));
		
	}
	
}
