package com.church.api.Church.api.controller;

import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.model.request.ChurchRequest;
import com.church.api.Church.api.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
public class ChurchController {

    private final CreateChurchUseCase createUseCase;
    private final ListChurchesUseCase listUseCase;
    private final GetChurchByIdUseCase getByIdUseCase;
    private final UpdateChurchUseCase updateUseCase;
    private final DeleteChurchUseCase deleteUseCase;

    @PostMapping
    public ResponseEntity<ChurchDTO> create(@RequestBody ChurchRequest request) {
        ChurchDTO response = createUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChurchDTO>> listAll() {
        List<ChurchDTO> list = listUseCase.execute();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChurchDTO> getById(@PathVariable String id) {
        ChurchDTO response = getByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChurchDTO> update(@PathVariable String id, @RequestBody ChurchRequest request) {
        ChurchDTO response = updateUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}