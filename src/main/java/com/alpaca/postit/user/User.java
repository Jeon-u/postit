package com.alpaca.postit.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
@Entity
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    private String email;
}
