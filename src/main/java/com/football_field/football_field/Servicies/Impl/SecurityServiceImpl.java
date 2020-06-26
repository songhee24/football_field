//package com.football_field.football_field.Servicies.Impl;
//
//import com.football_field.football_field.Servicies.SecurityService;
//import org.slf4j.ILoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.net.Authenticator;
//
//@Service
//public class SecurityServiceImpl implements SecurityService {
//
//    private static Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
//
//    @Qualifier("userServiceImpl")
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public String findLoggedInUsername() {
//        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        if (userDetails instanceof UserDetails){
//            return (((UserDetails) userDetails).getUsername());
//        }
//        return null;
//    }
//
//    @Override
//    public void autoLogin(String username, String password) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
//
//            authenticationManager.authenticate(authenticationToken);
//
//            if (authenticationToken.isAuthenticated()){
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//                logger.debug(String.format("SENPAI IT WOOORKS " , username));
//            }
//    }
//}
