package snakesAndLadder.design.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Player {

    private String name;
    private int position = 0;
    private boolean winner = false;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void movePlayer(int targetPosition) {
        this.position = targetPosition;
    }
}
