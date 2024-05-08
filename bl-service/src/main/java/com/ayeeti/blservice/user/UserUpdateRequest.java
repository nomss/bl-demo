package com.ayeeti.blservice.user;

public record UserUpdateRequest(Long userId, String newUserName) {
}
