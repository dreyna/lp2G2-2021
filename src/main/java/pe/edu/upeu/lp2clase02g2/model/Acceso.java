package pe.edu.upeu.lp2clase02g2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "acceso")
public class Acceso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idacceso;
	private String menu;
	private String url;
	private String icono;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "acceso_rol",
            joinColumns = {@JoinColumn(name = "acceso_idacceso")},
            inverseJoinColumns = {@JoinColumn(name = "rol_idrol")})
	private Set<Rol> roles;

}
