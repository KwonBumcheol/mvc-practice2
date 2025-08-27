package org.example.mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mvc.controller.Controller;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/") // 어떤 경로를 적어도 호출되게끔
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping rmhm;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started.");

        try {
            Controller handler = rmhm.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI())); // 어떤 uri가 들어왔는데 처리할 수 있는 handler를 반환
            // "redirect" vs forward
            String viewName = handler.handleRequest(request, response);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(viewName);
                view.rander(new HashMap<>(), request, response);
            }
        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
