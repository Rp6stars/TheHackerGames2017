package com.hacker.games.repo;

import com.hacker.games.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by eniko.pal on 26/01/2017.
 */
public interface VideoRepository extends JpaRepository<Video,Integer> {

    List<Video> findByGadgetId(Integer gadgetId);
}
