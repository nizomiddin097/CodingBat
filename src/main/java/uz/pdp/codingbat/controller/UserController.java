package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.UserDto;
import uz.pdp.codingbat.payload.UserResponce;
import uz.pdp.codingbat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/read/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping("/add")
    public UserResponce addUser(@RequestBody UserDto userDto){
        UserResponce userResponce = userService.addUser(userDto);
        return userResponce;
    }
    @PutMapping("/edit/{id}")
    public UserResponce editUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        UserResponce userResponce = userService.editUser(id, userDto);
        return userResponce;
    }

    @DeleteMapping("/delete/{id}")
    public UserResponce deleteUser(@PathVariable Integer id){
        UserResponce userResponce = userService.deleteUser(id);
        return userResponce;
    }


}
