package es.palmademallorca.imi.proyecto2.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PersonDto {

	@NotNull
	@Min(1)
	private Long id;

	@Length(min=3, max=50)
	private String name;

	@Length(max=50)
	private String surname;
	
	public PersonDto(long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public PersonDto() {
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
