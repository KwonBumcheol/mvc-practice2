package org.example.mvc.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class JspView implements View{
    private final String name;

    public JspView(String name) {
        this.name = name;
    }

    @Override
    public void rander(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        model.forEach(request::setAttribute);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(name);
        requestDispatcher.forward(request, response);
    }
}
