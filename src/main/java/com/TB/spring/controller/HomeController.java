package com.TB.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.TB.spring.DAO.ArticleDaoImpl;
import com.TB.spring.Entities.Article;

@Controller
public class HomeController {

	// serve home page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		return "Login";
	}
	
	@GetMapping(value = "/goHome")
	public RedirectView goHome() {
		return new RedirectView("/",true);
	}
	
	// create
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
//		System.out.println("from /create");
		return "createArticle";
	}
	
	@RequestMapping(value = "/DoCreate", method = RequestMethod.POST)
	public RedirectView DoCreate(@Validated Article a,ArticleDaoImpl AM) {
//		System.out.println("from create :\n"+a.toString());
		AM.save(a);
		return new RedirectView("/",true);
	}
	
	// update
	@RequestMapping(value = "/update", method= RequestMethod.GET)
	public String update(@RequestParam Integer code , ArticleDaoImpl AM,Model model) {
//		System.out.println(code);
		model.addAttribute("article",AM.findById(code)) ;
		return "updateArticle";
	}
	
	@RequestMapping(value = "/DoUpdate",method = RequestMethod.POST)
	public RedirectView doUpdate(@Validated Article a , ArticleDaoImpl AM) {
		System.out.println("from update "+a.getCount()+" "+a.getCode());
		AM.update(a);
		return new RedirectView("/",true);
	}
	
	// delete
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public RedirectView DoDelete(@RequestParam Integer code , ArticleDaoImpl AM) {
		AM.deleteById(code);
		return new RedirectView("/",true);
	}
}
