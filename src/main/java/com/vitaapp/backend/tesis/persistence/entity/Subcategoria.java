package com.vitaapp.backend.tesis.persistence.entity;

import org.hibernate.validator.constraints.Length;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "subcategorias")
public class Subcategoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategoria")
	private Integer idSubcategoria;

	@Column(length = 25)
	@Length(max = 25, message = "Longitud maxima del campo nombre max 15 caracteres")
	@NotBlank(message = "Debe ingresar un nombre de la categoria")
	private String nombre;

	@Column(length = 40)
	@Length(max = 40, message = "Longitud maxima del campo descripción max 40 caracteres")
	@NotBlank(message = "Debe ingresar un nombre de la categoria")
	private String descripcion;

	private boolean mostrar;

	@Column(name = "imagen_url")
	@NotBlank(message = "Debe ingresar una imagen")
	private String imagenUrl;

	@Column(name = "id_categoria")
	private Integer idCategoria;

	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;

	@OneToMany(mappedBy = "subcategoria")
	private List<Pictograma> pictogramas;

	@OneToMany(mappedBy = "subcategoria")
	private List<SubcategoriaPersonalizada> subcategoriasPersonalizadas;

	@OneToMany(mappedBy = "subcategoria")
	private List<ImagenSubcategoria> imagenesSubcategorias;

	public List<SubcategoriaPersonalizada> getSubcategoriasPersonalizadas() {
		return subcategoriasPersonalizadas;
	}

	public void setSubcategoriasPersonalizadas(List<SubcategoriaPersonalizada> subcategoriasPersonalizadas) {
		this.subcategoriasPersonalizadas = subcategoriasPersonalizadas;
	}

	public Integer getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(Integer idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Pictograma> getPictogramas() {
		return pictogramas;
	}

	public void setPictogramas(List<Pictograma> pictogramas) {
		this.pictogramas = pictogramas;
	}

	public List<ImagenSubcategoria> getImagenesSubcategorias() {
		return imagenesSubcategorias;
	}

	public void setImagenesSubcategorias(List<ImagenSubcategoria> imagenesSubcategorias) {
		this.imagenesSubcategorias = imagenesSubcategorias;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}
}
