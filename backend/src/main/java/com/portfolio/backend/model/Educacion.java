
package com.portfolio.backend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name ="educacion")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id_edu")
    private Long idEdu;
    
    private String titulo;
    private String institucion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    
    private String logoimg;

    public Educacion() {
    }

    public Educacion(String titulo, String institucion, Date inicio, Date fin, String logoimg) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.logoimg = logoimg;
    }   
}
