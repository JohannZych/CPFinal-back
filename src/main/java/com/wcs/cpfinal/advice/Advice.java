package com.wcs.cpfinal.advice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcs.cpfinal.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Integer rating;

    @ManyToOne
    @JsonIgnoreProperties("adviceList")
    private User user;
}
