package com.bdb.apirest.controller;

import com.bdb.apirest.dto.PersonDto;
import com.bdb.apirest.dto.ResponseBase;
import com.bdb.apirest.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private IPersonService service;
        
    @GetMapping(value="",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll(){        
        return ResponseEntity.ok(this.service.finAll());
    }
    
    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable("id") long id){        
        return ResponseEntity.ok(this.service.findById(id));
    }
    
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody PersonDto personDto){ 
        return ResponseEntity.ok(this.service.save(personDto));
    }
}
