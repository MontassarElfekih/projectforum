package tn.devteam.immonexus.Dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tn.devteam.immonexus.Entities.Reaction;
import tn.devteam.immonexus.Entities.TypeReact;
import tn.devteam.immonexus.Entities.User;

import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class SubjectForumDto {

    private Long id;
    private String title;
    private String description;
    private String photo;


  // private Set<Reaction> reactions;

   private Long NbrLike;
}
