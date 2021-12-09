package com.example.userPoll.model;

public enum Permission {
    USER("user:write"),
    ADMIN("user:moderate");

    String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
