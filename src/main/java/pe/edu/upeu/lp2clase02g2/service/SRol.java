package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Rol;


public interface SRol {
	Rol create(Rol rol);
	List<Rol> readAll();
	Rol read(Long id);
	void delete(Long id);
	Rol update(Rol rol);
}
