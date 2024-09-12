package test.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 서버로 들어오는 요청들을 차단해줌
     * 특정 URL에는 보안 레벨을 낮추고 자격이 충분하면 들여보내줌
     * <p>
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable); // csrf disable
        http.formLogin((auth) -> auth.disable()); // From 로그인 방식 disable
        http.httpBasic((auth) -> auth.disable()); // http basic 인증 방식 disable

        /**
         * URL을 들어갈 때 jwt가 필요하게끔 만들어줌( .anyRequest().authenticated() )
         * 특정 URL에는 jwt가 없어도 들어갈 수 있게금 만들어줌( .requestMatchers("/").permitAll() )
         */
        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/member/join").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated());
        // 세션 설정
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    /**
     * BCryptPasswordEncoder 을 Bean으로 등록
     */
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
}
