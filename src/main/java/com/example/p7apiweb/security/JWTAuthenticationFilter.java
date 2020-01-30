package com.example.p7apiweb.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.p7apiweb.entities.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.p7apiweb.security.SecurityParams.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            Client client = new ObjectMapper().readValue(request.getInputStream(), Client.class);
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(client.getLogin(), client.getPassword()));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("e");

        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServletException {
        //@user contient l'utilisateur
        User user=(User)authResult.getPrincipal();

        //On met les roles dans une list, et getAuthorities nous permet de les recup un par un
        List<String> roles = new ArrayList<>();
        authResult.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });

        String jwt= JWT.create()
                //Nom de l'autorite de l'app qui a genere le token
                .withIssuer(request.getRequestURI())
                //nom de l'utilisateur
                .withSubject(user.getUsername())
                //roles sous forme de tableau
                .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
                //date d'expiration du token(Ici 4H -> 4 x 3600 secondes( 1h)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION))
                //signature
                .sign(Algorithm.HMAC256(SECRET));

        response.addHeader(JWT_HEADER_NAME,jwt);
    }
}
