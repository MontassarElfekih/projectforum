package tn.devteam.immonexus.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.devteam.immonexus.Entities.Reaction;
import tn.devteam.immonexus.Entities.SubjectForum;
import tn.devteam.immonexus.Services.ReactionService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Reaction")
public class ReactionController {

  @Autowired
  ReactionService reactionService;


  @PostMapping("/addReaction")
  public Reaction addReaction(@RequestBody Reaction reaction){
    return reactionService.addReaction(reaction);
  }

  @GetMapping("/getAll")
  public List<Reaction> getAllReaction() {
    return reactionService.getAllReactions();
  }

  @GetMapping("/get/{id}")
  public Reaction getReactionById(@PathVariable(value = "id") Long id) {
    Optional<Reaction> sub = reactionService.getReaction(id);
    if (sub.isPresent()) {
      return sub.get();
    } else {
      return null;
    }
  }

}
