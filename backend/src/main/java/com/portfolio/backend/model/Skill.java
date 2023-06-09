
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    
    private String nombreskill;
    
    @Min(0)
    @Max(100)
    private int porcentaje;

    public Skill() {
    }

    public Skill(String nombreskill, int porcentaje) {
        this.nombreskill = nombreskill;
        this.porcentaje = porcentaje;
    }
    
    
}
