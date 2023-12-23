package com.rays.ctl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidateCtl {
	
	public ResponseEntity<Map<String,String>> validate (BindingResult result){
		
		if(result.hasErrors()) {
			Map<String,String> map = new HashMap<String, String>();
			List<FieldError> fielsErrors = result.getFieldErrors();
			
			for(FieldError a:fielsErrors) {
				map.put(a.getField(), a.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		}
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("Success", "True");
		return (ResponseEntity<Map<String,String>>) ResponseEntity.ok(map);
		
	}

}
