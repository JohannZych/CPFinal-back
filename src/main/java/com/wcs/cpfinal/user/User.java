package com.wcs.cpfinal.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcs.cpfinal.advice.Advice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role = "ROLE_USER";

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("user")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Set<Advice> adviceList = new HashSet<>();

}
