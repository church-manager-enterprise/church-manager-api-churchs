package com.church.api.Church.api.usecase;

import com.church.api.Church.api.repository.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteChurchUseCase {

    @Autowired
    private ChurchRepository repository;

    public void execute(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Church not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
