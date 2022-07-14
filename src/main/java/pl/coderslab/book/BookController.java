package pl.coderslab.book;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherService.savePublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(authorService.read(1l));
        authors.add(authorService.read(2l));
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(4);
        book.setDescription("Podstawowa książka do programowania w JAVIE");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookService.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }
    @RequestMapping("/getBookWithAuthors/{id}")
    @ResponseBody
    public String getBookWithAuthors(@PathVariable long id) {
        Book book = bookService.findById(id);
        Hibernate.initialize(book.getAuthors());
        return book.toString();
    }

    @RequestMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/all";
    }

    @RequestMapping("/all/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        return bookService.findAllByRating(rating).toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }
}