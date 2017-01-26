package com.hacker.games.repo;

import com.hacker.games.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eniko.pal on 26/01/2017.
 */
public interface VideoRepository extends JpaRepository<Gadget,Integer> {
}
