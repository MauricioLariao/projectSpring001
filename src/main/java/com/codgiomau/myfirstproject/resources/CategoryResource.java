package com.codgiomau.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codgiomau.myfirstproject.entities.Category;
import com.codgiomau.myfirstproject.repositories.CategoryRepository;

@RestController //para que o spring reconheca a classe como recurso
@RequestMapping(value = "/categories") //para mapeamento de URL
public class CategoryResource {

	//colocar a injecao de dependecia do categoryRepository atraves do Autowired, pois ele busca instancia
	//da dependencia utilizada. Para que isso desse certo e a classe CategoryReposiory participe da
	//injecao de dependencia deve se usar a notacao @component
	@Autowired
	private CategoryRepository categoryRespository;
	
	@GetMapping //para responder por uma requisicao get, quando fizer um get no caminho /categories
	public ResponseEntity<List<Category>> findAll() { //pelo generics informa o tipo de resposta
//		List<Category> list = new ArrayList<Category>();
//		list.add(new Category(1L, "Eletronics"));
//		list.add(new Category(2L, "Books"));
		//vamos buscar no categoryrepository fazendo a injecao de dependecnias do spring
		List<Category> list = categoryRespository.findAll();
		
		return ResponseEntity.ok().body(list); //.ok devolve uma resposta da serie 200 do http, o coorpo da resposta será a lista
	}

	@GetMapping(value = "/{id}") //no caminho vai ter uma / e um numero do id
	public ResponseEntity<Category> findById(@PathVariable Long id) { //retorna apenas uma categoria. 
		//a  notation @PathVariable recebe o numero do id na url
		//Category cat =  new Category(1L, "Eletronics");
		Category cat = categoryRespository.findById(id).get();
		return ResponseEntity.ok().body(cat); 
	}
}

