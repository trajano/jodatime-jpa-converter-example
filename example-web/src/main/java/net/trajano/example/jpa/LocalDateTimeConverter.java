package net.trajano.example.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements
AttributeConverter<LocalDateTime, String> {

	@Override
	public String convertToDatabaseColumn(final LocalDateTime attribute) {
		return attribute.toString();
	}

	@Override
	public LocalDateTime convertToEntityAttribute(final String dbData) {
		return LocalDateTime.parse(dbData);
	}

}
