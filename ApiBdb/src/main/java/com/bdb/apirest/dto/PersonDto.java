package com.bdb.apirest.dto;

import java.util.Date;
import lombok.Data;

@Data
public class PersonDto {
    private Long documentId;
    private String fullname;
    private Date birth;
    private Long fatherDocumentId;
    private Long motherDocumentId;

    public PersonDto() {
    }

    public PersonDto(Long documentId, String fullname, Date birth, Long fatherDocumentId, Long motherDocumentId) {
        this.documentId = documentId;
        this.fullname = fullname;
        this.birth = birth;
        this.fatherDocumentId = fatherDocumentId;
        this.motherDocumentId = motherDocumentId;
    } 
    
}
