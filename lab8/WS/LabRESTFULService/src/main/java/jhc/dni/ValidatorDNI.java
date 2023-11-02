package jhc.dni;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/validaciones")
public class ValidatorDNI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validaciondni/{dni}")
	public boolean validateNIF(@PathParam("dni") String dni) {
		
		Pattern mask =  Pattern.compile("[0-9]{1,8}[a-zA-Z]");
		
		Matcher matcher = mask.matcher(dni);
		if(!matcher.matches()){
			System.out.println("Incorrect NIF validation: " + dni + ". Not a valid format.");
		    return false;
		}
		
		String number = dni.substring(0, dni.length()-1);
		String controlDigit = dni.substring(dni.length()-1);
	
		String caracters = "TRWAGMYFPDXBNJZSQVHLCKE";
		int modulePosition = Integer.parseInt(number)%23;
		String controlDigitObtained = caracters.substring(modulePosition,modulePosition+1);
		
		if(!controlDigit.equalsIgnoreCase(controlDigitObtained)) {
		    /*  Not a valid NIF*/
			System.out.println("Incorrect NIF validation: " + dni + ". It was expected a : " + controlDigitObtained);
			return false;
		} else {
			System.out.println("Incorrect NIF validation: " + dni);
			return true;
		}
	}
}