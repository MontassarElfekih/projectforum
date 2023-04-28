package tn.devteam.immonexus.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectForum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubjectForum;
    @Size(min = 5, max = 20, message = "Le title doit contenir entre 5 et 20 caractères")
    private String title;
    @Size(min = 5, max = 20, message = "La description doit contenir entre 5 et 20 caractères")
    private String description;
   // @Lob
   // private byte[] image;
    private String photo;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private User user;
    @ManyToOne
    @JsonIgnore
    Dictionary Dictionary;
@JsonIgnore
    @OneToMany(
            mappedBy = "subjectForum",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Reaction> reactions;

}
