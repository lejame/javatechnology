package tdtd.edu.vn.lab8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/about")
    public String About(){return "about";}

    @GetMapping("/contact")
    public String Contact(){return "contact";}
}
