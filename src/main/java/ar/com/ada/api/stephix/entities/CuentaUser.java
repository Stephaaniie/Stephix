package ar.com.ada.api.stephix.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cuentas")
public class CuentaUser {

    public ObjectId _id;

    List<ObjectId> usuarios = new ArrayList<>();

	public ObjectId get_id() {
		return _id;
	}

	public List<ObjectId> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<ObjectId> usuarios) {
		this.usuarios = usuarios;
	}
}