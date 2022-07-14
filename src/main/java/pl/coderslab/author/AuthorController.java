package pl.coderslab.author;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/create")
    @ResponseBody
    public String createAuthor(){
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        authorService.createAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        Author author= authorService.read(id);
        return author.toString();
    }
    @RequestMapping("/all")
    public String getAll(Model model){
        model.addAttribute("authors", authorService.getAll());
        return "author/allAuthors";
    }
    @RequestMapping("/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorService.read(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletAuthor(@PathVariable Long id) {
        Author author = authorService.read(id);
        authorService.delete(author);
        return "deleted";
    }
}
