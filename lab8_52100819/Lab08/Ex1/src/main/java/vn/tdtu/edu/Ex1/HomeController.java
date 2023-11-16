package vn.tdtu.edu.Ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String handleContactForm(ContactForm contactForm, Model model) {
        model.addAttribute("name", contactForm.getName());
        model.addAttribute("email", contactForm.getEmail());
        model.addAttribute("message", contactForm.getMessage());
        return "contact-result";
    }
}
