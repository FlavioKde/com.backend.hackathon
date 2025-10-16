package com.hackathon.demo.auth.dto;

public class AuthResponse {
    private String token;
    private String message;
    private boolean success;

    // Constructor para éxito (solo token)
    public AuthResponse(String token) {
        this.token = token;
        this.message = "Success";
        this.success = true;
    }

    // Constructor para error (solo mensaje)
    public AuthResponse(String message, boolean isError) {
        this.message = message;
        this.token = null;
        this.success = false;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}