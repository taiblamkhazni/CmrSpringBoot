package com.example.demo.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
    @GeneratedValue
    private Long role_Id;
	
	@Column(name = "Role_Name", length = 64, nullable = false)
    private String rolename;
	
	
	
	
	
}
