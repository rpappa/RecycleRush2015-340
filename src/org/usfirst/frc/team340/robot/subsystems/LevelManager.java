package org.usfirst.frc.team340.robot.subsystems;


/**
 * @author Ryan
 */
public class LevelManager {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static int level = 0;;

    public static void setLevel(int lvl) {
    	level = lvl;
    }
    
    public static void incrementLevel() {
    	level++;
    }
    public static void decrementLevel() {
    	level--;
    }
    public static int getLevel() {
    	return level;
    }
}