package app.controller;

import app.models.InputModdels;
import app.models.User;
import app.models.UserMassage;
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
public class UserController {

    private final UserService service;

    @PostMapping("registration")
    public String registration(Model model, InputModdels form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
            User user = new User(form.getName() ,form.getUsername(), form.getPassword());
            service.create(user);
        return "redirect:chat";
    }

    @GetMapping("registration")
    public String showMassage(Model model) {
        return "registration";
    }
}
