package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CATEGORIES")
@Data
public class Category {
	@Id
    @SequenceGenerator(name = "CATEGORY_ID_GENERATOR", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_GENERATOR")
	@Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String  name;
    
//    @Column(name = "CATEGORY_ID")
//    private Integer categoryId;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items; 
}
