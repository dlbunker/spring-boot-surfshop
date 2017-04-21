package com.wave.controllers;

import com.wave.models.Surfboard;
import com.wave.repositories.SurfboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/v1/surfboards")
public class SurfboardController {

    @Autowired
    private SurfboardRepository surfboardRepository;

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public List<Surfboard> list() {
        System.out.println("dev tools");
        return surfboardRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Surfboard create(@RequestBody Surfboard board) {
        return surfboardRepository.saveAndFlush(board);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{surfboardId}")
    public Surfboard get(@PathVariable Long surfboardId) {
        return surfboardRepository.findOne(surfboardId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Surfboard update(@RequestBody Surfboard board) {
        Surfboard s = surfboardRepository.findOne(board.getId());
        s.setMsrp(board.getMsrp());
        s.setBrand(board.getBrand());
        s.setModel(board.getModel());
        return surfboardRepository.saveAndFlush(s);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{surfboardId}")
    public void delete(@PathVariable Long surfboardId) {
        surfboardRepository.delete(surfboardId);
    }
}
