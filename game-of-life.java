/**
 * 原地标记算法    另外还有位运算的方法，后面学习后补
 */
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                board[i][j] = checkPos(board , i , j);
            }
        }
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                board[i][j] = (board[i][j] == 1 || board[i][j] == -2) ? 1 : 0;
            }
        }
    }

    public int checkPos(int[][] board , int i , int j ) {
        int left = Math.max(j - 1 , 0) , right = Math.min(j + 1 ,  board[i].length - 1);
        int count = 0;
        int top = Math.max(i - 1 , 0 ) , bottom = Math.min(i + 1 , board.length - 1);
        for(int x = top; x <= bottom; x++){
            for(int y = left; y <= right; y++){
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1) : (count == 3 ? -2 : 0);
    }
}