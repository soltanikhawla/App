package com.Test.Demo.controller;

import com.Test.Demo.Config.JwtUtils;
import com.Test.Demo.dao.UserDao;
import com.Test.Demo.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserDao userDao ;



    @PostMapping("/authenticate")
    public ResponseEntity <String> authenticate(
            @RequestBody AuthenticationRequest request
    ){
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword())
         );
         final UserDetails user = userDao.findUserByLogin(request.getLogin());
         if (user !=null){
             return ResponseEntity.ok(jwtUtils.generateToken(user));
         }
         return ResponseEntity.status(400).body("some error");
    }

}
