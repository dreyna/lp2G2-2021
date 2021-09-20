package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Usuario;

public interface SUsuario {
	Usuario create(Usuario user);
	List<Usuario> readAll();
	Usuario read(Long id);
	void delete(Long id);
	Usuario update(Usuario user);
}
