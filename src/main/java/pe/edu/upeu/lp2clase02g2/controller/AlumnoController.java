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

import pe.edu.upeu.lp2clase02g2.model.Alumno;
import pe.edu.upeu.lp2clase02g2.service.AlumnoService;

@RestController
@RequestMapping("/api")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	
	@PostMapping("/alumno")
	public ResponseEntity<Alumno> save(@RequestBody Alumno alum){
		try {
			Alumno al = alumnoService.create(new Alumno(alum.getNombre()));
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/alumnos")
	public ResponseEntity<List<Alumno>> getAlumnos(){
		try {
			List<Alumno> list = new ArrayList<>();
			list = alumnoService.readAll();
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
