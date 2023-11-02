package jhc.students;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
//http://www.webtutoriales.com/articulos/servicios-rest-con-java-usando-jax-rs-y-jersey#
@Path("/students")
public class StudentService {
	
	@GET
	@Produces("application/json")
	@Path("/lista")
	public Response getStudent() throws JSONException {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Marcos Asensio", "nia1234567","Informatico"));
		students.add(new Student("Isco Alarcon", "nia1234568", "Torero"));
		students.add(new Student("Felipe Reyes", "nia1234569","Futbolista"));
		students.add(new Student("Luka Doncic", "nia1234577", "Base"));
		students.add(new Student("Juan Gomez Juanito", "nia1234667","Genio"));

		return Response.status(200).entity(students.toString()).build();
	}
}