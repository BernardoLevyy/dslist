package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devsuperior.dslist.repositories.GameRepositories;

import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;

@Service
public class GameService {

    @Autowired 
    private GameRepositories gameRepository;


    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDto dto = new GameDto(result);
        return dto;
    }


     @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
       List<Game> result = gameRepository.findAll();
       List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
       return dto;
    }
    
    
}
