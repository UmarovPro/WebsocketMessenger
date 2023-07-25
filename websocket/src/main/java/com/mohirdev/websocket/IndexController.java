package com.mohirdev.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final TestComponent testComponent;

    public IndexController(TestComponent testComponent) {
        this.testComponent = testComponent;
    }

    @GetMapping
    public String index(Model model){
        return "index";
    }
    @GetMapping("/message")
    public String message(Model model){
        return "message";
    }
    @MessageMapping("/type")
    public void type(String message){
        testComponent.typing(message);
    }
    @MessageMapping("/keydown")
    public void keydown(String message){
        testComponent.keydown(message);
    }
}
