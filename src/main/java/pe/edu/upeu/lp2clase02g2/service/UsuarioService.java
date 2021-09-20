package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Usuario;
import pe.edu.upeu.lp2clase02g2.repository.UsuarioRepository;
@Service
public class UsuarioService implements SUsuario {
@Autowired
private UsuarioRepository usuarioRepository;
	@Override
	public Usuario create(Usuario user) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(user);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario read(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario update(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

}
