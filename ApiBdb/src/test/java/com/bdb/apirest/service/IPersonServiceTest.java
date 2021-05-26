package com.bdb.apirest.service;

import com.bdb.apirest.dto.PersonDto;
import com.bdb.apirest.dto.ResponseBase;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class IPersonServiceTest {
    
    @Autowired
    private IPersonService service;
    
    /**
     * Test of finAll method, of class IPersonService.
     */
    @Test
    public void testFinAll() {
        System.out.println("finAll");
        List<PersonDto> expResult = null;
        List<PersonDto> result = service.finAll();
        assertTrue(result != null && result.size() > 0);
    }

    /**
     * Test of findById method, of class IPersonService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long id = 1012408591;
        PersonDto expResult = new PersonDto(id, "Andres Rincon", new Date("1994-03-12"), 76545663L, 51939912L);
        PersonDto result = service.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class IPersonService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        PersonDto personDto = new PersonDto(654654L, "Juan Rincon", new Date("1994-03-12"), 76545663L, 51939912L);
        ResponseBase expResult = new ResponseBase(true, "Persona registrada exitosamente", null);
        ResponseBase result = service.save(personDto);
        assertEquals(expResult, result);
    }    
}
