package pl.coderslab.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "/student/add";
    }
    @PostMapping("/add")
    @ResponseBody
    public String save(Student student){
        return "Cześć jestem " + student.firstName +
                " moje naziwsko to " + student.lastName +
                " moja płeć " + student.getGender() +
                " mieszkam w " + student.getCountry() +
                " moje notatki " + student.getNotes() +
                " czy chce liste mailingowa " + student.isMailingList() +
                " znam " + student.getProgrammingSkills() +
                " moje hobby to " + student.getHobbies();
    }

    @ModelAttribute("countries")
    public List<String> countries(){
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        return Arrays.asList("pływanie", "śpiwanie", "czytanie", "bieganie");
    }
    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills(){
        return Arrays.asList("java", "php", "typescript", "python");
    }

}
