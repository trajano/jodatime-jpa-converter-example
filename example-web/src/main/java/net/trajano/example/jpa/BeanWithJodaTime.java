package net.trajano.example.jpa;

import java.util.Date;
import java.util.UUID;

import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

@Entity
@NamedQueries(@NamedQuery(name = "listall", query = "select b from BeanWithJodaTime b"))
public class BeanWithJodaTime {
	@Id
	@GeneratedValue
	long id;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date javaUtilDate;

	private JsonObject json;

	LocalDate localDate;

	@Column(nullable = false)
	LocalDateTime localDateTime;

	UUID uuid;
	@Version
	private int version;

	public JsonObject getJson() {
		return json;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setJson(final JsonObject json) {
		this.json = json;
	}

	public void setLocalDate(final LocalDate localDate) {
		this.localDate = localDate;
	}

	@Override
	public String toString() {
		return "BeanWithJodaTime [id=" + id + ", javaUtilDate=" + javaUtilDate
				+ ", json=" + json + ", localDate=" + localDate
				+ ", localDateTime=" + localDateTime + ", uuid=" + uuid
				+ ", version=" + version + "]";
	}

}
