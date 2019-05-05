package com.lintcode.easy;
public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    // write your code here
    
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    
    private int width;
    private  int height;
    
    public Rectangle(int width ,int height ){
        this.width = width;
        this.height = height;
    }
    
    public int getArea(){
        return width * height;
    }
    
    public static void main(String[] args) {
    	Rectangle r = new Rectangle(3,4);
    	int i = r.getArea();
    	System.out.println(i);
	}
    
}
