package com.guaniu.leetcode.adt;

/**
 * @Author: guaniu
 * @Description:
 * @Date: Create in 10:25 2020/12/18
 * @Modified
 */

//200. 岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//此外，你可以假设该网格的四条边均被水包围。
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/number-of-islands
public class L400Solution {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        L400Solution solution = new L400Solution();
        System.out.println(solution.numIsland(grid));
    }

    public int numIsland(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j, int m, int n){
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i, j + 1, m, n);
    }
}
