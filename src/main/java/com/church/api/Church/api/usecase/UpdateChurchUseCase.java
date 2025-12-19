package com.church.api.Church.api.usecase;

import com.church.api.Church.api.mapper.ChurchMapper;
import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.model.entities.Church;
import com.church.api.Church.api.model.request.ChurchRequest;
import com.church.api.Church.api.repository.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateChurchUseCase {

    @Autowired
    private ChurchRepository repository;
    
    @Autowired
    private ChurchMapper mapper;

    public ChurchDTO execute(String id, ChurchRequest request) {
        Church existingChurch = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Church not found with ID: " + id));

        mapper.updateEntityFromRequest(request, existingChurch);

        Church updatedChurch = repository.save(existingChurch);

        return mapper.toDTO(updatedChurch);
    }
}
