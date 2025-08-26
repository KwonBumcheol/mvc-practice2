package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {
    // [key] /users [value] UserController
    private Map<String, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put("/", new HomeController()); // 어떤 경로도 설정해주지 않으면 HomeController 실행
    }

    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }
}
