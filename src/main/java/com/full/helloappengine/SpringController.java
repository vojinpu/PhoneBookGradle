package com.full.helloappengine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

///YourActionName
///YouActionName

@Controller
@RequestMapping(value = "/")
public class SpringController  {



	public void YourActionName(@RequestParam("memberId") String id, @RequestParam("memberPw") String pw) {

		System.out.println("Prazno");
	}		
			
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected void createContact(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

			System.out.println("POST");
			Contact.ADD(arg0.getReader().readLine());
		


	
	}
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		
		
		System.out.println("Get request - ALL");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String strJson = gson.toJson(Contact.getContacts());
		
		ModelAndView model = new ModelAndView();
		
		
		return new ModelAndView("test", "msg", strJson);
		
		
		
		
	}

	
	
	
	
	
	protected ModelAndView Bla(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {


		System.out.println("Nista");
		arg1.setContentType("text/html");
		arg1.getWriter().println("blaBla");
		return null;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("DELETE - Contact deleted");
		Contact.DELETE(req.getParameter("deleteContact"));
		
	}
	


	@RequestMapping(method = RequestMethod.PUT)
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("PUT - Contact Updated");
		Contact.UPDATE(req.getReader().readLine());
	
	}

}
