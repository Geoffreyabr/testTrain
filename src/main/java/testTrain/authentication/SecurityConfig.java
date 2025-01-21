package testTrain.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Désactive la protection CSRF, uniquement pour les tests ou si vous avez un autre mécanisme
                .csrf(csrf -> csrf.disable())

                // Autorise certaines routes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/trains/**").permitAll()
                        .requestMatchers("/agents/**").permitAll()

                        // autorise l'import CSV sans authentification
                        .anyRequest().authenticated()                   // le reste requiert une authentification
                );

        return http.build();
    }
}
