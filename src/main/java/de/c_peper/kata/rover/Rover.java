package de.c_peper.kata.rover;

import lombok.Data;

@Data
public class Rover {

    public static final int MAX_Y = 10;

    private Integer x;

    private Integer y;

    private Direction direction;

    public Rover() {
        x = 0;
        y = 0;
        direction = Direction.N;
    }

    public String getPositionString() {
        return x + "," + y + "," + direction.toString();
    }

    public void processInput(char input) {
        switch (input) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'F':
                switch (direction) {
                    case N:
                        y++;
                        if (y == MAX_Y) {
                            y = 0;
                        }
                        break;
                    case E:
                        x++;
                        break;
                    case S:
                        moveSouth();
                }
                break;
            case 'B':
                moveSouth();
        }
    }

    private void moveSouth() {
        y--;
        if (y < 0) {
            y = MAX_Y - 1;
        }
    }

    private void turnRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.N;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.N;
        }
    }

    public void processInput(String inputString) {
        for (char inputChar : inputString.toCharArray()) {
            processInput(inputChar);
        }
    }
}
