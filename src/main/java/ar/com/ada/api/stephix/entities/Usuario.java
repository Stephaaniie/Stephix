package ar.com.ada.api.stephix.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import ar.com.ada.api.stephix.security.Crypto;

@Document(collection="Usuarios")
public class Usuario {

    private ObjectId _id;
    
    private String password;

    private String username;

	private String nombre;
	
	public void cargarUsuario(String email,String password) {
        this.setUsername(email);
        
        this.setUsername(email);
        
        this.setPassword(Crypto.encrypt(password, email));
    }


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String email) {
		this.username = email;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}