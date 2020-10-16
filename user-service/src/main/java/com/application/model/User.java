package com.application.model;

import lombok.Data;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Data
@ToString
@AllArgsConstructor
public class User {
    private String userId;
    private String password;

}
