package com.tiw.lab.springmongodb.financiera.repositorios;

import org.springframework.data.repository.CrudRepository;
import com.tiw.labspringmongodb.financiera.domains.AuthorizationTransacionPedido;

public interface AuthorizationTransacionPedidoRepository extends CrudRepository<AuthorizationTransacionPedido, String> {

}
