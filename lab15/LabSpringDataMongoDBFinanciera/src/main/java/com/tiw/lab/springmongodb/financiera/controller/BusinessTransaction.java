package com.tiw.lab.springmongodb.financiera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiw.lab.springmongodb.financiera.businness.CodigosValesPedidoOperacion;
import com.tiw.lab.springmongodb.financiera.businness.ValidacionTarjeta;
import com.tiw.lab.springmongodb.financiera.repositorios.AuthorizationCobroPedidoRepository;
import com.tiw.lab.springmongodb.financiera.repositorios.AuthorizationTransacionPedidoRepository;
import com.tiw.lab.springmongodb.financiera.repositorios.TransaccionConciliacionRepository;
import com.tiw.labspringmongodb.financiera.domains.AuthorizationCobroPedido;
import com.tiw.labspringmongodb.financiera.domains.AuthorizationTransacionPedido;
import com.tiw.labspringmongodb.financiera.domains.TransaccionConciliacion;


@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/home")
public class BusinessTransaction {

	@Autowired
	AuthorizationCobroPedidoRepository pedidoRepository;

	@Autowired
	TransaccionConciliacionRepository transaccionConciliacionRepository;

	@Autowired
	AuthorizationTransacionPedidoRepository authorizationTransacionPedidoRepository;

	@PostMapping(value = "/transaccion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getAuthorization(@RequestBody AuthorizationCobroPedido authorization) {

		ValidacionTarjeta _validacionTarjeta = new ValidacionTarjeta();
		
		System.out.println(_validacionTarjeta.validarTarjeta(authorization.getFechaTarjeta(), authorization.getCv2(),
				authorization.getNumeroTarjeta()));

		if (_validacionTarjeta.validarTarjeta(authorization.getFechaTarjeta(), authorization.getCv2(),
				authorization.getNumeroTarjeta())) {

			// La tarjeta es valida. Vamos a guardar el pedido y la transaccion en sus respectivos repositorios
			pedidoRepository.save(authorization);

			CodigosValesPedidoOperacion _codTransacion = new CodigosValesPedidoOperacion();

			String _codigoGeneradoDeTransaccion = _codTransacion.generacionCodigoTransaccion(
					authorization.getFechaTarjeta(), authorization.getCv2(), authorization.getNumeroTarjeta());

			AuthorizationTransacionPedido _authorizationTransacionPedido = new AuthorizationTransacionPedido(
					_codigoGeneradoDeTransaccion, authorization.getCodPedido(), authorization.getCoste(),
					authorization.getFechaTarjeta(), authorization.getCv2(), authorization.getNumeroTarjeta());

			TransaccionConciliacion _transaccionConciliacion = new TransaccionConciliacion(_codigoGeneradoDeTransaccion,
					String.valueOf(authorization.getCoste()), authorization.getFechaTarjeta());

			transaccionConciliacionRepository.save(_transaccionConciliacion);

			// Si quermos guardar _authorizationTransacionPedido en la coleccion de financiera
			authorizationTransacionPedidoRepository.save(_authorizationTransacionPedido);

			return new ResponseEntity<>(_authorizationTransacionPedido, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getPedidos() {

		try {
			Iterable<AuthorizationCobroPedido> entityList = pedidoRepository.findAll();

			return new ResponseEntity<>(entityList, HttpStatus.OK);

		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/pedido/{tarjeta}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getPedidoTarjeta(@PathVariable(value = "tarjeta", required = true) Long tarjeta) {

		try {
			
			List<AuthorizationCobroPedido> entityList = pedidoRepository.findByNumeroTarjeta(tarjeta);

			return new ResponseEntity<>(entityList, HttpStatus.OK);

		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
