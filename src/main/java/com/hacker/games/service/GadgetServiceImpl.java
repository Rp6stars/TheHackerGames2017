package com.hacker.games.service;

import com.hacker.games.model.Gadget;
import com.hacker.games.repo.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public class GadgetServiceImpl implements GadgetService {

    @Autowired
    GadgetRepository gadgetRepository;
    @Override
    public List<Gadget> getGadgets() {
        return gadgetRepository.findAll();
    }
}
