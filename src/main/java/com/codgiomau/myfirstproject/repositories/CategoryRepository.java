package com.codgiomau.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.codgiomau.myfirstproject.entities.Category;

//classe utilizada para acessar as tabelas
@Component //mecanismo de injecao de dependecia do sprong
public class CategoryRepository {
	//estamos craiando uma colecao provisoria na memoria, antes de mexer com bd
	//map é uma estrura de dados que pode armazernar o par chave e valor.
	//map em java é uma interface que precisa ser instanciada
	private Map<Long, Category> map = new HashMap<Long, Category>();
	
	public void save(Category obj) {
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		return new ArrayList<Category>(map.values());
	}
}
