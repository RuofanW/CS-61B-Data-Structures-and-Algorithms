package puzzle;

import java.util.Iterator;
import java.util.Stack;

public class Board {

    public int N;
    public int[][] tiles;

    public Board(int[][] blocks){
        N = blocks.length;
        tiles = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tiles[i][j] = blocks[i][j];
            }
        }
    }

    private int[][] createGoalBoard(){
        int[][] goal = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                goal[i][j] = goalValueAt(i, j);
            }
        }
        return goal;
    }

    private int goalValueAt(int i, int j) {
        if (isEnd(i, j)) {
            return 0;
        }
        return 1 + i * N + j;
    }

    private boolean isEnd(int i, int j) {
        return i == N - 1 && j == N - 1;
    }

    /*
     * number of blocks out of place
     */
    public int hamming() {
        int res = 0;
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                if(tiles[i][j] != goalValueAt(i,j) && !isEnd(i, j)){
                    res ++;
                }
            }
        }
        return res;
    }

    /*
     * sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {
        int res = 0;
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                int value = tiles[i][j];
                if(value != goalValueAt(i,j) && value != 0){
                    int xshouldbe = (value - 1)/N;
                    int yshouldbe = value - 1 - xshouldbe * N;
                    int distance = Math.abs(i - xshouldbe)
                            + Math.abs(j - yshouldbe);
                    res += distance;

                }
            }
        }
        return res;
    }

    /*
     * is this board the goal board?
     */
    public boolean isGoal() {
        return tilesEquals(this.tiles, createGoalBoard());
    }

    private boolean tilesEquals(int[][] first, int[][] second) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (first[i][j] != second[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= N || jt < 0 || jt >= N) {
            return false;
        }
        int temp = tiles[i][j];
        tiles[i][j] = tiles[it][jt];
        tiles[it][jt] = temp;
        return true;
    }

    public int tileAt(int i, int j){
        return tiles[i][j];
    }
    public int size(){
        return N ;
    }

    public boolean equals(Object x) {
        if (x == this)
            return true;
        if (x == null)
            return false;
        if (x.getClass() != this.getClass())
            return false;

        Board that = (Board) x;
        return this.N == that.N && tilesEquals(this.tiles, that.tiles);
    }

    public Iterable<Board> neighbors(){
        int i0 = 0, j0 = 0;
        boolean found = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        Stack<Board> boards = new Stack<Board>();
        Board board = new Board(tiles);
        boolean isNeighbor = board.swap(i0, j0, i0 - 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0, j0 - 1);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0 + 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0, j0 + 1);
        if (isNeighbor) {
            boards.push(board);
        }

        return boards;
    }


    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
