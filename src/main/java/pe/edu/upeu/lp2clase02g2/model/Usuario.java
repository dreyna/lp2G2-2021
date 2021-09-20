package pe.edu.upeu.lp2clase02g2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idusaurio;
	private String username;
	private String password;
	private int estado;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
	private Empleado empleado;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_idrol")
	private Rol rol;
}
