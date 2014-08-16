package net.trajano.example.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(nullable = false)
	LocalDateTime localDateTime;

	@Override
	public String toString() {
		return "BeanWithJodaTime [id=" + id + ", javaUtilDate=" + javaUtilDate
				+ ", localDateTime=" + localDateTime + "]";
	}

}
