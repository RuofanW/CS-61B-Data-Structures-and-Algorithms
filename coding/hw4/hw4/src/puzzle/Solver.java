package puzzle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

public class Solver {
    public Stack<Board> boards;
    public int moves;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private SearchNode previous;
        private int cachedPriority = -1;

        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        private int priority() {
            if (cachedPriority == -1) {
                cachedPriority = moves + board.manhattan();
            }
            return cachedPriority;
        }

        @Override
        public int compareTo(SearchNode that) {
            if (this.priority() < that.priority()) {
                return -1;
            }
            if (this.priority() > that.priority()) {
                return +1;
            }
            return 0;
        }
    }

    public Solver(Board initial){
        boards = new Stack<Board>();
        if (initial.isGoal()) {
            this.boards.push(initial);
            return;
        }
        MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>();
        moves = 0;
        Board board = initial;
        SearchNode node = new SearchNode(board, 0, null);
        minPQ.insert(node);
        while(moves < 100){
            node = minPQ.delMin();
            board = node.board;
            if(board.isGoal()){
                this.boards.push(board);
                while (node.previous != null) {
                    node = node.previous;
                    this.boards.push(node.board);
                }
                return;
            }

            node.moves++;

            Iterable<Board> neighbors = board.neighbors();
            for (Board neighbor : neighbors) {
                if (node.previous != null
                        && neighbor.equals(node.previous.board)) {
                    continue;
                }
                SearchNode newNode = new SearchNode(neighbor, node.moves, node);
                minPQ.insert(newNode);
            }
        }
    }

    public int moves() {
        return boards.size() - 1;
        }

    /*
     * sequence of boards in a shortest solution; null if no solution
     */
    public Iterable<Board> solution() {
        return boards;

    }
    // DO NOT MODIFY MAIN METHOD
    /* Uncomment this method once your Solver and Board classes are ready.
    */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution()) {
            StdOut.println(board);
       }
    }

}
