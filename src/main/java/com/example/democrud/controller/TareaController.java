package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.democrud.model.Tarea;
import com.example.democrud.service.api.TareaServiceApi;

@Controller
public class TareaController {

	@Autowired
	private TareaServiceApi tareaServiceApi;

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("list", tareaServiceApi.getAll());

		return "index";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("tarea", tareaServiceApi.get(id));
		}else {
			model.addAttribute("tarea", new Tarea());
		}

		return "save";
	}

	@PostMapping("/save")
	public String save(Tarea tarea, Model model) {

		tareaServiceApi.save(tarea );

		return "redirect:/";
	}


	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {

		tareaServiceApi.delete(id);

		return "redirect:/";
	}

}
