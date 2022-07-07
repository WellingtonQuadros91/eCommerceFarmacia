package com.generation.eFarmacia.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.eFarmacia.Repository.ProdutosRepository;
import com.generation.eFarmacia.model.Produtos;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> GetById(@PathVariable long id){
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeDoProduto/{nomeDoProduto}")
	public ResponseEntity<List<Produtos>> GetByNomeDoProduto(@PathVariable String nomeDoProduto){
		return ResponseEntity.ok(produtosRepository.findAllByNomeDoProdutoContainingIgnoreCase(nomeDoProduto));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> Post (@Valid @RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> Put (@Valid @RequestBody Produtos produtos){
		
		return produtosRepository.findById(produtos.getId())
		.map(resposta -> {
			return ResponseEntity.ok().body(produtosRepository.save(produtos));
		})
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProudutos(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resposta ->{
					produtosRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}

