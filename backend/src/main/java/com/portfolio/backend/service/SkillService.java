
package com.portfolio.backend.service;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillService{
    private final SkillRepository skillRepo;
    
    @Autowired
    public SkillService(SkillRepository skillRepo) {
        this.skillRepo = skillRepo;
    }
    
    public List<Skill> verSkills() {
        List<Skill> listaSkills = skillRepo.findAll();
        return listaSkills;
    }

    public Skill crearSkill(Skill sk) {
        return skillRepo.save(sk);
    }
    
    public Skill editarSkill(Skill sk){
        return skillRepo.save(sk);
    }
    
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    public Skill buscarSkill(Long id) {
        Skill sk = skillRepo.findById(id).orElse(null);
        return sk;
    }
    
}
