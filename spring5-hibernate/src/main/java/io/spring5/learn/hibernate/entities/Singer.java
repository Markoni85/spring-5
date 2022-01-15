package io.spring5.learn.hibernate.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "singer")
public class Singer {

	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Integer version;
	private Set<Album> albums = new HashSet<>();

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Album> getAlbums() {
		return albums;
	}

	private Set<Instrument> instruments = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "singer_instrument", joinColumns = @JoinColumn(name = "SINGER_ID"), inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: "
				+ birthDate;
	}

}
