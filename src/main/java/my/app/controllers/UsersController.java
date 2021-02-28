package my.app.controllers;

import my.app.models.User;
import my.app.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("usersExist", users.size() > 0);

        return "users/index";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String store(@ModelAttribute("user") @Valid User user,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "users/create";
        }

        usersService.createUser(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", usersService.getUser(id));

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,
                             @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        user.setId(id);
        usersService.updateUser(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        usersService.deleteUser(id);

        return "redirect:/users";
    }
}
