package com.church.api.Church.api.usecase;

import com.church.api.Church.api.repository.ChurchRepository;
import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.mapper.ChurchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListChurchesUseCase {

    @Autowired
    private ChurchRepository repository;
    private ChurchMapper mapper;

    public List<ChurchDTO> execute() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}