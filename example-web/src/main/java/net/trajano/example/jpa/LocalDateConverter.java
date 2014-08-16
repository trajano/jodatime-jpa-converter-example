package net.trajano.example.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements
		AttributeConverter<LocalDate, String> {

	@Override
	public String convertToDatabaseColumn(final LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return localDate.toString();
	}

	@Override
	public LocalDate convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return null;
		}
		return LocalDate.parse(dbData);
	}
}
