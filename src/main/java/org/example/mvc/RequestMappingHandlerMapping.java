package org.example.mvc;

import ch.qos.logback.core.joran.spi.HttpUtil;
import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping { // Handler Mapping
    // [key] /users [value] UserController
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController()); // 어떤 경로도 설정해주지 않으면 HomeController 실행
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
