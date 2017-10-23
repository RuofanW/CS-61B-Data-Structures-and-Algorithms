import java.util.ArrayDeque;
import java.util.Observable;
import java.util.Queue;

/**
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        for (int v = 0; v < maze.V(); v++)
            distTo[v] = 1000;
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */



    private void bfs(int s) {
        if (s == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        marked[s] = true;
        announce();

        q.add(s);

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    announce();
                    q.add(w);
                    if (targetFound) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void solve() {
        bfs(s);
    }



}

