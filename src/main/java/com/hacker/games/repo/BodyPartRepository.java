package com.hacker.games.repo;

import com.hacker.games.model.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Repository
public interface BodyPartRepository extends JpaRepository<BodyPart,Integer> {

    BodyPart findByNameLike(String name);

}
