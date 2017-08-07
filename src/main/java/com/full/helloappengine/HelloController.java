package com.full.helloappengine;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



@Controller
public class HelloController extends AbstractController{

	@Override
	@RequestMapping(value = "/welcome22", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		System.out.println("We are in Hello Controller");
		ModelAndView model = new ModelAndView("test");
		model.addObject("msg", "hello world");
		
		ArrayList<String> list = new ArrayList<>();

		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");

		System.out.println("We are leaving Hello Controler");
		return new ModelAndView("test","WelcomeMessage", list);
	}
	
	
	public String write(){
		
		ModelAndView model = new ModelAndView("test");
		model.addObject("msg", "hello world");
		

		System.out.println("In method");
		//return model;
		
		
		return "This is the answer";
	}

}
