package org.otrs.costos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userContrato")
public class userContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name ="email", length = 150, nullable = false)
    private String email;

    @Column(name="password", length = 150, nullable = false)
    private String password;

    @Column(name="estado", nullable = false, columnDefinition = "default 0")
    private boolean estado;

    @Column(name="birthDate")
    private LocalDate birthDate;

}
