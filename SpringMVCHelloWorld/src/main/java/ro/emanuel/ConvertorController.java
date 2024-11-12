package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertorController {

    @RequestMapping("/convert")
    public String convert(@RequestParam("suma") double suma,
                          @RequestParam("from") String from,
                          @RequestParam("to") String to,
                          @RequestParam("rate") double rate,
                          Model model) {
        double result = suma * rate;
        String resultText = String.format("%.2f %s", result, to);
        model.addAttribute("result", resultText);
        return "convertor"; 
    }
}
