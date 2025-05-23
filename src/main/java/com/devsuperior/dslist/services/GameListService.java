package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.repositories.GameListRepositories;
import com.devsuperior.dslist.repositories.GameRepositories;

import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;

@Service
public class GameListService {

    @Autowired 
    private GameListRepositories gameListRepository;

    @Autowired 
    private GameRepositories gameRepositoriy;


     @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
       List<GameList> result = gameListRepository.findAll();
       List<GameListDto> dto = result.stream().map(x -> new GameListDto(x)).toList();
       return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listid) {
       List<GameMinProjection> result = gameRepositoriy.searchByList(listid);
       return result.stream().map(x -> new GameMinDto(x)).toList();
       
    }
    
    
}
// 