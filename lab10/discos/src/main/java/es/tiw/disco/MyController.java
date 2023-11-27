package es.tiw.disco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Indica que será un controller que devolverá objetos por REST (REpresentional State Trasnfer).
@RestController
public class MyController {

	// Esta anotación permite la inyección del CrudRepository creado para la tabla
	// discos
	@Autowired
	DiscoRepository _discoRepository;

	/*
	 * @RequestMapping: Configura la llamada al método por http value ó path: indica
	 * la uri con la que responderá el método methods: Indica el conjutno de métodos
	 * (GET, POST, PUT...) con los que se puede llamar al método produces: Indica el
	 * formato con el que se devolverá el cuerpo de la respuesta: XML, JSON...
	 * 
	 * @PathVariable: Hace referencia a qué parte del path de la uri será pasada
	 * como parámetro
	 * 
	 * @RequestParam: Permite configurar la obtención de parámetros (puede indicarse
	 * que el parámetro es obligatorio o no)
	 * 
	 * @RequestBody: Indica el timpo de objeto que se obtendrá en el cuerpo de la
	 * solicitud
	 * 
	 * @ResponseBody: No es necesario al utilizar la anotación @RestController en
	 * vez de @Controller en la clase (Arriba se puede ver). De cualquier manera
	 * indica que lo que se retorna estará en el cuerpo de la respuesta
	 */

	@PostMapping(path = { "/discos" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(@RequestBody Disco d) {
		long id = d.getId();

		// Verificar si ya existe un disco con la misma ID
		if (_discoRepository.existsById(id)) {
			return new ResponseEntity<>("Error: Ya existe un disco con la misma ID.", HttpStatus.BAD_REQUEST);
		}

		try {
			// Intentar guardar el disco
			Disco discoGuardado = _discoRepository.save(d);
			return new ResponseEntity<>(discoGuardado, HttpStatus.CREATED);
		} catch (Exception e) {
			// Captura cualquier otra excepción
			return new ResponseEntity<>("Error al guardar el disco: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/discos/{id}")
	public ResponseEntity<?> actualizarDisco(@PathVariable long id, @RequestBody Disco discoActualizado) {

		// Verificar si el disco con la ID proporcionada existe
		Optional<Disco> discoExistente = _discoRepository.findById(id);
		if (!discoExistente.isPresent()) {
			return new ResponseEntity<>("Error: No se encontró un disco con la ID proporcionada.", HttpStatus.NOT_FOUND);
		}

		// Actualizar los datos del disco existente con los datos proporcionados
		Disco discoAActualizar = discoExistente.get();
		discoAActualizar.setNombre(discoActualizado.getNombre());
		discoAActualizar.setInterprete(discoActualizado.getInterprete());
		discoAActualizar.setAnyo(discoActualizado.getAnyo());

		// Guardar el disco actualizado
		try {
			Disco discoGuardado = _discoRepository.save(discoAActualizar);
			return new ResponseEntity<>(discoGuardado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error al actualizar el disco: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/discos")
	public ResponseEntity<List<Disco>> obtenerDiscos(@RequestParam(name = "anyo", required = false) Integer anyo) {

		List<Disco> discos;

		if (anyo != null) {
			discos = _discoRepository.findByAnyo(anyo);
		} else {
			Iterable<Disco> discosIterable = _discoRepository.findAll();
			discos = new ArrayList<>();
			discosIterable.forEach(discos::add);
		}

		if (!discos.isEmpty()) {
			return new ResponseEntity<>(discos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/discos/{id}")
	public ResponseEntity<?> borrarDisco(@PathVariable long id) {
	    try {
	        // Intentar borrar el disco por ID
	        _discoRepository.deleteById(id);
	        return new ResponseEntity<>("Disco eliminado exitosamente.", HttpStatus.OK);
	    } catch (EmptyResultDataAccessException e) {
	        // Manejar la excepción si no se encuentra el disco
	        return new ResponseEntity<>(
	            generarError("NOT_FOUND", "No se encontró un disco con la ID proporcionada."),
	            HttpStatus.NOT_FOUND
	        );
	    } catch (Exception e) {
	        // Manejar otras excepciones
	        return new ResponseEntity<>(
	            generarError("INTERNAL_SERVER_ERROR", "Se produjo un error interno del servidor."),
	            HttpStatus.INTERNAL_SERVER_ERROR
	        );
	    }
	}


	private Map<String, String> generarError(String code, String message) {
		Map<String, String> error = new HashMap<>();
		error.put("code", code);
		error.put("message", message);
		return error;
	}

}
