/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
Constraints:
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
*/

class Solution {
    public int closedIsland(int[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int numOfClosedIslands=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    if(dfs(i,j,row,col,grid)){
                        numOfClosedIslands++;
                    }
                }
            }
        }
        return numOfClosedIslands;
    }
    public static boolean checkBoundary(int i,int j,int row,int col){
        boolean res= i==0 || j==0 || i==row-1 || j==col-1;
        return res;
    }
    public static boolean dfs(int i,int j,int row,int col,int[][] grid){
        if(grid[i][j]==2 || grid[i][j]==1){
            return true;
        }
        if(checkBoundary(i,j,row,col)){
            return false;
        }
        
        //visited
        grid[i][j]=2;
        boolean leftDir=dfs(i,j-1,row,col,grid);
        boolean rightDir=dfs(i,j+1,row,col,grid);
        boolean upDir=dfs(i-1,j,row,col,grid);
        boolean downDir=dfs(i+1,j,row,col,grid);
        boolean ans=leftDir&rightDir&upDir&downDir;
        return ans;
    }
}
