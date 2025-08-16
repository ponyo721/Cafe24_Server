package com.cafe24.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {
    final static Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("index")
    public String index() {
        logger.info("call Index getMapping");

        return "index";
    }
}
