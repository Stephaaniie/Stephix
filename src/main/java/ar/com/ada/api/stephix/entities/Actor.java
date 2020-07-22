package ar.com.ada.api.stephix.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Elenco")
public class Actor {
    private ObjectId _id;

	public String get_id() {
		return this._id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}