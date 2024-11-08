package example.bulletjournal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt로 암호화
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (필요 시)
                .formLogin(AbstractHttpConfigurer::disable) // 폼 로그인 비활성화 (필요 시)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()) // 모든 요청 허용
                .exceptionHandling(configurer -> {
                    configurer.authenticationEntryPoint((request, response, authException) -> {
                        // 인증되지 않은 접근에 대한 처리
                    });
                    configurer.accessDeniedHandler((request, response, accessDeniedException) -> {
                        // 권한 없는 접근에 대한 처리
                    });
                });
        return httpSecurity.build();
    }
}