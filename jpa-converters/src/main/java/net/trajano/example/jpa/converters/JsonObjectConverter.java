package net.trajano.example.jpa.converters;

import java.sql.Clob;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PersistenceException;
import javax.sql.rowset.serial.SerialClob;

@Converter(autoApply = true)
public class JsonObjectConverter implements
AttributeConverter<JsonObject, Clob> {

	@Override
	public Clob convertToDatabaseColumn(final JsonObject jsonObject) {
		if (jsonObject == null) {
			return null;
		}
		try {
			return new SerialClob(jsonObject.toString().toCharArray());
		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public JsonObject convertToEntityAttribute(final Clob dbData) {
		if (dbData == null) {
			return null;
		}
		try {
			return Json.createReader(dbData.getCharacterStream()).readObject();
		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	}

}
