package com.authentication.rolebased.entity;

import jakarta.persistence.*;


@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN,
        ROLE_AGENCY
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	public Role(Long id, RoleName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Role() {
		super();
	}
    
    
}

