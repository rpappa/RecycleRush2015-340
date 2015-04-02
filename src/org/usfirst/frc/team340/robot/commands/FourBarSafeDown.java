package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;


/**
 *
 */
public class FourBarSafeDown extends CommandBase {

    public FourBarSafeDown() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[FourBarSafeDown: initialize] Move FourBar Down");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(fourBar.isFailedTest()){
        	oi.coDriverRumbleOn();
    	}
    	if(!fourBar.isLeftDown()){
    		fourBar.driveLeftMotor(RobotMap.FourBarDownSpeed);
    	} else {
    		fourBar.driveLeftMotor(0);
    	}
    	if(!fourBar.isRightDown()) {
    		fourBar.driveRightMotor(RobotMap.FourBarDownSpeed);
    	} else {
    		fourBar.driveRightMotor(0);
    	}
    	if (fourBar.isRightDown() && fourBar.isLeftDown()){
    		fourBar.stopMovement();
    	}
    	System.out.println("FourBar position: " + fourBar.getPosition());
    	/*System.out.println("[FourBarSafeDown: execute] Current position Left: " + fourBar.getPositionLeft() +
  			"Current position Right: " + fourBar.getPositionRight() + 
  			"    Is min: " + fourBar.isMin() + 
  			"    Is max: " + fourBar.isMax());*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fourBar.isLeftDown()&&fourBar.isRightDown();
    }

    // Called once after isFinished returns true
    protected void end() {
    	fourBar.stopMovement();
    	oi.coDriverRumbleOff();
    	System.out.println("[FourBarSafeDown: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fourBar.stopMovement();
    	oi.coDriverRumbleOff();
    	System.out.println("[FourBarSafeDown: interrupted] called");
    }
}
