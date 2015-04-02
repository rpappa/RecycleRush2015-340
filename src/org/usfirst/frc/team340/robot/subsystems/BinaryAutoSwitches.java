package org.usfirst.frc.team340.robot.subsystems;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BinaryAutoSwitches extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	static DigitalInput a;
	static DigitalInput b;
	
	public BinaryAutoSwitches() {
		a = new DigitalInput(RobotMap.BinarySwitchA);
		b = new DigitalInput(RobotMap.BinarySwitchB);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public int getMode() {
    	if(a.get() && b.get()) {
    		return 0;
    	} else if(a.get() && !b.get()) {
    		return 1;
    	} else if(!a.get() && b.get()) {
    		return 2;
    	} else if(!a.get() && !b.get()) {
    		return 3;
    	}
    	return 0;
    }
}

