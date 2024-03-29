package com.vitaapp.backend.tesis.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "adultos_categorias_personalizadas")
public class AdultoCategoriaPersonalizada {
	
	@EmbeddedId
	private AdultoCategoriaPersonalizadaPK id;

	@ManyToOne
	@JoinColumn(name = "id_adulto", insertable = false, updatable = false)
	private Adulto adulto;

	@ManyToOne
	@JoinColumn(name = "id_categoria_personalizada", insertable = false, updatable = false)
	private CategoriaPersonalizada categoriaPersonalizada;


	public AdultoCategoriaPersonalizadaPK getId() {
		return id;
	}

	public void setId(AdultoCategoriaPersonalizadaPK id) {
		this.id = id;
	}

	public Adulto getAdulto() {
		return adulto;
	}

	public void setAdulto(Adulto adulto) {
		this.adulto = adulto;
	}

	public CategoriaPersonalizada getCategoriaPersonalizada() {
		return categoriaPersonalizada;
	}

	public void setCategoriaPersonalizada(CategoriaPersonalizada categoriaPersonalizada) {
		this.categoriaPersonalizada = categoriaPersonalizada;
	}
}
