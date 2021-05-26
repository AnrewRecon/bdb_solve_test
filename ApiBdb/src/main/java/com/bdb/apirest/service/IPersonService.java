package com.bdb.apirest.service;

import com.bdb.apirest.dto.PersonDto;
import com.bdb.apirest.dto.ResponseBase;
import java.util.List;

public interface IPersonService {
    List<PersonDto> finAll();
    
    PersonDto findById(long id);
    
    ResponseBase save(PersonDto personDto);
}
