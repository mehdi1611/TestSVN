package org.houdaf.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("TVA")
public class Tva extends Taxe{

	public Tva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tva(String titre, Date dateTaxe, double montant,
			Entreprise entreprise) {
		super(titre, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}

}
