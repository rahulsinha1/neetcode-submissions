class Solution {
    public int orangesRotting(int[][] grid) {
    //BfS
    Queue<Pair> queue = new LinkedList<>();
    int fresh = 0;
    int time = 0;
    for(int i =0; i<grid.length;i++){
        for(int j =0; j< grid[0].length;j++){
            if(grid[i][j]==1){
                fresh++;
            }
            if(grid[i][j] == 2){
                queue.add(new Pair(i,j));
            }
        }
    }

    if(fresh == 0){
        return 0;
    }

    int [][] neighbours = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};
    
    while (!queue.isEmpty() && fresh >0){
        int size = queue.size();
        for(int i =0;i<size;i++){
            Pair pair =  queue.poll();

            for(int []neighbour: neighbours){
                int r = pair.row+neighbour[0];
                int c = pair.column+neighbour[1];

                if(isValid(r,c, grid) && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    queue.add(new Pair(r,c));
                    fresh --;
                }
            }
        }
        time ++;
    }

    return fresh==0?time:-1;
    }

    private boolean isValid(int r, int c, int[][] grid){
    if(r<0 || r>= grid.length || c<0 || c>= grid[0].length){
        return false;
    }
    return true;
    }
}

class Pair{
    int row;
    int column;

    public Pair(int row, int column){
        this.row = row;
        this.column = column;
    }
}
