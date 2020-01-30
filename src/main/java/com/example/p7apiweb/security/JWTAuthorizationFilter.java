package com.example.p7apiweb.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


//A implanter dans chaque micro service
//Pour chaque methode qui communique avec les microservice, ce filtre sera execute avant

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", "*");
        //Autorisé tous ces headers
        response.addHeader("Access-Control-Allow-Methods","POST,DELETE,PUT,GET,PATCH");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,authorization,content-type");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials,authorization ");

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);

        } else if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;

        } else {

            String jwt = request.getHeader(SecurityParams.JWT_HEADER_NAME);
            if (jwt == null || !jwt.startsWith(SecurityParams.HEADER_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();

            DecodedJWT decodedJWT = verifier.verify(jwt.substring(SecurityParams.HEADER_PREFIX.length()));

            //username dans le payload est sub
            String username = decodedJWT.getSubject();

            //Roles est un claim
            String role = decodedJWT.getClaim("roles").asString();

            //on retransforme les roles en GrantedAuthority
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));

            //Creation du token utilisateur authentifié
            UsernamePasswordAuthenticationToken userToken =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(userToken);
            //filtre suivant
            filterChain.doFilter(request, response);

        }
    }
}
