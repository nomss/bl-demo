package com.ayeeti.blservice.user.requests;

public record UpdateUserRequest(Long userId, String newUserName) {
}
