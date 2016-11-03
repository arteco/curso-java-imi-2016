package es.palmademallorca.imi.proyecto2.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;
import es.palmademallorca.imi.proyecto2.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostConstruct
	public void init(){
		System.out.println("Creando Person Controller");
		System.out.println("Valor de personService "+personService);
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String list(Model model){
		List<PersonDto> personList = personService.getPeople();
		model.addAttribute("people", personList);
		return "list";
	}
	
	@RequestMapping(value = "/edit",method=RequestMethod.GET)
	public String getPerson(
			Model model,
			@RequestParam(value = "id", required=false) Long id){
		PersonDto person = null;
		if (id!= null){
			person = personService.getPerson(id);
		} else {
			person = new PersonDto();
		}
		model.addAttribute("person", person);
		return "edit";
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String removePerson(
			@RequestParam("id") Long id){
		personService.remove(id);
		return "redirect:/person";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePerson(
			Model model,
			PersonDto person){
		personService.save(person);
		model.addAttribute("person", person);
		return "edit";
	}
}
