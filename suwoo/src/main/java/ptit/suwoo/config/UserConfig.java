package ptit.suwoo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ptit.suwoo.service.NguoiDungServiceImpl;

@Configuration
@EnableWebSecurity
@Order(2)
public class UserConfig {
    @Autowired
    NguoiDungServiceImpl nguoiDungService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public DaoAuthenticationProvider authenticationProvider2() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(nguoiDungService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager2(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }



    @Bean
    public SecurityFilterChain securityFilterChain2 (HttpSecurity http) throws Exception {

        http.antMatcher("/**").authorizeHttpRequests().
                antMatchers("/","/home","/login","admin/login","/register","/static/**",
                        "/","/images/**","/viewListProductDt","/viewListProductDt/**",
                        "/viewListProductDt/page/","/slider/**","/dtImages/**","/productDetailsClient/**",
                        "/ltImages/**","/adminImages/**","/viewListProductDtWithFilter/**","/viewListProductDtWithFilter","/viewListProductLt/**","/viewListProductLtWithFilter/**"
                        ,"/productLtDetailsClient/**","/detailsProducts/**","/searchProducts/**").permitAll().
//                anyRequest().authenticated().
                antMatchers("/cart","/users").hasRole("USER").anyRequest().
                authenticated().and()
//                authorizeHttpRequests((requests) -> requests
//                        .antMatchers( "/home","/login"
//                                ,"admin/login","/register","/static/**","/","/images/**","/viewListProductDt","/viewListProductDt/**","/viewListProductDt/page/","/slider/**","/dtImages/**","/productDetailsClient/**","/ltImages/**","/adminImages/**").permitAll()
//
//                        //        .anyRequest().authenticated()
//                        .antMatchers( "/cart","/users").hasRole("USER")
//                        .anyRequest().authenticated()
//                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll().failureUrl("/login-error").defaultSuccessUrl("/", true).usernameParameter("email")
                        .passwordParameter("password")
                ).authenticationProvider(authenticationProvider2())
                .logout((logout) -> logout.permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .csrf()
                .disable().headers().frameOptions().disable();

        return http.build();
    }
}
