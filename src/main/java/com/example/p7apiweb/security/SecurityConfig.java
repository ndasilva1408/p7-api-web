package com.example.p7apiweb.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
      @Autowired
        BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AuthenticationSuccessHandlerImpl authenticationSuccessHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       bCryptPasswordEncoder = getBCPE();

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT login AS principal, password AS credentials, true from client where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT login AS principal, roles AS role FROM client  WHERE login=?")
                .rolePrefix("ROLE_");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // Page login custom
      http .formLogin()
      .loginPage("http://localhost:4200/login");
    //pas de session genere par spring secu, notre session sera via token JWT
      http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

      // CRSF + Authorisation acces tous le site sans role.
      http.csrf().disable()
              .authorizeRequests()
              .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
              .antMatchers("/login","/newclient","/clients","/login/**","/books/**","/books").permitAll()
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic();
      //Filtre
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        //premierfiltre  (before)
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

  @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}

