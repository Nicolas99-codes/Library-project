package nicolas.library.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import nicolas.library.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Enumeration;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping({"/login"})
    public String login(Principal principal, Model model, HttpServletRequest request) {
        if (principal != null) return "redirect:/homepage";
        if(request.getHeader("Referer") != null && !request.getHeader("Referer").contains("login") && !request.getHeader("Referer").contains("logout")) {
            if (httpSession.getAttribute("redirectFromLogin") == null) {
                httpSession.setAttribute("redirectFromLogin", request.getHeader("Referer"));
            }
        }
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.equals("error") || paramName.equals("logout")) {
                model.addAttribute("authState", paramName);
            }
        }

        return "user/login";
    }

    @GetMapping({"/register"})
    public String register(Principal principal, Model model) {
        if (principal != null) return "redirect:/homepage";


        model.addAttribute("newUser", new AppUser());
        return "user/register";
    }
}
