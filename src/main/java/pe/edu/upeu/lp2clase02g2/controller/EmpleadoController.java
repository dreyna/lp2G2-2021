package pe.edu.upeu.lp2clase02g2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pe.edu.upeu.lp2clase02g2.model.Empleado;
import pe.edu.upeu.lp2clase02g2.service.SEmpleado;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	@Autowired
	private SEmpleado sEmpleado;	
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
		try {
			Empleado emp = sEmpleado.create(new Empleado(empleado.getIdempleado(),empleado.getNombres(), 
					empleado.getApellidos(), empleado.getDni(), empleado.getTelefono(), empleado.getUsuario()));
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> getEmpleados(){
		try {
			List<Empleado> list = new ArrayList<>();
			list = sEmpleado.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
