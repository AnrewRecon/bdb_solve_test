package com.bdb.apirest.repository;

import com.bdb.apirest.model.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long>{
    @Override
    List<Person> findAll();
}
