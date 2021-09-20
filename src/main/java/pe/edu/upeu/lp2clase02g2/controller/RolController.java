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

import pe.edu.upeu.lp2clase02g2.model.Rol;
import pe.edu.upeu.lp2clase02g2.service.SRol;

@RestController
@RequestMapping("/api")
public class RolController {
	@Autowired
	private SRol sRol;
	
	@PostMapping("/roles")
	public ResponseEntity<Rol> save(@RequestBody Rol rol) {
		try {
			Rol r = sRol.create(new Rol(rol.getIdrol(), rol.getNomrol(), rol.getUsuarios(),rol.getAccesos()));
			return new ResponseEntity<>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/roles")
	public ResponseEntity<List<Rol>> getEmpleados() {
		try {
			List<Rol> list = new ArrayList<>();
			list = sRol.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
