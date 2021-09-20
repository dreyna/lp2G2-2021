package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Rol;
import pe.edu.upeu.lp2clase02g2.repository.RolRepository;
@Service
public class RolService implements SRol {
@Autowired
private RolRepository rolRepository;
	@Override
	public Rol create(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Rol read(Long id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rol update(Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

}
