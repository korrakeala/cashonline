package ar.com.apicashonline.cashonline.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Usuario;


@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService us;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario u = us.buscarPorUserName(userName);

        if (u != null) {
            return new User(u.getUserName(), u.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
    }
    
}
