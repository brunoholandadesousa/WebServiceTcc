package com.example.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
public class TesteController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
    String index() {
		System.out.println("aki");
		return "{\"nome:\"\"everton\"}";
    }
}
