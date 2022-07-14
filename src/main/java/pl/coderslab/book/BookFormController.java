package pl.coderslab.book;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {

    private final PublisherService publisherService;
    private final BookService bookService;
    private final AuthorService authorService;

    @ModelAttribute("publishers")
    public List<Publisher> publisherList(){
        return publisherService.getAll();
    }
    @ModelAttribute("authors")
    public List<Author> authorList(){
        return authorService.getAll();
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String save(Book book){
        bookService.saveBook(book);
        return "redirect:/book/all";
    }
    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable long id){
        model.addAttribute("book", bookService.findById(id));
        return "book/add";
    }
    @PostMapping("/edit/{id}")
    public String editBook(Book book){
        bookService.update(book);
        return "redirect:/book/all";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(Model model, @PathVariable long id){
        model.addAttribute("book", bookService.findById(id));
        return "book/check";
    }
    @GetMapping("/confirm/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.delete(bookService.findById(id));
        return "redirect:/book/all";
    }
}
