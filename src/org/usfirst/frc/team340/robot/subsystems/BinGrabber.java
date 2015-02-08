package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem which contains all the methods relating to the Bin Grabber mechanism.
 * @author Dayle
 */
public class BinGrabber extends Subsystem {
    Talon moveCim;
//    Talon moveSim2;
    
    Solenoid openClose;
    
    DigitalInput armDown;
    DigitalInput armUp;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	

    public BinGrabber() {
         moveCim= new Talon(RobotMap.BinGrabberMoveSim1);
//         moveSim2 = new Talon(RobotMap.BinGrabberMoveSim2);
         openClose = new Solenoid(RobotMap.BinGrabberOpenClose);
         armDown = new DigitalInput(RobotMap.BinGrabberArmDown);
         armUp = new DigitalInput(RobotMap.BinGrabberArmUp);
    }
    public void lowerGrabber(double speed) {
    	moveCim.set(-speed);
//    	moveSim2.set(-speed);
    }
    public void raiseGrabber(double speed) {
    	moveCim.set(speed);
//    	moveSim2.set(speed);
    }
    public void expandGrabber() {
    	openClose.set(true);
    }
    public void contractGrabber() {
    	openClose.set(false);
    }
    public boolean isBinGrabbed() {
    	return false;
    }
    public boolean isGrabberLowered() {
    	return armDown.get();
    }
    public boolean isGrabberRaised() {
    	return armUp.get();
    }
	public void stopMoving() {
		moveCim.set(0);
//		moveSim2.set(0);
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
