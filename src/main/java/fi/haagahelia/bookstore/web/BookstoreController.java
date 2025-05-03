package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookstoreController {
    private BookRepository repository;

    public BookstoreController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = {"/", "booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}
