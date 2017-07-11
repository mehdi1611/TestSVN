package org.houdaf.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("IR")
public class Ir extends Taxe{

	public Ir() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ir(String titre, Date dateTaxe, double montant,
			Entreprise entreprise) {
		super(titre, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}

}
