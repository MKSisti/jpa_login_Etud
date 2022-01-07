package com.TB.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TB.spring.DAO.FiliereDaoImpl;
import com.TB.spring.Entities.Filiere;

@Controller
public class FiliereController {
	
	@RequestMapping(value = "/filiere/goToFiliere", method = RequestMethod.GET)
	public String goToFilHome() {
		return "redirect:/filiere";
	}
	
	@RequestMapping(value = "/filiere", method = RequestMethod.GET)
	public String getAll(Model model,FiliereDaoImpl fd) {
		model.addAttribute("Filieres",fd.findAll());
		return "filiereslist";
	}
//	list 
	@RequestMapping(value = "/filiere/list", method = RequestMethod.GET)
	public String list(@RequestParam Long id,FiliereDaoImpl fd,Model model) {
		Filiere fil = fd.findById(id);
//		System.out.println(fil.getEtudiants());
		model.addAttribute("Etudiants",fil.getEtudiants());
		return "listEtFil";
	}
	
//	creating
	
	@RequestMapping(value = "/filiere/create", method = RequestMethod.GET)
	public String goToCreate() {
		return "createFiliere";
	}
	
	@RequestMapping(value = "/filiere/Createfil", method = RequestMethod.POST)
	public String doCreate(@Validated Filiere f, FiliereDaoImpl fd) {
		System.out.println(f);
		fd.save(f);
		return "redirect:/filiere";
	}
	
//	updating :
	
	@RequestMapping(value = "/filiere/update", method= RequestMethod.GET)
	public String update(@RequestParam Long id , FiliereDaoImpl fd,Model model) {
		model.addAttribute("filiere",fd.findById(id)) ;
		return "updateFiliere";
	}

	@RequestMapping(value = "/filiere/DoUpdate",method = RequestMethod.POST)
	public String doUpdate(@Validated Filiere f , FiliereDaoImpl fd) {
		fd.update(f);
		return "redirect:/filiere";
	}
	
// 	delete
	
	@RequestMapping(value = "/filiere/delete", method = RequestMethod.POST)
	public String DoDelete(@RequestParam Long id , FiliereDaoImpl fd) {
		fd.deleteById(id);
		return "redirect:/filiere";
	}

}

//