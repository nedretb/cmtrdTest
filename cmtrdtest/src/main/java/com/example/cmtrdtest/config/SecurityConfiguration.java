package com.example.cmtrdtest.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Override
    public void configure(HttpSecurity http) throws Exception{
//       http.authorizeRequests().antMatchers("/css/**","/js/**","/fonts/**","/images/**","/add-language").permitAll()
//               .antMatchers("/add-language").hasRole("admin")
//               .anyRequest().authenticated();
//       http.formLogin().loginPage("/secure/hello").permitAll().defaultSuccessUrl("/add-language");
      http
              .authorizeRequests()
              .antMatchers("/resources/**").permitAll()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/secure/hello")
              .permitAll().defaultSuccessUrl("/add-language")
              .and()
              .logout()
              .permitAll();
   }

}
