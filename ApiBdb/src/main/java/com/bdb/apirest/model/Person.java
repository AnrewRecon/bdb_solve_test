package com.bdb.apirest.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "document_id")
    private Long documentId;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @ManyToOne
    private Person fatherDocumentId;    
    @ManyToOne
    private Person motherDocumentId;
}
