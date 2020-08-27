package com.codgiomau.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codgiomau.myfirstproject.entities.Product;
import com.codgiomau.myfirstproject.repositories.ProductRepository;

@RestController //para que o spring reconheca a classe como recurso
@RequestMapping(value = "/products") //para mapeamento de URL
public class ProductResource {

	//colocar a injecao de dependecia do productRepository atraves do Autowired, pois ele busca instancia
	//da dependencia utilizada. Para que isso desse certo e a classe productReposiory participe da
	//injecao de dependencia deve se usar a notacao @component
	@Autowired
	private ProductRepository productRespository;
	
	@GetMapping //para responder por uma requisicao get, quando fizer um get no caminho /categories
	public ResponseEntity<List<Product>> findAll() { //pelo generics informa o tipo de resposta
//		List<product> list = new ArrayList<product>();
//		list.add(new product(1L, "Eletronics"));
//		list.add(new product(2L, "Books"));
		//vamos buscar no productrepository fazendo a injecao de dependecnias do spring
		List<Product> list = productRespository.findAll();
		
		return ResponseEntity.ok().body(list); //.ok devolve uma resposta da serie 200 do http, o coorpo da resposta será a lista
	}

	@GetMapping(value = "/{id}") //no caminho vai ter uma / e um numero do id
	public ResponseEntity<Product> findById(@PathVariable Long id) { //retorna apenas uma categoria. 
		//a  notation @PathVariable recebe o numero do id na url
		//product cat =  new product(1L, "Eletronics");
		Product cat = productRespository.findById(id).get(); //.get para pegar o objeto, pois retorna opcional
		return ResponseEntity.ok().body(cat); 
	}
}

