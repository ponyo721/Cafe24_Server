package com.cafe24.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {
    final static Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String enter() {
        logger.info("call enter getMapping");

        return "enter";
    }

    @GetMapping("/home")
    public String home() {
        logger.info("call home getMapping");

        return "home";
    }

    @GetMapping("index")
    public String index() {
        logger.info("call Index getMapping");

        return "index";
    }

    @GetMapping("info")
    public String info() {
        logger.info("call info getMapping");

        return "info";
    }

    @GetMapping("/test")
    public String test() {
        logger.info("call test getMapping");

        return "test";
    }
}
