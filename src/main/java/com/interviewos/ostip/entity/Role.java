package com.interviewos.ostip.entity;

import com.interviewos.ostip.security.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "app_role")
@Getter
@Setter
public class Role {


    @Id
    private UUID id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName name;
}
