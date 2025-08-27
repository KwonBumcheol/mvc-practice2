package org.example.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class RedirectView implements View{
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String name;

    public RedirectView(String name) {
        this.name = name;
    }

    @Override
    public void rander(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
