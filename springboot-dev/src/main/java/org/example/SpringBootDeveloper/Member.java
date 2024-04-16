package org.example.SpringBootDeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Member_SQ")
    @SequenceGenerator(name = "Member_SQ", sequenceName = "MemberId_SQ")
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    public void changeName(String name){
        this.name = name;
    }
}
