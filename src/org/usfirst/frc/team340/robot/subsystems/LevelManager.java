package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Ryan
 */
public class LevelManager {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static int level;

	public LevelManager() {
		level = 0;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
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