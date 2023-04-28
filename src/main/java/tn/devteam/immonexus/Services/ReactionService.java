package tn.devteam.immonexus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.devteam.immonexus.Entities.Reaction;
import tn.devteam.immonexus.Entities.SubjectForum;
import tn.devteam.immonexus.Entities.User;
import tn.devteam.immonexus.Interfaces.IReaction;
import tn.devteam.immonexus.Repository.ReactionRepository;
import tn.devteam.immonexus.Repository.SubjectForumRepository;
import tn.devteam.immonexus.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReactionService implements IReaction {

  @Autowired
  ReactionRepository reactionRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  SubjectForumRepository subjectForumRepository;
  @Override
  public Reaction addReaction(Reaction reaction) {
    User user = userRepository.findById(reaction.getUser().getIdUser()).orElse(null);

    SubjectForum subjectForum = subjectForumRepository.findById(reaction.getSubjectForum().getIdSubjectForum()).orElse(null);

    reaction.setUser(user);
    reaction.setSubjectForum(subjectForum);
    return reactionRepository.save(reaction);
  }

  @Override
  public Reaction updateReaction(Reaction reaction) {
    return null;
  }

  @Override
  public void deleteReaction(Long id) {

  }

  @Override
  public Optional<Reaction> getReaction(Long id) {
    return reactionRepository.findById(id);
  }

  @Override
  public List<Reaction> getAllReactions() {

    try{
      List<Reaction> reactionForumDtos = new ArrayList<>();
      reactionForumDtos = reactionRepository.findAll();
      return reactionForumDtos;
    }catch (Exception exception){
      System.out.println("Error " + exception.fillInStackTrace());
      return null;
    }
  }
}
