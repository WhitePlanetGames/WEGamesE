package ca.WEGames.BOT.level;

public class Coordinate {
    private int x, z;
    public Coordinate(int x, int z) {
    	this.x = x;
    	this.z = z;
    }
    public int getX(){
    	return x;
    }
    public int getZ(){
    	return z;
    }
    public void setX(int x){
    	this.x = x;
    }
    public void setZ(int z){
    	this.z = z;
    }
    public void set(int x, int z){
    	this.x = x;
    	this.z = z;
    }
}