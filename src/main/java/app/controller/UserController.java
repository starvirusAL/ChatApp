package app.controller;

import app.custom.TableHeader;
import app.models.InputModdels;
import app.models.UserMassage;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    private Map<String, Object> data() {
        TableHeader th = new TableHeader("N", "Name", "massage");
        List<UserMassage> tb = service.findAll();
        return Map.of(
                "thead", th,
                "tbody", tb
        );
    }
    @GetMapping("sendMassage")
    public String sendMassage() {
        return "sendMassage";
    }
    @PostMapping("sendMassage")

    public String sendMassage(Model model, InputModdels form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        List<UserMassage> tb = service.findAll();
        UserMassage user = new UserMassage("Alex", form.getMassage());
        service.create(user);
        return "redirect:chat";
    }



    @GetMapping("chat")
    public String showMassage(Model model) {
    data().forEach((k, v) -> model.addAttribute(k, v));
        return "chat";
    }
}
