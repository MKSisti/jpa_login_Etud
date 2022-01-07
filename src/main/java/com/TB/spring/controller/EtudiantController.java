package com.TB.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TB.spring.DAO.EtudiantDaoImpl;
import com.TB.spring.DAO.FiliereDaoImpl;
import com.TB.spring.Entities.Etudiant;
import com.TB.spring.Entities.Filiere;

@Controller
public class EtudiantController {
	
	@RequestMapping(value = "/etudiant/goToEtudiant", method = RequestMethod.GET)
	public String goToEtHome() {
		return "redirect:/etudiant";
	}
//	
	@RequestMapping(value = "/etudiant", method = RequestMethod.GET)
	public String getAll(Model model,EtudiantDaoImpl ed) {
		model.addAttribute("Etudiants",ed.findAll());
		return "etudiantslist";
	}
	
//	creating
	
	@RequestMapping(value = "/etudiant/create", method = RequestMethod.GET)
	public String goToCreate(FiliereDaoImpl fd, Model model) {
		model.addAttribute("filieres",fd.findAll());
		return "createEtudiant";
	}
	
	@RequestMapping(value = "/etudiant/createetud", method = RequestMethod.POST)
	public String doCreate(EtudiantDaoImpl ed,FiliereDaoImpl fd, @RequestParam Long filiereId,@RequestParam String prenom, @RequestParam String nom, @RequestParam String email, @RequestParam String tel) {
		System.out.println("from create");
		Filiere f = fd.findById(filiereId);
		Etudiant e = new Etudiant();
		e.setEmail(email);
		e.setFiliere(f);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setTel(tel);
		ed.save(e);
		return "redirect:/etudiant";
	}
	
//	updating :
	
	@RequestMapping(value = "/etudiant/update", method= RequestMethod.GET)
	public String update(@RequestParam Long id , EtudiantDaoImpl ed,FiliereDaoImpl fd,Model model) {
		model.addAttribute("etudiant",ed.findById(id)) ;
		model.addAttribute("filieres",fd.findAll());
		return "updateEtudiant";
	}
	
	@RequestMapping(value = "/etudiant/DoUpdate",method = RequestMethod.POST)
	public String doUpdate(EtudiantDaoImpl ed,FiliereDaoImpl fd, @RequestParam Long filiereId,@RequestParam Long id,@RequestParam String prenom, @RequestParam String nom, @RequestParam String email, @RequestParam String tel) {
		System.out.println("trying to update boss ...");
		Filiere fil = fd.findById(filiereId);
		System.out.println("fil :" + fil.toString());
		Etudiant etudiant = new Etudiant();
		System.out.println("etudiant created, will try to set attribute now ...");
		etudiant.setEmail(email);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setTel(tel);
		etudiant.setId(id);
		etudiant.setFiliere(fil);
		ed.update(etudiant);
		return "redirect:/etudiant";
	}
	
// 	delete
	
	@RequestMapping(value = "/etudiant/delete", method = RequestMethod.POST)
	public String DoDelete(@RequestParam Long id , EtudiantDaoImpl ed) {
		ed.deleteById(id);
		return "redirect:/etudiant";
	}

}
