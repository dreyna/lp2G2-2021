package pe.edu.upeu.lp2clase02g2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.lp2clase02g2.model.Empleado;
import pe.edu.upeu.lp2clase02g2.model.Rol;
import pe.edu.upeu.lp2clase02g2.model.Usuario;
import pe.edu.upeu.lp2clase02g2.service.SEmpleado;
import pe.edu.upeu.lp2clase02g2.service.SRol;
import pe.edu.upeu.lp2clase02g2.service.SUsuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private SUsuario sUsuario;
	@Autowired
	private SEmpleado sEmpleado;
	@Autowired
	private SRol sRol;

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> save(@RequestBody Usuario user) {
		try {
			//Rol rol = sRol.read(user.getRol().getIdrol());
			//Empleado emp = sEmpleado.read(user.getEmpleado().getIdempleado());
			Usuario u = sUsuario.create(new Usuario(user.getIdusaurio(),user.getUsername(), 
					user.getPassword(), user.getEstado(), user.getEmpleado(),user.getRol()));
			System.out.println(user.getEmpleado().getIdempleado());
			return new ResponseEntity<>(u, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getEmpleados() {
		try {
			List<Usuario> list = new ArrayList<>();
			list = sUsuario.readAll();
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
