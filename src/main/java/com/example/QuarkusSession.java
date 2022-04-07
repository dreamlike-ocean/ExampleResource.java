package com.example;

import java.util.HashMap;
import java.util.Map;

public class QuarkusSession {
    private String sessionId;
    private Map<String,Object> attributes = new HashMap<>();

    public QuarkusSession(String sessionId) {
        this.sessionId = sessionId;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public String getSessionId() {
        return sessionId;
    }
}
