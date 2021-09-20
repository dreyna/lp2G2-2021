package pe.edu.upeu.lp2clase02g2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.lp2clase02g2.model.Acceso;

@Repository
public interface AccesosRepository extends JpaRepository<Acceso, Long>{

}
