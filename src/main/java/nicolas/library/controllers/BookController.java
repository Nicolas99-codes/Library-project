package nicolas.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping({"/BookList"})
    public String BookList() {

        return "BookList";
    }
}
