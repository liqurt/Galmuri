package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.dto.user.UserCreateDto;
import com.ssafy.galmuri.dto.user.UserReadDto;
import com.ssafy.galmuri.dto.user.UserUpdateDto;
import com.ssafy.galmuri.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @PostMapping("/register")
    public String save(@RequestBody UserCreateDto createDto){
        return userService.save(createDto);
    }
    @GetMapping("exist/{userId}/{domain}")
    public Boolean isExist(@PathVariable String userId, @PathVariable char domain){
        UserReadDto user=null;
        try{
            user = userService.findByIdAndDomain(userId,domain);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
         return true;
    }

    @GetMapping("/find/{userId}/{domain}")
    public UserReadDto findByIdAndDomain(@PathVariable String userId, @PathVariable char domain){
        return userService.findByIdAndDomain(userId,domain);
    }
    @PutMapping("/update/{userId}/{domain}")
    public String update(@PathVariable String userId, @PathVariable char domain, @RequestBody UserUpdateDto updateDto){
        return userService.update(userId,domain,updateDto);
    }
    @DeleteMapping("/delete/{userId}/{domain}")
    public String deleteByIdAndDomain(@PathVariable String userId, @PathVariable char domain){
        return userService.deleteByIdAndDomain(userId,domain);
    }
}
