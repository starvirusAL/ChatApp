package app.controller;

import app.custom.TableHeader;
import app.models.InputModdels;
import app.models.UserMassage;
import app.service.ChatService;
import app.service.MessageService;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MassageController {
    private final MessageService messageService;

    private final ChatService chatService;

    private final UserService userService;

    private Map<String, Object> data() {
        TableHeader th = new TableHeader("N", "Name", "massage");
        List<UserMassage> tb = messageService.findAll();
        return Map.of(
                "thead", th,
                "tbody", tb
        );
    }

    @PostMapping("sendMassage")
    public String sendMassage(InputModdels form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        List<UserMassage> tb = messageService.findAll();
        UserMassage massage = new UserMassage(
                userService.getUserById(form.getIdUser()),
                userService.getUserById(form.getIdUser()).getName(),
                form.getMassage(),
                chatService.getChatById(1));

        messageService.create(massage);

        return "redirect:chat";
    }

    @GetMapping("chat")
    public String showMassage(Model model) {
        data().forEach((k, v) -> model.addAttribute(k, v));
        return "chat";
    }
}
