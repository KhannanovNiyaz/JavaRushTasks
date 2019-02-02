package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    Stack<Tile[][]> previousStates;   //предыдущие состояния игрового поля
    Stack<Integer> previousScores;     //предыдущие счета
    boolean isSaveNeeded = true;       //    необходимо сохранить
    private static final int FIELD_WIDTH = 4;
    protected int score = 0;          //текущий счет
    protected int maxTile = 0;        //максимальный вес плитки на игровом поле
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
        previousScores = new Stack<>();
        previousStates = new Stack<>();
    }

    //    начать новую игру, не приходилось создавать новую модель, а можно было бы просто вернуться в начальное состояние  вызвав его.
    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    //    возвращать список пустых плиток в массиве gameTiles.
    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                if (tile.isEmpty()) {
                    emptyTiles.add(tile);
                }
            }
        }
        return emptyTiles;
    }

    // установить значение в поле
    public void addTile() {
        List<Tile> emptyForCreateTile = getEmptyTiles();
        if (!emptyForCreateTile.isEmpty()) {
            Tile emptyTile = emptyForCreateTile.get((int) (emptyForCreateTile.size() * Math.random()));
            emptyTile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    // Сжатие плиток, таким образом, чтобы все пустые плитки были справа, т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    static private boolean compressTiles(Tile[] tiles) {
        boolean isChange = false;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i - 1].value == 0) {
                for (int j = i; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i - 1].value = tiles[j].value;
                        tiles[j].value = 0;
                        isChange = true;
                        break;
                    }
                }
            }
        }
        return isChange;
    }

    // Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}. ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0},
// а {4, 4, 4, 0} в {8, 4, 0, 0}.
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChange = false;
        int tileMergeValue = 0;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i - 1].value == tiles[i].value && tiles[i].value != 0) {
                tileMergeValue = tiles[i].value * 2;
                tiles[i - 1].value = tileMergeValue;
                score = score + tileMergeValue;
                if (tileMergeValue > maxTile) maxTile = tileMergeValue;
                tiles[i].value = 0;
            }
        }
        compressTiles(tiles);
        if (tileMergeValue > 0) {
            isChange = true;
        }
        return isChange;
    }

    //    перемещать элементы массива влево в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимo
    protected void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChange = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile) && !getEmptyTiles().isEmpty()) {
                isChange = true;
            }
        }
        if (isChange) {
            addTile();
        }
        isSaveNeeded = true;
    }

    //    поворачивать массив против часовой стрелки
    private void rotateCounterClock() {

        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = tmp;
            }
        }
    }

    // перемещать элементы массива вверх в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимo
    protected void up() {
        saveState(gameTiles);
        rotateCounterClock();
        left();
        rotateCounterClock();
        rotateCounterClock();
        rotateCounterClock();
    }

    // перемещать элементы массива вниз в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимo
    protected void down() {
        saveState(gameTiles);
        rotateCounterClock();
        rotateCounterClock();
        rotateCounterClock();
        left();
        rotateCounterClock();
    }

    // перемещать элементы массива вправо в соответствии с правилами игры и добавлять плитку с помощью метода addTile, если это необходимo
    protected void right() {
        saveState(gameTiles);
        rotateCounterClock();
        rotateCounterClock();
        left();
        rotateCounterClock();
        rotateCounterClock();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    //  true в случае, если в текущей позиции возможно сделать ход так, чтобы состояние игрового поля изменилось. Иначе - false.
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[j][i].value == gameTiles[j + 1][i].value)
                    return true;
            }
        }
        return false;
    }

    //    сохранять текущее игровое состояние и счет в стеки
    private void saveState(Tile[][] tiles) {
//        tiles = Arrays.copyOf(gameTiles, gameTiles.length);
        Tile[][] tempTiles = new Tile[tiles.length][tiles[0].length];
        tempTiles = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    //    устанавливать текущее игровое состояние равным последнему находящемуся в стеках
    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    //    дать игре возможность самостоятельно выбирать следующий ход.
    public void randomMove() {
        int n = (int) ((Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

//    будет возвращать true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток верхнем массиве стека previousStates
    public boolean hasBoardChanged() {
        int tempTileWeight = 0;
        int previousTileWeight = 0;
        Tile tmp[][] = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                tempTileWeight += gameTiles[i][j].value;
                previousTileWeight += tmp[i][j].value;
            }
        }
        return tempTileWeight != previousTileWeight;
    }

//    возвращает объект типа MoveEfficienc описывающий эффективность переданного хода
    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }
}
