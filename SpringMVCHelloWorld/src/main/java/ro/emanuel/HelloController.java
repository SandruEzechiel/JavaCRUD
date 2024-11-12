package ro.emanuel;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class HelloController {
	
	@RequestMapping(value="hello.htm")
	public ModelAndView getIndex() {
		ModelMap model = new ModelMap();
		model.put("name", "Mircea");
		model.put("date",(new Date().toString()));
		return new ModelAndView("hello.jsp", model);
	 
 }
}
