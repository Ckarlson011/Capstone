
package com.capstone.nationalparkvisits.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description" , length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String description;
}