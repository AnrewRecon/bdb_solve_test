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
}
