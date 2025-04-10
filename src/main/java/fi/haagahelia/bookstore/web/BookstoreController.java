package fi.haagahelia.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookstoreController {
    @GetMapping("/index")
    public String getMethodName(@RequestParam String param) {
        return "index";
    }
    
}
