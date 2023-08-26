package app.controller;

import app.models.Chats;
import app.models.InputModdels;
import app.models.UserMassage;
import app.service.ChatService;
import app.service.MessageService;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ChatController {

    private final ChatService service;

    private final MessageService messageService;

    private final UserService userService;

    @PostMapping("createChat")
    public String sendMassage(Model model, InputModdels form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();

        service.create(new Chats(userService.getUserById(1),  userService.getUserById(2)));

        return "redirect:chat";
    }
}
