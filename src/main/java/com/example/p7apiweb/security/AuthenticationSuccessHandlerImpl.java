package com.example.p7apiweb.security;

import com.example.p7apiweb.DAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Autowired
    HttpSession session;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        String login="";
        if(authentication.getPrincipal()instanceof Principal){
            login = ((Principal) authentication.getPrincipal()).getName();
        }
        else {
            login=((User)authentication.getPrincipal()).getUsername();
        }
        authentication.getAuthorities();
    }
}
