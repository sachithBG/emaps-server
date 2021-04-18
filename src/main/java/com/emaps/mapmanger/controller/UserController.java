package com.emaps.mapmanger.controller;

import com.emaps.mapmanger.message.req.UserReq;
import com.emaps.mapmanger.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "")
    public ResponseEntity<?> addUser(@RequestBody UserReq req) throws Exception {
        return userService.addUser(req);
    }

    @GetMapping(path = "/find/{email}")
    public ResponseEntity<?> getUser(@PathVariable(value = "email") String email){
        return userService.findUsers(email);
    }

    @DeleteMapping(path = "/delete/{info_id}")
    public ResponseEntity<?> deleteUsr(@PathVariable(value = "info_id") Long info_id) throws Exception {
        return userService.delete(info_id);
    }

}
