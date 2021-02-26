package my.app.controllers;

import my.app.models.User;
import my.app.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String index(Model model) {
        List<User> users = usersService.getUsers();
        model.addAttribute("users", users);

        return "users/index";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String store(@ModelAttribute("user") User user) {
        usersService.createUser(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.getUser(id));

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        user.setId(id);
        usersService.updateUser(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usersService.deleteUser(id);

        return "redirect:/users";
    }
}
