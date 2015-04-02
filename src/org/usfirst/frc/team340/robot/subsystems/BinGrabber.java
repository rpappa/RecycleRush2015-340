package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem which contains all the methods relating to the Bin Grabber mechanism.
 * @author Dayle
 */

public class BinGrabber extends Subsystem {
//    Relay moveMotor;
//    Talon moveSim2;
    Talon move;
    
    Solenoid openClose;
    
    DoubleSolenoid inOut;
    DoubleSolenoid upDown;
    
    DigitalInput armDown;
    DigitalInput armUp;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //Eat Shit!
	

    public BinGrabber() {
    	move= new Talon(RobotMap.BinGrabberMove);
//         moveCim= new Talon(RobotMap.BinGrabberMoveCim1);
         openClose = new Solenoid(RobotMap.BinGrabberOpenClose);
         inOut = new DoubleSolenoid(RobotMap.BinGrabberArmIn, RobotMap.BinGrabberArmOut);
         upDown = new DoubleSolenoid(RobotMap.BinGrabberLiftUp, RobotMap.BinGrabberLiftDown);
//         armDown = new DigitalInput(RobotMap.BinGrabberArmDown);
//         armUp = new DigitalInput(RobotMap.BinGrabberArmUp);
    }
    //kForward = in  && kReverse = out
    //inOut = long Cylinder && upDown = short Cylinder
    public void lowerHook(){
    	move.set(RobotMap.BinGrabberDownSpeed);
    }
    public void raiseHook() {
    	move.set(RobotMap.BinGrabberUpSpeed);
	}
    
    public void lowerGrabber() {
    	inOut.set(Value.kReverse);
    	upDown.set(Value.kForward);
//    	moveSim2.set(-speed);
    }
    public void midGrabber() {
    	inOut.set(Value.kForward);
    	upDown.set(Value.kForward);
    }
    public void raiseGrabber() {
    	inOut.set(Value.kForward);
    	upDown.set(Value.kReverse);
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
//		moveMotor.set(Relay.Value.kOff);
		move.set(0);
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}