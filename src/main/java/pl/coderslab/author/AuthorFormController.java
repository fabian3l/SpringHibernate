package pl.coderslab.author;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author/form")
@RequiredArgsConstructor
public class AuthorFormController {

    AuthorService authorService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("author", new Author());
        return "author/add";
    }
    @PostMapping("/add")
    public String save(Author author){
        authorService.createAuthor(author);
        return "redirect:/book/all";
    }
    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(Model model, @PathVariable long id){
        model.addAttribute("author", authorService.read(id));
        return "author/check";
    }
    @GetMapping("/confirm/{id}")
    public String deleteAuthor(@PathVariable long id){
        authorService.delete(authorService.read(id));
        return "redirect:/author/allAuthors";
    }
    @GetMapping("/edit/{id}")
    public String editAuthor(Model model, @PathVariable long id){
        model.addAttribute("author", authorService.read(id));
        return "author/add";
    }
    @PostMapping("/edit/{id}")
    public String editAuthor(Author author){
        authorService.update(author);
        return "redirect:/author/allAuthors";
    }
}
