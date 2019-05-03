package com.svlada.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRole
 * 
 * @author vladimir.stankovic
 *
 *         Aug 18, 2016
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole {
//	private Long userId;
//	private Long roleId;
//
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="USER_ID")
//	private User user;
	
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1322120000551624359L;
        
        @Column(name = "APP_USER_ID")
        protected Long userId;
        
        @Enumerated(EnumType.STRING)
        @Column(name = "ROLE")
        protected RoleEnum role;
        
        public Id() { }

        public Id(Long userId, RoleEnum role) {
            this.userId = userId;
            this.role = role;
        }
    }
    
    @EmbeddedId
    Id id = new Id();
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable=false, updatable=false)
    protected RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }
    
    
}
