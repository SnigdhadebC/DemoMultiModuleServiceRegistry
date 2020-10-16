package com.application.model;

import lombok.Data;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String password;

}
