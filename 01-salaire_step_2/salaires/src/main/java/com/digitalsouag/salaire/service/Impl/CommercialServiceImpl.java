package com.digitalsouag.salaire.service.Impl;

import com.digitalsouag.salaire.entity.Commercial;
import com.digitalsouag.salaire.repository.CommercialRepository;
import com.digitalsouag.salaire.service.CommercialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommercialServiceImpl implements CommercialService {

    private final CommercialRepository commercialRepository;

    public CommercialServiceImpl(CommercialRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    @Override
    public List<Commercial> findAllCommercial() {
        return commercialRepository.findAll();
    }

    @Override
    public Commercial findCommercialById(Long id) {
        Optional<Commercial> findedCommercial = commercialRepository.findById(id);
        if (findedCommercial.isPresent()) {
            return findedCommercial.get();
        }
        return null;
    }

    @Override
    public Commercial createCommercial(Commercial commercial) {
        if (!commercial.equals("") || commercial != null) {
            Commercial newCommercial = new Commercial();
                newCommercial.setNom(commercial.getNom());
                newCommercial.setPrenom(commercial.getPrenom());
                newCommercial.setAge(commercial.getAge());
                newCommercial.setDeteEntree(commercial.getDeteEntree());
                newCommercial.setChiffreAffaire(commercial.getChiffreAffaire());
            return commercialRepository.save(newCommercial);
        }
        return null;
    }

    @Override
    public Commercial updateCommercial(Commercial commercial) {
        Optional<Commercial> findedCommercial = commercialRepository.findById(commercial.getId());
        if (findedCommercial.isPresent()) {
            return commercialRepository.saveAndFlush(commercial);
        }
        return null;
    }

    @Override
    public void deleteCommercial(Long id) {
        Optional<Commercial> findedCommercial = commercialRepository.findById(id);
        if (findedCommercial.isPresent()) {
            commercialRepository.deleteById(id);
        }
    }
}
