package com.offer.test;

/**  
 * 
 * 矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 
 * @author zhouwenchen@021.com  
 * @date 2019年6月14日 下午7:39:30 
 */
public class StringPathInMatrix {
	
	public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
		// 1.参数的合法性检验
		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		
		// 定义已经访问的矩阵，并初始化为false
		boolean[] isVisited = new boolean[rows*cols];
//		for(boolean b : isVisited){
//			b = false;
//		}
		int pathLenght = 0;
		// 遍历二维矩阵
		for(int row = 0;row < rows;row++){
			for(int col = 0; col < cols;col++){
				if (hasMore(matrix, rows, row, cols, col, str, pathLenght, isVisited)){
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * 判断是否还有路径
	 */
	private static boolean hasMore(char[] matrix, int rows, int row, int cols, int col, char[] str, int pathLenght, boolean[] isVisited) {
		if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col] == true || str[pathLenght] != matrix[row * cols + col]) {
			return false;
		}
		if(pathLenght == str.length-1){
			return true;
		}
		boolean hasPath = false;
		isVisited[row*cols+col] = true;
		hasPath = hasMore(matrix, rows, row - 1, cols, col, str, pathLenght + 1, isVisited)
				|| hasMore(matrix, rows, row + 1, cols, col, str, pathLenght + 1, isVisited)
				|| hasMore(matrix, rows, row, cols, col - 1, str, pathLenght + 1, isVisited)
				|| hasMore(matrix, rows, row, cols, col + 1, str, pathLenght + 1, isVisited);
		
		if(!hasPath){
			isVisited[row*cols+col] = false;
		}
		return hasPath;
	}
	
	public static void main(String[] args) {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "BFCE".toCharArray();
		boolean b = hasPath(matrix, rows, cols, str);
		System.out.println(b);
	}
}
