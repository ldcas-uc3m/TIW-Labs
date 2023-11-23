package es.uc3m.tiw.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import es.uc3m.tiw.domains.*;
import es.uc3m.tiw.repositorys.AddressDAO;
import es.uc3m.tiw.repositorys.UserDAO;

@Controller
@CrossOrigin
public class MyController {

	@Autowired
	UserDAO daous;
	
	@Autowired
	AddressDAO daoaddress;

	/****************** OPERATIONS ON USERS ******************************************/
	

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> getUsers(@RequestParam(value="name",required=false) String name){
		List<User> userList;
		if (name == null) {
			userList = daous.findAll();
		} else {
			userList = daous.findByName(name);
		}
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	
	// Get users by name - with the parameter in the path
	@RequestMapping(value="/users/{name}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<User> getUserByName(@PathVariable String name){
		//return daous.findByName(name);
		 User us = daous.findTop1ByName(name);
		 return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
	// Get users by name and surname - with the parameters in the path
	@RequestMapping(value="/users/{name}/{surname}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> getUserByNameAndSurname(@PathVariable String name,
											  @PathVariable String surname){
		return new ResponseEntity<>(daous.findByNameAndSurname(name, surname), HttpStatus.OK);
	}
	
	// Save a user
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User puser){
		
		ResponseEntity<User> response;
		User newUser = daous.save(puser);
		if (newUser == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userbis")
	public @ResponseBody User saveUser2(@RequestBody @Validated User puser){
		return daous.save(puser);
	}
	
	// Update a user
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<User> updateUser(@PathVariable @Validated Long id, @RequestBody User pUser) {
		ResponseEntity<User> response;
		//Optional<User> us = daous.findById(id);
		User us = daous.findById(id).orElse(null);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			us.setName(pUser.getName());
			us.setSurname(pUser.getSurname());				
			response = new ResponseEntity<>(daous.save(us), HttpStatus.OK);
		}
		return response;
	}
	
	// Delete a user
	@DeleteMapping("/users/{id}")
	public @ResponseBody ResponseEntity<User> deleteUser(@PathVariable @Validated Long id) {
		ResponseEntity<User> response;
		User us = daous.findById(id).orElse(null);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			daous.delete(us);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	
	}	
	
	@GetMapping(value="/user/{name}")
	public @ResponseBody User get1UserByName(@PathVariable String name) {
		return daous.findTop1ByName(name);
	}
	
	/****************** OPERATIONS ON ADDRESSES ******************************************/
	
	@RequestMapping(value="/addresses", method=RequestMethod.GET)
	public @ResponseBody List<Address> getAddresses() {
		return daoaddress.findAll();
	}
	
	
	@RequestMapping(value="/addresses/{streetName}", method=RequestMethod.GET)
	public @ResponseBody List<Address> getAdressByStreet(@PathVariable String streetName){
		return daoaddress.findByStreet(streetName);
	}

	
	@RequestMapping(value="/addresses", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Address> saveAddress(@RequestBody Address pAddress) {
		ResponseEntity<Address> response;
		
		Address ad = daoaddress.save(pAddress);
		if (ad == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(ad, HttpStatus.CREATED);
		}
		return response;
	}

	
	@RequestMapping(value="/addresses/{id}", method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address pad ){
		
		Address add = daoaddress.findById(id).orElse(null);
		if (add == null) {
			add = daoaddress.save(pad);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} else {
			add.setPostCode(pad.getPostCode());
			add.setStreet(pad.getStreet());
			add.setUser(pad.getUser());
			add= daoaddress.save(add);
			return new ResponseEntity<>(add, HttpStatus.OK);
		}
	
	}
	
	// Delete a user
	@RequestMapping(value="/addresses/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Address> deleteAddress(@PathVariable @Validated Long id) {
		//ResponseEntity<Address> response;
		Address add = daoaddress.findById(id).orElse(null);
		if (add == null) {
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} else {
			daoaddress.delete(add);
			return new ResponseEntity<>( HttpStatus.OK);
		}	
	}	
	
}
	

