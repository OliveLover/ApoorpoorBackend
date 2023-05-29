package com.example.apoorpoor_backend.model;

import com.example.apoorpoor_backend.dto.AccountRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "ACCOUNT")
@NoArgsConstructor
@Table
public class Account extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Balance balance;

    //@JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<LedgerHistory> ledgerHistories = new ArrayList<>();

    public Account(AccountRequestDto requestDto, User user){
        this.title = requestDto.getTitle();
        this.user = user;
    }
    public void update(AccountRequestDto requestDto){
        this.title = requestDto.getTitle();
    }

}
