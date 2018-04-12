package com.fizz.spring.part9.config;

import com.fizz.spring.part9.service.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity  //启用WEB安全机制
//@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //.hasRole("X") == hasAuthority("ROLE_X")
        http
            .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers(HttpMethod.GET, "/spitter/register").permitAll()
                .antMatchers("/admin*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .requiresChannel()
                .antMatchers(HttpMethod.POST, "/spitter/register").requiresSecure() //强制通道安全，限制使用https
                .antMatchers("/").requiresInsecure()    //使用http
                .and()
            .rememberMe()   //通过在cookie中储存token(包含用户名、密码、过期时间、私钥，经过MD5 HASH加密)
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(1800)
                .key("securityKey") //默认SpringSecurity
                .and()
            .formLogin()
//                .loginPage("/welcome")   //默认自带"/login"页面
                .and()
            .logout()
//                .logoutSuccessUrl("/") //默认自带"/login?logout"页面
                .and()
            .httpBasic()    //http basic认证
                .and()
            .csrf().disable();  //禁用CSRF（针对跨域请求）防护功能
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //启用内存用户存储(roles("X") == authorities("ROLE_X"))
        auth.inMemoryAuthentication()
                .withUser("root").password("123456").roles("ADMIN", "USER").and()
                .withUser("admin").password("123456").roles("ADMIN").and()
                .withUser("fizz").password("123456").roles("USER");

        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select * from Spitter where username = ?")
                .passwordEncoder(new StandardPasswordEncoder("fizz"));*/

//        auth.userDetailsService(new SpitterUserService());
    }
}
