package ar.com.apicashonline.cashonline.models.response;

public class JwtResponse {

    private final String jwttoken;

    public JwtResponse(String jwttoken) {

        this.jwttoken = jwttoken;

    }

    public String getToken() {

        return this.jwttoken;

    }
}