package es.palmademallorca.imi.proyecto2.controller;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;
import es.palmademallorca.imi.proyecto2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostConstruct
    public void init() {
        System.out.println("Creando Person Controller");
        System.out.println("Valor de personService " + personService);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        List<PersonDto> personList = personService.getPeople();
        model.addAttribute("people", personList);
        return "list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getPerson(
            Model model,
            @RequestParam(value = "id", required = false) Long id) {
        PersonDto person;
        if (id != null) {
            person = personService.getPerson(id);
        } else {
            person = new PersonDto();
        }
        model.addAttribute("person", person);
        return "edit";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removePerson(
            @RequestParam("id") Long id) {
        personService.remove(id);
        return "redirect:/person";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(
            Model model,
            @ModelAttribute("person") @Valid PersonDto person,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            personService.save(person);
            redirectAttributes.addFlashAttribute("sp", "Guardado Correctamente!");
            return "redirect:/person/edit?id=" + person.getId();
        }
        model.addAttribute("person", person);
        return "edit";
    }
}
