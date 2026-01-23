package com.example.myapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.dto.SignupReq;
import com.example.myapp.model.User;
import com.example.myapp.repo.UserRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UpdateUser {
    @Autowired
    UserRepo db;

    @PutMapping("/update/{id}")
    String updateUser(@PathVariable Long id,
            @RequestBody SignupReq sd) {

        Optional<User> op = db.findById(id);
        if (op.isEmpty()) {
            return "User not found";
        }
        User data = op.get();
        
        data.setName(sd.getName());
        data.setEmail(sd.getEmail());
        

        db.save(data);
        return "User updated sucessfully...✅";

    }
}
