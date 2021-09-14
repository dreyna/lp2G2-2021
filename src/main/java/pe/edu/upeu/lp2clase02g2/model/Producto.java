package pe.edu.upeu.lp2clase02g2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="productos")
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long idproducto;

@Column(name="nombre")
private String nombre;
@Column(name="precio")
private double precio;
@Column(name="cantidad")
private int cantidad;
public Producto() {
	super();
}
public Producto(String nombre, double precio, int cantidad) {
	super();
	this.nombre = nombre;
	this.precio = precio;
	this.cantidad = cantidad;
}
public long getIdproducto() {
	return idproducto;
}
public void setIdproducto(long idproducto) {
	this.idproducto = idproducto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

}
