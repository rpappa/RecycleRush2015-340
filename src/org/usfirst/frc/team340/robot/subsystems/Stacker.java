
package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	
    //Stacker sensors
	Encoder heightSensor;
	DigitalInput minimumSensor;
	
	//Stacker variables
	int maxStackerHeight = RobotMap.StackerMaxHeight;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Stacker() {
		verticalStackerMotor = new Talon(RobotMap.StackerVertical);

		heightSensor = new Encoder(RobotMap.StackerHeightEncoder1, RobotMap.StackerHeightEncoder2);
		minimumSensor = new DigitalInput(RobotMap.StackerMinimumSensor);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void stackerMoveUp(double speed) {
    	if(speed < 0){
    		speed = -speed;
    	}
    	/*if (this.isStackerMax()) {
    		verticalStackerMotor.set(0);
    	}else{*/
    		verticalStackerMotor.set(speed);
    		System.out.println("Stacker Encoder: " + heightSensor.get());
    	//}
    }
    
    public void stackerMoveDown(double speed) {
    	if(speed < 0){
    		speed = -speed;
    	}
    	/*if (this.isStackerMin()) {
    		verticalStackerMotor.set(0);
    	}else{*/
    		verticalStackerMotor.set(-speed);
    		System.out.println("Stacker Encoder: " + heightSensor.get());
//    	}
    }
    
    public void stackerStopVertical() {
    	verticalStackerMotor.set(0);
    }
    
    public int getStackerPosition() {
    	SmartDashboard.putNumber("StackerHeightSensor", heightSensor.get());
    	return heightSensor.get();
    }
    
    public boolean isStackerMax() {
    	SmartDashboard.putBoolean("isMax",(heightSensor.get() >= maxStackerHeight));
    	return heightSensor.get() >= maxStackerHeight;
    }
    
    public boolean isStackerMin() {
    	SmartDashboard.putBoolean("StackerMin", minimumSensor.get());
    	if (minimumSensor.get()) {
    		heightSensor.reset();
    		return true;
    	}
    	return false;
    }
    
}
