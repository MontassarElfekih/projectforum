package tn.devteam.immonexus.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.devteam.immonexus.Entities.Like;

@Repository
public interface likeRepository extends JpaRepository<Like,Long> {
    

}
