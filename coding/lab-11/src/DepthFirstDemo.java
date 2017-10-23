/** 
 *  @author Josh Hug
 */
import java.util.ArrayDeque;
import java.util.Queue;


public class DepthFirstDemo {
    /* Runs a depth first search from (1, 1) to (N, N) on the graph in the config file. */

    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */




    public static void main(String[] args) {
        Maze maze = new Maze("maze.config");

        int startX = 1; 
        int startY = 1; 
        int targetX = maze.N();
        int targetY = maze.N();

        MazeExplorer mdfp = new MazeDepthFirstPaths(maze, startX, startY, targetX, targetY);
        mdfp.solve();
    }



} 