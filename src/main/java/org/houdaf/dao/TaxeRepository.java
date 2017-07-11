package org.houdaf.dao;



import java.util.List;

import org.houdaf.entities.Entreprise;
import org.houdaf.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Taxe, Long>{
	public List<Taxe> findByEntreprise(Entreprise e);
}
