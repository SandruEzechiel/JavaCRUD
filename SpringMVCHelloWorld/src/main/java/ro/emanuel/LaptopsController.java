package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LaptopsController {

    @RequestMapping("/laptops")
    public String displayBrand(@RequestParam("brand") String brand, Model model) {
        int length = brand.length();
        String parity = (length % 2 == 0) ? "par" : "impar";
        model.addAttribute("brand", brand);
        model.addAttribute("length", length);
        model.addAttribute("parity", parity);
        return "brand"; 
    }
   
    	@RequestMapping("/laptop")
        public String displayLaptop(Model model) {
            Laptop laptop = new Laptop("Dell", 2500, 16);
            model.addAttribute("lap", laptop);
            return "laptop"; 
        }
    }


