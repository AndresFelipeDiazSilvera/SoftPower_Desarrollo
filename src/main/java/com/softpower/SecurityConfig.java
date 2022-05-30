package com.softpower;

import com.softpower.models.services.UserSoftpowerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserSoftpowerServiceImp userSoftpowerServiceImp;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.userDetailsService(userSoftpowerServiceImp).passwordEncoder(bcrypt);
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/resources/**", "/assets/**","/img/**").permitAll()
                .antMatchers("/inicio").permitAll()
                .antMatchers("/tercero/**","/marca/**","/movimiento/**","/producto/**").access("hasRole('ADMIN')")
                //.antMatchers("/producto/**","/marca/**").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/marca/**","/movimiento/**","/producto/**").access("hasRole('EMPLOYEE') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/inicio",true)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/inicio")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied");

    }
}
