package pe.edu.upeu.lp2clase02g2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idempleado;
	private String nombres;
	private String apellidos;
	private String dni;	
	private String telefono;
	@OneToOne(mappedBy = "empleado")
	private Usuario usuario;

}
