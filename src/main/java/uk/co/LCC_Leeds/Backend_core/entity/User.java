package uk.co.LCC_Leeds.Backend_core.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import uk.co.LCC_Leeds.Backend_core.entity.BaseEntity;

import java.math.BigInteger;

@Entity
@Builder
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity{

    /*
     `user_id` int AUTO_INCREMENT PRIMARY KEY,
    `fName` varchar(100) NOT NULL,
    `lName` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `info` varchar(100),
    `imageURL` varchar(100),
    `position` varchar(100) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
    }
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String info;
    private String imageURL;
    private String position;

}
