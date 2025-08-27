package org.example.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

public class UserCreateController implements Controller{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // user 추가
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }
}
