package org.houdaf.web;

import java.util.List;

import org.houdaf.dao.EntrepriseRepository;
import org.houdaf.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxeRestController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@RequestMapping("/listEntreprises")
	public Page<Entreprise> list(@RequestParam(name="motCle", defaultValue="") String motCle, @RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="size", defaultValue="5")int size){
		return entrepriseRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
	}
}
