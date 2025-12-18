package com.church.api.Church.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChurchRequest {
    private String name;
    private String denomination;
    private String address;
    private String phone;
    private String email;

}
