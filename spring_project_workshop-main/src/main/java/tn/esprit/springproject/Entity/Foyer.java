package tn.esprit.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "foyer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy="foyer")
    @JsonIgnore
    private Universite universite;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    @JsonIgnore
    private Set<Bloc> blocs;

}
