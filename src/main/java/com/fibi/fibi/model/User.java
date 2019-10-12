package com.fibi.fibi.model;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @Min(0)
    @Column(name = "koins")
    private Long koins;

    @Min(0)
    @Max(5)
    @Column(name = "reputation")
    @NotNull
    private double reputation;

    public void setUsername(final String newName) {
        this.username = newName;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setKoins(final Long koins) {
        this.koins = koins;
    }

    public void setReputation(final double reputation) {
        this.reputation = reputation;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public Long getKoins() {
        return this.koins;
    }

    public double getReputation() {
        return this.reputation;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
