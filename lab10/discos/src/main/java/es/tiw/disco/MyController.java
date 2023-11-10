package es.tiw.disco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


// Indica que será un controller que devolverá objetos por REST (REpresentional State Trasnfer).
@RestController
public class MyController {

	// Esta anotación permite la inyección del CrudRepository creado para la tabla discos
	@Autowired
	DiscoRepository discoRepository;
	
	
	// @RequestMapping: Configura la llamada al método por http
	//           value ó path: indica la uri con la que responderá el método
	//           methods: Indica el conjutno de métodos (GET, POST, PUT...) con los que se puede llamar al método
	//           produces: Indica el formato con el que se devolverá el cuerpo de la respuesta: XML, JSON...
	// @PathVariable: Hace referencia a qué parte del path de la uri será pasada como parámetro
	// @RequestParam: Permite configurar la obtención de parámetros (puede indicarse que el parámetro es obligatorio o no)
	// @RequestBody: Indica el timpo de objeto que se obtendrá en el cuerpo de la solicitud
	// @ResponseBody: No es necesario al utilizar la anotación @RestController en vez de @Controller en la clase (Arriba se puede ver).
	// De cualquier manera indica que lo que se retorna estará en el cuerpo de la respuesta
	@RequestMapping(path= {"/discos/{numero}"},produces= {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},method=RequestMethod.POST)
	public  Disco hello(@PathVariable int numero,@RequestParam(value="anyo",required=true) int anyo, @RequestBody Disco d) {
		return new Disco(numero,d.getNombre(),"interprete",anyo);
	}
	
	
	@RequestMapping(value="/discos",method=RequestMethod.GET)
	public ResponseEntity<List<Disco>> todos(@RequestParam("anyo") int anyo){
		ResponseEntity<List<Disco>> r = new ResponseEntity<List<Disco>>(discoRepository.findByAnyo(anyo),HttpStatus.NOT_FOUND);
		return r;
	}
	
	
}
