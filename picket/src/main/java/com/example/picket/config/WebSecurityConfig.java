package com.example.picket.config;

import com.example.picket.service.CustomerDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{

    private final CustomerDetailService customerDetailService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/loginmain"),
                                new AntPathRequestMatcher("/mypagemain"),
                                new AntPathRequestMatcher("/QAWrite"),
                                new AntPathRequestMatcher("/profile"),
                                new AntPathRequestMatcher("/QAList")
                        ).hasRole("CUSTOMER")
                        .anyRequest().permitAll())
                .formLogin(formLogin -> formLogin
                        .loginPage("/loginpage")
                        .defaultSuccessUrl("/loginmain")
                        .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/main")
                        .invalidateHttpSession(true)
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionFixation().migrateSession()
                        .maximumSessions(1).expiredUrl("/loginpage?expired"))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
    BCryptPasswordEncoder bCryptPasswordEncoder, CustomerDetailService customerDetailService)
        throws Exception{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
