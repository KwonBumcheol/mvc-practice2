package org.example.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mvc.controller.Controller;
import org.example.mvc.view.ModelAndView;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 5
        String viewName = ((Controller) handler).handleRequest(request, response);
        return new ModelAndView(viewName);
    }
}
