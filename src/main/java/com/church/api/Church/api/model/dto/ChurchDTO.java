package com.church.api.Church.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChurchDTO {
     private String id;
     private String name;
     private String denomination;
     private String address;
     private String phone;
     private String email;
}
