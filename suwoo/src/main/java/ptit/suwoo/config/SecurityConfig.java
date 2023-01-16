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
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ptit.suwoo.service.NguoiDungServiceImpl;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig {

    @Autowired
    NguoiDungServiceImpl nguoiDungService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public DaoAuthenticationProvider authenticationProvider1() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(nguoiDungService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain1 (HttpSecurity http) throws Exception {
        http .antMatcher("/admin/**").authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated().and()
//                .authorizeHttpRequests((requests) -> requests
//
//                //        .anyRequest().authenticated()
//                        .antMatchers( "/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
                .formLogin((form) -> form
                        .loginPage("/admin/login")
                        .permitAll().failureUrl("/admin/login?error=true").defaultSuccessUrl("/admin", true).usernameParameter("email")
                        .passwordParameter("password")
                ).authenticationProvider(authenticationProvider1())
                .logout((logout) -> logout.permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                        .logoutSuccessUrl("/admin/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .csrf()
                .disable().headers().frameOptions().disable();

        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**","/templates","/templates/**","/resources/**","/styles/**","/static/**","/resources/adminImages/**","/adminImages/**");
    }


}

