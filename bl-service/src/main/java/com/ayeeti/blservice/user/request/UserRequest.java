package com.ayeeti.blservice.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRequest {
    private Long id;
    private String username;
    private String password;
}