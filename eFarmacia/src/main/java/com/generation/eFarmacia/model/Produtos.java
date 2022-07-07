package com.generation.eFarmacia.model;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos")
public class Produtos {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		private String nomeDoProduto;
		
		@NotNull
		private BigDecimal preco;
		
		private int estoque;
		
		private Date Validade;
		
		@ManyToOne
		@JsonIgnoreProperties("produtos")
		private Categorias categorias;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNomeDoProduto() {
			return nomeDoProduto;
		}

		public void setNomeDoProduto(String nomeDoProduto) {
			this.nomeDoProduto = nomeDoProduto;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public Date getValidade() {
			return Validade;
		}

		public void setValidade(Date validade) {
			Validade = validade;
		}

		public Categorias getCategorias() {
			return categorias;
		}

		public void setCategorias(Categorias categorias) {
			this.categorias = categorias;
		}

}
