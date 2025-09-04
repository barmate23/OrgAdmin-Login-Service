package com.AccessManagement.Config;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
//public class DatabaseLoginAuthentication  implements CustomAuthenticationProvider {
public class DatabaseLoginAuthentication {

    Logger log = org.slf4j.LoggerFactory.getLogger(DatabaseLoginAuthentication.class);
    @Autowired
   private AuthenticationManager authenticationManager;

   // @Override
    public boolean authenticate(String username, String password) throws Exception {
        log.info("DatabaseLoginAuthentication ----authenticate---UserId:{}----{}", username, "authenticate method start username: "+username);
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            log.info("DatabaseLoginAuthentication ----authenticate---UserId:{}----{}", username, "Database Authentication Successful!!!");
//            return true;
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
       return true;
    }

}
