package net.trajano.example.jpa;

import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, String> {

	@Override
	public String convertToDatabaseColumn(final UUID uuid) {
		if (uuid == null) {
			return null;
		}
		return uuid.toString();
	}

	@Override
	public UUID convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return null;
		}
		return UUID.fromString(dbData);
	}
}
