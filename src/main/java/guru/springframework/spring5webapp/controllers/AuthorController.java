package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

//    Autowire by constructor author repository into controller
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors") //request mapping url to the authors url to render the view
    public String getAuthors(Model model) { //getting the model provided by the spring MVC
//        we attach a list of authors to the authors property
        model.addAttribute("authors", authorRepository.findAll());
//        return the view name of authors
        return "authors";
    }
}
