package com.maxlvshv.eventshare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Column(name = "location")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String location;

    @Column(name = "date_start")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date date_start;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status_enum status;
}