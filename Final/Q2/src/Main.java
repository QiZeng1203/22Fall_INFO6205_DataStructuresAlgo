public class Main {

    public static void main(String[] args) {
	// write your code here
        char[][] grid = { {'1', '1', '0', '0', '0'},
                           {'1', '1', '0', '0', '0'},
                           {'0', '0', '1', '0', '0'},
                           {'0', '0', '0', '1', '1'} };
        System.out.println(numberOfIslands(grid));
    }

    //Time Complexity:
    public static int numberOfIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i ++){
            for(int j = 0 ; j < cols; j ++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    visitNeighbours(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private static void visitNeighbours(char[][] grid, boolean[][] visited, int row, int col){

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
                grid[row][col] == '0' || visited[row][col] == true){
            return;
        }
        visited[row][col] = true;
        visitNeighbours(grid, visited, row -1, col); // top
        visitNeighbours(grid, visited, row , col + 1); // right
        visitNeighbours(grid, visited, row + 1 , col); // bottom
        visitNeighbours(grid, visited, row , col -1); // Left
    }
}
