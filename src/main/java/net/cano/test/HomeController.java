package net.cano.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/work")
    public String homework() {
		logger.debug("HomeController: Passing through...");
       // return "compareResult";
		return "ajax";
    }
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping( value ="/time" ,method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("Welcome home! The client locale is");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "123" );
		
		return "home";
	}
	/*
	 * compare.
	*/
	 @RequestMapping(value = "/compare"  ,method = RequestMethod.POST)
	    public String compare(@RequestParam String name,
	            @RequestParam int age, Model model) {

	       
		 model.addAttribute("name", name);
	        model.addAttribute("age", age);
	        return "request";
	    }
	
	 @RequestMapping(value = "/ajax" )
	 @ResponseBody
	    public Map<String , String> handleajaxrequest(@RequestParam String name,
	            @RequestParam String age, Model model) {

	       String result = "false";
	       Map<String , String> map = new  HashMap <String , String>();
	       if(name != null && age != null){
	    	   result ="true";
	    	   map.put("name", name);
	    	   map.put("age", age);
	       }
	       map.put("result", result);
		
	        return map;
	    }
	

	  
	
}
