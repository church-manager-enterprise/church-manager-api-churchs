package com.church.api.Church.api.usecase;

import com.church.api.Church.api.mapper.ChurchMapper;
import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.model.entities.Church;
import com.church.api.Church.api.model.request.ChurchRequest;
import com.church.api.Church.api.repository.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateChurchUseCase {

    @Autowired
    private ChurchRepository repository;
    
    @Autowired
    private ChurchMapper mapper;

    public ChurchDTO execute(ChurchRequest request){

        Church church = mapper.toEntity(request);
        Church savedChurch = repository.save(church);
        return mapper.toDTO(savedChurch);

    }
}
