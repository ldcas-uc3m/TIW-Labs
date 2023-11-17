package es.tiw.disco;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



// La interfaz debe extender de CrudRepository y tiene que tener como tipificado: Tipo de la entidad y Tipo de la clave primaria
// CrudRespository ya propociona algunso métodos como count(), save(...), delete(...) 
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
public interface DiscoRepository extends CrudRepository<Disco,Long> {
	
	
	// Esta cabecera de método permite buscar los discos por Anyo 
	public List<Disco> findByAnyo(int anyo);
	
	// Otros ejemplos
	public List<Disco> findByAnyoAndNombre(int anyo, String nombre);
	public Disco findByNombre(String nombre);
	
	
}
