package com.codgiomau.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.codgiomau.myfirstproject.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

//classe utilizada para acessar as tabelas
//@Component //mecanismo de injecao de dependecia do sprong
//public class ProductRepository {
//	//estamos craiando uma colecao provisoria na memoria, antes de mexer com bd
//	//map é uma estrura de dados que pode armazernar o par chave e valor.
//	//map em java é uma interface que precisa ser instanciada
//	private Map<Long, Product> map = new HashMap<Long, Product>();
//	
//	public void save(Product obj) {
//		map.put(obj.getId(), obj);
//	}
//
//	public Product findById(Long id) {
//		return map.get(id);
//	}
//	
//	public List<Product> findAll() {
//		return new ArrayList<Product>(map.values());
//	}
//}
