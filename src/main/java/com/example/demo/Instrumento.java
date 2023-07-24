package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Instrumento {

	private @Id @GeneratedValue Long id; 
	private String nombre;
	@ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

	private Instrumento() {}

	public Instrumento(String nombre, Categoria categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Instrumento instrumento = (Instrumento) o;
		return Objects.equals(id, instrumento.id) &&
			Objects.equals(nombre, instrumento.nombre) &&
			Objects.equals(categoria, instrumento.categoria);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nombre, categoria);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Instrumento{" +
			"id=" + id +
			", nombre='" + nombre + '\'' +
			", id_categoria='" + categoria + '\'' +
			'}';
	}
}
