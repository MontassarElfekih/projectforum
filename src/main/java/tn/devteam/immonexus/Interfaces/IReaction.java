package tn.devteam.immonexus.Interfaces;

import tn.devteam.immonexus.Entities.Reaction;

import java.util.Optional;

public interface IReaction {

  public Reaction addReaction(Reaction reaction);

  public Reaction updateReaction(Reaction reaction);

  public void deleteReaction(Long id);

  public Optional<Reaction> getReaction(Long id);

  //get all reaction
  public Iterable<Reaction> getAllReactions();


}
