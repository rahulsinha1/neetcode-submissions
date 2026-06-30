class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i =0; i<9;i++){
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int j=0; j<9;j++)
            {
                if (rowSet.contains(board[i][j]) && board[i][j]!= '.'){
                    return false;
                }
                rowSet.add(board[i][j]);
                if (columnSet.contains(board[j][i]) && board[j][i]!= '.'){
                    return false;
                }
                columnSet.add(board[j][i]);
            }
        }

        for (int i =0 ;i<9;i=i+3){
            for (int j=0 ;j<9;j=j+3) {
                Set<Character> boxSet = new HashSet<>();
                for (int r = i;r<i+3;r++)
                {
                    for (int c=j;c<j+3;c++)
                    {
                        if (boxSet.contains(board[r][c]) && board[r][c]!= '.'){
                            return false;
                         }
                         boxSet.add(board[r][c]);
                    }
                }
            }
        }
        return true;
    }
}
