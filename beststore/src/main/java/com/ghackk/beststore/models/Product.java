package com.ghackk.beststore.models;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String clientId;
    private String clientName;
    private String contactInfo;
    private LocalDate receivedDate;
    private String inventoryReceived;
    private String reportedIssues;
    private String clientNotes;
    private String assignedTechnician;
    private String estimatedAmount;
    private LocalDate deadline;
    private String status;

	
	
	
	

}
