package org.houdaf;

import java.util.Date;

import org.houdaf.dao.EntrepriseRepository;
import org.houdaf.dao.TaxeRepository;
import org.houdaf.entities.Entreprise;
import org.houdaf.entities.Ir;
import org.houdaf.entities.Tva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner{
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	public static void main(String[] args){
		SpringApplication.run(TaxesApplication.class, args);
	}
	@Override 
	public void run(String... arg0) throws Exception {
		Entreprise e1=entrepriseRepository.save(new Entreprise("nom1", "email1@gmail.com", "raisonSociale1"));
		Entreprise e2=entrepriseRepository.save(new Entreprise("nom2", "email2@gmail.com", "raisonSociale2"));
		Entreprise e3=entrepriseRepository.save(new Entreprise("nom3", "email3@gmail.com", "raisonSociale3"));
		taxeRepository.save(new Tva("titre1", new Date(), 1535, e1));
		taxeRepository.save(new Tva("titre1", new Date(), 300, e2));
		taxeRepository.save(new Ir("titre1", new Date(), 12, e3));
		taxeRepository.save(new Tva("titre1", new Date(), 4000, e1));
//		Test a=0;
	}
}
