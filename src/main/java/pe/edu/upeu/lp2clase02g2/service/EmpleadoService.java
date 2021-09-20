package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Empleado;
import pe.edu.upeu.lp2clase02g2.repository.EmpleadoRepository;
@Service
public class EmpleadoService implements SEmpleado{
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public Empleado create(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public List<Empleado> readAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado read(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);
	}

	@Override
	public Empleado update(Empleado al) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(al);
	}

}
