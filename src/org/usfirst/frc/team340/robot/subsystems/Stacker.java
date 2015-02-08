package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team340.robot.RobotMap;

/**
 * Subsystem containing all methods that relate to the Stacker mechanism.
 * @author Jakob W.
 */
public class Stacker extends Subsystem {
    
	//Stacker motors
    Talon verticalStackerMotor;
//	Talon verticalStackerMotor2 = new Talon(8);
	//Solenoids
	Solenoid stackerStackerInOut;
	//Stacker sensors
	Encoder heightSensor;
	DigitalInput minimumSensor;
	DigitalInput toteSensor;
	//Stacker variables
	int maxStackerHeight = 360;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Stacker() {
		verticalStackerMotor = new Talon(RobotMap.StackerVertical);
//		verticalStackerMotor2 = new Talon(8);
	 	stackerStackerInOut = new Solenoid(RobotMap.StackerInOut);
		
		heightSensor = new Encoder(RobotMap.StackerHeightEncoder1, RobotMap.StackerHeightEncoder2);
		minimumSensor = new DigitalInput(RobotMap.StackerMinimumSensor);
		toteSensor = new DigitalInput(RobotMap.StackerToteSensor);
		
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void stackerIn() {
    	
    }
    
    public void stackerOut() {
    	
    }
    
    public void stackerStopPusher() {
    	
    }
    
    public boolean isStackerOut() {
    	return toteSensor.get();
    }
    
    public void stackerMoveUp(double speed) {
    	verticalStackerMotor.set(-speed);
//    	verticalStackerMotor2.set(-speed);
    }
    
    public void stackerMoveDown(double speed) {
    	verticalStackerMotor.set(speed);
//    	verticalStackerMotor2.set(speed);
    	if (this.isStackerMin()) {
    		heightSensor.reset();
    	}
    }
    
    public void stackerStopVertical() {
    	verticalStackerMotor.set(0);
//    	verticalStackerMotor2.set(0);
    }
    
    public int getStackerPosition() {
    	return heightSensor.get();
    }
    
    public boolean isStackerMax() {
    	return heightSensor.get() >= maxStackerHeight;
    }
    
    public boolean isStackerMin() {
    	if (minimumSensor.get()) {
    		heightSensor.reset();
    		return true;
    	}
    	return false;
    }
    
    public boolean isToteInHand() {
    	return toteSensor.get();
    }
}
