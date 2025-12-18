package com.church.api.Church.api.repository;

import com.church.api.Church.api.model.entities.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, String> {
}
