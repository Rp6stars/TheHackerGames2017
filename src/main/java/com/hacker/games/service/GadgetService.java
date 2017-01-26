package com.hacker.games.service;

import com.hacker.games.model.Gadget;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public interface GadgetService {

    List<Gadget> getGadgets();
}
