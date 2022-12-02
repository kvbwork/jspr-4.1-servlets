package ru.netology.config;

import org.springframework.stereotype.Component;
import ru.netology.controller.PostController;
import ru.netology.exception.NotFoundException;
import ru.netology.servlet.HandlerMapping;

@Component
public class PostRoutesConfigurer extends AbstractRoutesConfigurer{

    public PostRoutesConfigurer(HandlerMapping handlerMapping, PostController postController) {
        handlerMapping.addStaticPathHandler(GET, "/api/posts", (req, resp) -> {
            postController.all(resp);
        });
        handlerMapping.addPatternPathHandler(GET, "/api/posts/\\d+", (req, resp) -> {
            postController.getById(
                    getIdPathParam(req.getServletPath()).orElseThrow(NotFoundException::new), resp);
        });
        handlerMapping.addStaticPathHandler(POST, "/api/posts", (req, resp) -> {
            postController.save(req.getReader(), resp);
        });
        handlerMapping.addPatternPathHandler(DELETE, "/api/posts/\\d+", (req, resp) -> {
            postController.removeById(
                    getIdPathParam(req.getServletPath()).orElseThrow(NotFoundException::new), resp);
        });
    }

}
