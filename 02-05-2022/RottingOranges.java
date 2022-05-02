/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/


class Solution {
    public boolean checkCondition(int x,int y,int rows,int cols, int[][] grid){
         if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2){
             return false;
         }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]!=0){
                    freshCount++;
                }
            }
        }
        if(freshCount==0){
            return 0;
        }
        int minTime=0;
        int count=0;
        int[] xDir={0,0,1,-1};
        int[] yDir={1,-1,0,0};
        while(!queue.isEmpty()){
            int size=queue.size();
            count=count+size;
            for(int i=0;i<size;i++){
                int[] pointVal=queue.poll();
                for(int j=0;j<4;j++){
                    int x=pointVal[0]+xDir[j];
                    int y=pointVal[1]+yDir[j];
                    if(!checkCondition(x,y,rows,cols,grid)){
                        continue;
                    }
                    grid[x][y]=2;
                    queue.offer(new int[]{x,y});
                }
            }
            if(queue.size()!=0){
                minTime++;
            }
        }
        if(freshCount==count){
            return minTime;
        }
        return -1;
    }
}

-------------------------------------------------------------------------------------------------------------
TIME COMPLEXITY - O(N*N)
SPACE COMPLEXITY - O(N*N)
