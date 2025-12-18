package com.church.api.Church.api.usecase;

import com.church.api.Church.api.mapper.ChurchMapper;
import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.repository.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetChurchByIdUseCase {

    @Autowired
    private ChurchRepository repository;
    private ChurchMapper mapper;

    public ChurchDTO execute(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Church not found with ID: " + id));
    }
}
