package com.capstone.nationalparkvisits.database.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="users_id")
	private Integer usersId;
	
	@Column(name="natparks_id")
	private Integer natparksId;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start")
	private Date start;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end")
	private Date end;
}
