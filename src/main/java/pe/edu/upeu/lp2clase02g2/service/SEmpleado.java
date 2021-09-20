package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Empleado;



public interface SEmpleado {
	Empleado create(Empleado empleado);
	List<Empleado> readAll();
	Empleado read(Long id);
	void delete(Long id);
	Empleado update(Empleado al);
}
