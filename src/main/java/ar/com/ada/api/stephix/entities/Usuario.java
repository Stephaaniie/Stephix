package ar.com.ada.api.stephix.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import ar.com.ada.api.stephix.security.Crypto;

@Document(collection="Usuarios")
public class Usuario {

    private ObjectId _id;
    
    private String username;

    private String password;

    private String email;

    private Date fechaLogin;


	public void cargarUsuario(String email,String password) {
        this.setUsername(email);
        
        this.setEmail(email);
        
        this.setPassword(Crypto.encrypt(password, email));
    }


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFechaLogin() {
		return fechaLogin;
	}


	public void setFechaLogin(Date fechaLogin) {
		this.fechaLogin = fechaLogin;
	}
}