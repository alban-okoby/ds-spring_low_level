package com.digitalsouag.salaire.service;

import com.digitalsouag.salaire.entity.Commercial;

import java.util.List;

public interface CommercialService {
    List<Commercial> findAllCommercial();
    Commercial findCommercialById(Long id);
    Commercial createCommercial(Commercial commercial);
    Commercial updateCommercial(Commercial commercial);
    void deleteCommercial(Long id);
}
