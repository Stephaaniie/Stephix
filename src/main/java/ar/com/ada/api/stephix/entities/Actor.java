package ar.com.ada.api.stephix.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Elenco")
public class Actor {

    public ObjectId _id;
    
	public String descripcion;

    public String nombre;

    public int edad;

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}