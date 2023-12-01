package com.tiw.lab.springmongodb.financiera.repositorios;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.tiw.labspringmongodb.financiera.domains.AuthorizationCobroPedido;

public interface AuthorizationCobroPedidoRepository extends CrudRepository<AuthorizationCobroPedido, String> {
	
	List<AuthorizationCobroPedido> findAll();
	
	List<AuthorizationCobroPedido> findByNumeroTarjeta(Long tarjeta);

}
