package org.houdaf.web;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.houdaf.dao.EntrepriseRepository;
import org.houdaf.dao.TaxeRepository;
import org.houdaf.entities.Entreprise;
import org.houdaf.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxeControler {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository TaxeRepository;
	@RequestMapping(value="/entreprise",method=RequestMethod.GET)
	public String index(Model model, @RequestParam(name="motCle", defaultValue="") String motcle, @RequestParam(name="page", defaultValue="0") int p, @RequestParam(name="size",defaultValue="5") int s){
		Page<Entreprise> pageEntreprises=entrepriseRepository.chercher("%"+motcle+"%", new PageRequest( p, s));
		model.addAttribute("listEntreprises",pageEntreprises.getContent());
		int[] pages=new int[pageEntreprises.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", motcle);
		return "entreprise";
	}
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model){
		model.addAttribute("entreprise",new Entreprise()); 
		return "formEntreprise";
	}
	@RequestMapping(value="/saveEntreprise")
	public String saveEntreprise(@Valid Entreprise e,BindingResult bindingResult){
		if(bindingResult.hasErrors()) return "formEntreprise";
		entrepriseRepository.save(e); 
		return "redirect:/entreprise";
	}
	@RequestMapping(value="/taxes")
	public String taxes(Model model, @RequestParam(name="code",defaultValue="-1") Long code){
		model.addAttribute("entreprise",entrepriseRepository.findAll());
		if(code==-1) model.addAttribute("taxes",new ArrayList<Taxe>());
		else {
		Entreprise e=new Entreprise();
		e.setCode(code);
		model.addAttribute("taxes",TaxeRepository.findByEntreprise(e));
		}
		return "taxes";
	}
}
