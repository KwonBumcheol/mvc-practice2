package org.example.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{
    private final String forwordUriPath;

    public ForwardController(String forwordUriPath) {
        this.forwordUriPath = forwordUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwordUriPath;
    }
}
