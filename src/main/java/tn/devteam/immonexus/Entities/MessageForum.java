package tn.devteam.immonexus.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import tn.devteam.immonexus.Entities.User;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageForum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMsgForum;
    private String content;

    private Integer dislikes;




    @ManyToOne
    @JoinColumn(name = "post_id")
    private SubjectForum subjectForum;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="messageForum")
    private List<Dictionary> dictionaries;


}
