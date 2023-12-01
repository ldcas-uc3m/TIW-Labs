package com.tiw.lab.springmongodb.financiera.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tiw.labspringmongodb.financiera.domains.TransaccionConciliacion;

public interface TransaccionConciliacionRepository extends CrudRepository<TransaccionConciliacion, String> {

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

	List<TransaccionConciliacion> findAll();

}