package com.example.picket.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;


@Table
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Customer implements UserDetails {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "pw", nullable=false)
    private String pass;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name= "name", nullable = false)
    private String name;
    @Column(name = "birthdate", nullable = false)
    private String birthdate;
    @Column(name="tel", unique = true, nullable = false)
    private String tel;
    @Column(name="card")
    private Long card;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "point")
    private Long point;

    @Builder
    public Customer(String id, String pass, String email, String name, String birthdate, String tel, Long card, Long balance,Long point, String auth) {
        this.id = id;
        this.pass = pass;
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
        this.tel = tel;
        this.card = card;
        this.balance = balance;
        this.point = point;
    }
    public static class CustomerBuilder {
        // 선택적 필드
        private Long card;
        private Long balance;
        private Long point;
        public CustomerBuilder card(Long card) {
            this.card = card;
            return this;
        }

        public CustomerBuilder balance(Long balance) {
            this.balance = balance;
            return this;
        }

        public CustomerBuilder point(Long point) {
            this.point = point;
            return this;
        }
        public Customer build() {
            return new Customer(id, pass, email, name, birthdate, tel, card, balance, point);
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
    }
    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public String getPassword() {
        return pass;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
