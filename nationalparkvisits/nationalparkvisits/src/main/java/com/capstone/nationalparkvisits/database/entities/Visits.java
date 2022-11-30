
package com.capstone.nationalparkvisits.database.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "visits")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Visits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="description" , length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start")
	private Date start;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end")
	private Date end;
	
	@OneToMany
	@JoinColumn(name="visits_id")
	private List<Events> events = new ArrayList<Events>();
}
