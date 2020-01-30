package com.example.p7apiweb.security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="projet7@ocr";
    public static final long EXPIRATION=4*3600;//4h
    public static final String HEADER_PREFIX="Bearer ";
}
