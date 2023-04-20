package anna.kata.sp_boot.controller;

import anna.kata.sp_boot.model.User;
import anna.kata.sp_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OneController {

    private UserService userService;

    @Autowired
    public OneController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")//+ //+
    public  String  index(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "views/allUsers";
    }
    @GetMapping("/newUser")//+ //+
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "views/newUser";
    }

    @DeleteMapping("/views/{id}")//+
    public String delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @PostMapping("/pages")//+
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }

    @GetMapping("/{id}/edit")// +
    public String edit(Model model, @PathVariable("id")Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "views/edit";
    }
    @GetMapping("views/{id}")//+
    public String find(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "views/findUser";//
    }
    @PatchMapping("/{id}")//?
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}