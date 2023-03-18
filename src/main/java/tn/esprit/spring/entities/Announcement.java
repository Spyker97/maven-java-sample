package tn.esprit.spring.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString


public class Announcement  implements Serializable {
    private static final long serialVersionUID = 1L;





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAnnouncement;
    String description;
    String name;
    String localisation;
    float price;
    Boolean etat;
    int garage;
    int pool ;
    int airConditioning;


    @Enumerated(EnumType.ORDINAL)
    CategorieAnnouncement categorieAnnouncement;

    String region;
    int likes;
    int dislikes;
    LocalDate Date;
    double score;
    int numEvaluations;





    @OneToMany(mappedBy = "announcement")
    List<Visit> visits;

    @OneToOne
    Contrat contrat;



}
