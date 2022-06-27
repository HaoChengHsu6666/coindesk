package com.example.coindesk.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Table(name = "crytocoin_exchange_rate")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CrytocoinExchangeRate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "crytocoin_id")
    private int crytocoin_id;

    @Column(name = "crytocoin_code")
    private String crytocoin_code;

    @Column(name = "code")
    private String code;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "rate")
    private String rate;

    @Column(name = "description")
    private String description;

    @Column(name = "rate_float")
    private double rateFloat;

    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "timestamp not null default current_timestamp")
    private Date createdAt;

    @LastModifiedDate
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "timestamp not null default current_timestamp")
    private Date updatedAt;


}
