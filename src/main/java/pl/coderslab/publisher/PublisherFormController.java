package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher/form")
@RequiredArgsConstructor
public class PublisherFormController {

    PublisherService publisherService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }
    @PostMapping("/add")
    public String save(Publisher publisher){
        publisherService.savePublisher(publisher);
        return "/publisher/allPublishers";
    }
    @GetMapping("/edit/{id}")
    public String editPublisher(Model model, @PathVariable long id){
        model.addAttribute("publisher", publisherService.findById(id));
        return "publisher/add";
    }
    @PostMapping("/edit/{id}")
    public String editPublisher(Publisher publisher){
        publisherService.update(publisher);
        return "redirect:/publisher/allPublishers";
    }
    @GetMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable long id){
        publisherService.delete(publisherService.findById(id));
        return "redirect:/publisher/allPublishers";
    }


}
