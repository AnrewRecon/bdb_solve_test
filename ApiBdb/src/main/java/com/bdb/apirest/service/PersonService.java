package com.bdb.apirest.service;

import com.bdb.apirest.dto.PersonDto;
import com.bdb.apirest.dto.ResponseBase;
import com.bdb.apirest.model.Person;
import com.bdb.apirest.repository.IPersonRepository;
import com.bdb.apirest.util.ModelHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    public List<PersonDto> finAll() {
        List<Person> persons = repository.findAll();
        List<PersonDto> personsDto = new ArrayList<PersonDto>();
        for (Person p : persons) {
            PersonDto pDto = new PersonDto();
            pDto.setDocumentId(p.getDocumentId());
            pDto.setFullname(p.getFullname());
            pDto.setBirth(p.getBirth());
            if (p.getFatherDocumentId() != null) {
                pDto.setFatherDocumentId(p.getFatherDocumentId().getDocumentId());
            }
            if (p.getMotherDocumentId() != null) {
                pDto.setMotherDocumentId(p.getMotherDocumentId().getDocumentId());
            }
            personsDto.add(pDto);
        }
        return personsDto;
    }

    @Override
    public PersonDto findById(long id) {
        Optional<Person> person = repository.findById(id);
        return ModelHelper.modelMapper().map(person.get(), PersonDto.class);
    }

    @Override
    public ResponseBase save(PersonDto personDto) {
        ResponseBase response = new ResponseBase();
        response.setState(false);
        try {
            if (repository.findById(personDto.getDocumentId()).isPresent()) {
                response.setMessage("There is already a user registered with this document");
                return response;
            }
            Person person = ModelHelper.modelMapper().map(personDto, Person.class);
            if (personDto.getFatherDocumentId() != null && personDto.getFatherDocumentId() > 0) {
                Optional<Person> father = repository.findById(personDto.getFatherDocumentId());
                if (father.isPresent()) {
                    person.setFatherDocumentId(father.get());
                } else {
                    response.setMessage("there is no father registered with this document");
                    return response;
                }
            }
            if (personDto.getMotherDocumentId() != null && personDto.getMotherDocumentId() > 0) {
                Optional<Person> mother = repository.findById(personDto.getMotherDocumentId());
                if (mother.isPresent()) {
                    person.setMotherDocumentId(mother.get());
                } else {
                    response.setMessage("there is no mother registered with this document");
                    return response;
                }
            }
            repository.save(person);
            response.setMessage("Persona registrada exitosamente");
            response.setState(true);
        } catch (Exception e) {
            response.setMessage("an error occurred while inserting");
        }
        return response;
    }
}
