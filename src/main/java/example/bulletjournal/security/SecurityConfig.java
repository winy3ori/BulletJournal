package example.bulletjournal.security;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt로 암호화
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable() // HTTP 기본 인증을 비활성화
                .cors().and() // CORS 활성화
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (필요 시)
                .formLogin(AbstractHttpConfigurer::disable) // 폼 로그인 비활성화 (필요 시)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()) // 모든 요청 허용

                .oauth2Login(); // OAuth2 로그인 활성화


        return httpSecurity.build();
    }
}