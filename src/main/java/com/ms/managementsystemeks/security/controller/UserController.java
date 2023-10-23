package com.ms.managementsystemeks.security.controller;


import com.ms.managementsystemeks.security.entities.Role;
import com.ms.managementsystemeks.security.entities.UserInfo;
import com.ms.managementsystemeks.security.repository.RoleRepository;
import com.ms.managementsystemeks.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @PostMapping
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo user){
        user.setRoles(user.getRoles().stream().map( role -> roleRepository.findById(role.getId()).get()).collect(Collectors.toSet()));
        return new ResponseEntity<UserInfo>(userRepository.save(user), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllroles(){
        return new ResponseEntity<List<Role>>(roleRepository.findAll(), HttpStatus.OK);
    }
}
