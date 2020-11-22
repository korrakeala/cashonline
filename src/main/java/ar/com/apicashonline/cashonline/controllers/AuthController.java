package ar.com.apicashonline.cashonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.models.request.LoginRequest;
import ar.com.apicashonline.cashonline.models.request.RegistrationRequest;
import ar.com.apicashonline.cashonline.models.response.JwtResponse;
import ar.com.apicashonline.cashonline.models.response.RegistrationResponse;
import ar.com.apicashonline.cashonline.security.jwt.JWTTokenUtil;
import ar.com.apicashonline.cashonline.services.JWTUserDetailsService;
import ar.com.apicashonline.cashonline.services.UsuarioService;



@RestController
public class AuthController {

    @Autowired
    UsuarioService us;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req)
            /* throws PersonaEdadException, CuentaPorMonedaException */ {
        RegistrationResponse r = new RegistrationResponse();

        Usuario usuarioCreado = us.altaUser(req.firstName, req.lastName, req.email);

        r.isOk = true;
        r.message = "Usuario resgistrado con éxito.";
        r.usuarioId = usuarioCreado.getUserId();
        return r;
    }

    // dejo seguridad preparada para implementar password a futuro
    // ya que por ahora se solicitó sólo post con firstName, lastName e email.
    @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        Usuario u = us.buscarPorEmail(authenticationRequest.email);

        us.login(u.getUserName(), u.getPassword());

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(u.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    
}