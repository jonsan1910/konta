package com.tuxdev.kontaweb.controller;

import com.tuxdev.kontaweb.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {



	@RequestMapping(value = "/")
	public String root(ModelMap model) {

        model.addAttribute("title","KONTA");
		return Constants.Results.VIEW_SIGNED_IN.getValue();
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap model) {

		model.addAttribute("title","Konta Login");
		return "login";
	}

	@RequestMapping(value = "/views/{section}/{page}")
	public String page(@PathVariable("section") final String section,@PathVariable("page") final String page) {
		String path=section;
		if(section.contains(".")){
			path=section.replace(".","/");
		}
		return Constants.Results.VIEWS.getValue()+path+"/"+page;
	}

	@RequestMapping(value = "/views/{section}/{page}/{parameter}")
	public String pageParameter(@PathVariable("section") final String section,@PathVariable("page") final String page,@PathVariable("parameter") final String parameter) {

		return Constants.Results.VIEWS.getValue()+section+"/"+page;
	}

}