package com.capstone.nationalparkvisits.form;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewVisitForm {

	private Integer id;
	
	private Integer park;
	
	@Length(max = 65534, message = "Entry must be shorter than 65534 characters.")
	private String description;
	
	private String start;
	
	private String end;
	
}
