package hh.backend.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hh.backend.bookstore.domain.Book;



@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        
}

@GetMapping("/index")
public String getMethodName(Model model) {
    model.addAttribute("book", new Book());
    return "bookstore";
}

}

