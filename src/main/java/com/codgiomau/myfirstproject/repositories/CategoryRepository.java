package com.codgiomau.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codgiomau.myfirstproject.entities.Category;

//ao inves de usar class vamos usar uma interface para usar o repositoy do jpa
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	//vai utilizar os metodos prontos da interface
}

//classe utilizada para acessar as tabelas
//@Component //mecanismo de injecao de dependecia do spring
//******comentar tudo para usar o repository do jpa
//public class CategoryRepository {
//	//estamos craiando uma colecao provisoria na memoria, antes de mexer com bd
//	//map é uma estrura de dados que pode armazernar o par chave e valor.
//	//map em java é uma interface que precisa ser instanciada
//	private Map<Long, Category> map = new HashMap<Long, Category>();
//	
//	public void save(Category obj) {
//		map.put(obj.getId(), obj);
//	}
//
//	public Category findById(Long id) {
//		return map.get(id);
//	}
//	
//	public List<Category> findAll() {
//		return new ArrayList<Category>(map.values());
//	}
//}
