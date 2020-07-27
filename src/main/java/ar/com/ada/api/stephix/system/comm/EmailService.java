package ar.com.ada.api.stephix.system.comm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.security.Crypto;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class EmailService {
    
    enum TipoEnvio {
        SMTP, API
    }

    private static final String LOGIARSE = "iniciarSesion";
    
    private static final String LOGIARSE_ERROR = "sesionInvalida";
    
    private static final String BIENVENIDA = "bienvenida";

    @Value("${emailSettings.apiKey}")
    private String apiKey;

    @Value("${emailSettings.apiBaseUri}")
    public String apiBaseUri;

    @Value("${emailSettings.apiBaseUri}")
    public String requestUri;

    @Value("${emailSettings.from}")
    public String from;

    @Value("${emailSettings.domain}")
    public String domain;

    @Value("${emailSettings.enabled}")
    public boolean enabled;

     public void SendEmail(String email, String subject, String message) throws UnirestException {

        if (!this.enabled)
            return;

        JsonNode r;

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + this.domain + "/messages").basicAuth("api", this.apiKey).field("from", this.from).field("to", email).field("subject", subject).field("text", message).asJson();
        r = request.getBody();
    }

    public void alertaPorRecibirPor(Usuario usuario,String envio){
        switch (envio) {
            case BIENVENIDA:
                this.SendEmail(usuario.getUsername(), "Bienvenida a Stephix ", "Estimad@: "+ usuario.getNombre() + "\n Te regalamos $500 por confiar en nosotros \n ¡Saludos!");
                break;
            case LOGIARSE:
                this.SendEmail(usuario.getUsername(), "Te logeaste a Stephix", "Estimad@: "+ usuario.getNombre() + "\n Te damos la bienvenida a nuetro sistema tu usuario es:"+ usuario.getUsername()+
                "Tu contraseña es: " + Crypto.decrypt(usuario.getPassword(), usuario.getUsername())+ "\n ¡Saludos!");
                break;
            case LOGIARSE_ERROR:
                this.SendEmail(usuario.getUsername(), "Eror ocurrio un error al intentar logearse", "Estimad@: "+ usuario.getNombre() + "\n¡Saludos!");
                break;
            default:
                break;
        }
    }
}

