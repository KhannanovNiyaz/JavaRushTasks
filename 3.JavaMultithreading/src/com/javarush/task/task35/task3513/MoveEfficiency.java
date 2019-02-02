package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;     // количество пустых плиток
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

//    сравни количество пустых плиток (numberOfEmptyTiles), потом счет (score), если количество пустых плиток равное.
// Если и счет окажется равным, будем считать эффективность ходов равной и вернем ноль.
    @Override
    public int compareTo(MoveEfficiency o) {
        int result = Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (result == 0) {
            result = Integer.compare(score, o.score);
            if (result == 0){
                result = 0;
            }
        }
        return result;
    }
}

