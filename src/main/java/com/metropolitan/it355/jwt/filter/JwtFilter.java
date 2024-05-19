package com.metropolitan.it355.jwt.filter;

import com.metropolitan.it355.entity.User;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.UserRepository;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, JwtException, ServletException {
        try {
            String authHeader = request.getHeader("Authorization"); // Bearer jwt
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            String jwt = authHeader.split(" ")[1];


            String username = jwtService.extractUsername(jwt);
            User user = userRepository.findByUsername(username).get();
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    username, null, user.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authToken);
            filterChain.doFilter(request, response);

        }
        catch (JwtException e) {
            System.err.println(e.getMessage());
            extracted(response, e.getMessage());
        }
    }

    private static void extracted(HttpServletResponse response , String s) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \""+s+"\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
