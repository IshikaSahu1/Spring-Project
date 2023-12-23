package com.rays.ctl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rays.dto.UserDTO;
import com.rays.forms.LoginForm;
import com.rays.forms.UserForm;
import com.rays.forms.UserRegistrationForm;
import com.rays.service.UserServiceImp;

@RestController
@RequestMapping(value = "Auth")

public class UserCtl extends ValidateCtl {

	@Autowired
	UserServiceImp user;

	@PostMapping(value = "signUp")
	public ResponseEntity<Map<String, String>> signUp(@Valid @RequestBody UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			ResponseEntity<Map<String, String>> validate = validate(result);
			return validate;
		}

		System.out.println("Lastname:" + form.getLastname());

		UserDTO dto = new UserDTO();
		dto.setFirstname(form.getFirstname());
		dto.setLastname(form.getLastname());
		dto.setEmail(form.getLoginId());
		dto.setPassword(form.getPasword());
		dto.setPhone(form.getPhone());

		long add = this.user.add(dto);
		System.out.println("Data added");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("okk", "Created");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	}

	@GetMapping("/search/{userId}")
	public ResponseEntity<UserDTO> findByPK(@PathVariable int userId) {
		UserDTO dto = this.user.findById(userId);

		if (dto == null) {
			return new ResponseEntity("Dto is null", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "search")
	public ResponseEntity searching() {
		List list = this.user.search();
		return ResponseEntity.ok(list);
	}

	/*
	 * @PostMapping("update") public ResponseEntity<String>
	 * update(@Valid @RequestBody UserForm form, @PathVariable int userId){
	 * 
	 * UserDTO user = this.user.findById(userId);
	 * 
	 * if(user!=null) { user.setFirstname(form.getFirstname());
	 * user.setLastname(form.getLastname()); user.setEmail(form.getLoginId());
	 * user.setPassword(form.getPasword()); user.setPhone(form.getPhone());
	 * this.user.update(user); return new
	 * ResponseEntity<String>("User updated successs" ,HttpStatus.OK); }else { user
	 * = new UserDTO(); user.setFirstname(form.getFirstname());
	 * user.setLastname(form.getLastname()); user.setEmail(form.getLoginId());
	 * user.setPassword(form.getPasword()); user.setPhone(form.getPhone());
	 * this.user.add(user);
	 * 
	 * return new ResponseEntity<String>("User updated" , HttpStatus.CREATED); } }
	 */

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {

		UserDTO user = this.user.findById(id);

		if (user != null) {
			this.user.delete(user);
			return new ResponseEntity<String>("Record deleted", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/login")
	public ResponseEntity<UserDTO> findByLogin(@RequestParam(value = "login") String login) {

		UserDTO dto = this.user.findByLoginId(login);

		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);

	}

//		@PostMapping("/signin")
//		public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginForm loginForm,
//				BindingResult bindingResult){
//			
//			if(bindingResult.hasErrors()) {
//				ResponseEntity<Map<String, String>> validate = validate(bindingResult);
//				return validate;
//			}
//			
//			UserDTO dto = this.user.authenticate(loginForm.getLoginId(), loginForm.getPassword());
//			
//			Map<String, String> map = new HashMap<String, String>();
//			
//			map.put("email", dto.getEmail());
//			map.put("password", dto.getPassword());
//			
//			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);	     
//		}
//		
	@PostMapping(value = "add")
	public ResponseEntity<Map<String, String>> add(@RequestBody @Valid UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			ResponseEntity<Map<String, String>> validate = validate(result);
			return validate;
		}

		UserDTO dto = new UserDTO();
		dto.setFirstname(form.getFirstname());
		dto.setLastname(form.getLastname());
		dto.setEmail(form.getLoginId());
		dto.setPassword(form.getPasword());
		dto.setPhone(form.getPhone());

		long add = this.user.add(dto);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Ok", "Done");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);

	}

}
