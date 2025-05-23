package com.devsuperior.dslist.entities;


import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPk id = new BelongingPk();

    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public Game getGame() {
        return id.getGame();
    }

    public void setGame(Game game) {
        id.setGame(game);
    }

    public GameList getList() {
        return id.getList();
    }

    public void setList(GameList list) {
        id.setList(list);
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Belonging [game=" + getGame().getId() + 
               ", list=" + getList().getId() + 
               ", position=" + position + "]";
    }
}
//