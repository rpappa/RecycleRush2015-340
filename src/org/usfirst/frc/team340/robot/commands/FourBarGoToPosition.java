package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

/**
 * Command to send the Four Bar arm to a specific position
 * @author Dayle
 */
public class FourBarGoToPosition extends CommandBase {

    private int target;
	private int tolerance;
	private int initDelta;
	private int start;
	private int currentPos;
	private double percent;
	private double speed;

	public FourBarGoToPosition(int position, int tolerance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(fourBar);
    	this.target = position;
    	this.tolerance = tolerance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentPos = fourBar.getPosition();
    	start = fourBar.getPosition();
    	initDelta = target - start;
    	percent = 0.1;
    	speed = RobotMap.FourBarUpSpeed;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPos = fourBar.getPosition();
    	speed = RobotMap.FourBarUpSpeed;
    	
    	if ((Math.abs(currentPos) <= (Math.abs(target) + tolerance)) 
    			&& (Math.abs(currentPos) >= Math.abs(target) - tolerance)
    			&& (!fourBar.isMin() || !fourBar.isMax())) {
    		fourBar.stopMovement();
    		speed = 0;
		}
    	// Checks to see if we are within a percentage from the target position.
    	else if ((Math.abs(currentPos) >= (Math.abs(target) - (Math.abs(initDelta) * percent)))
    			&& (!fourBar.isMin() || !fourBar.isMax())) {
    		speed =1 * 0.5;
    	}
    	// If the stacker is not close to or at the position the stacker moves moves at full speed.
    	else{
    		speed = 1;
    	}
 
    	// current delta.
    	int currDelta = currentPos - target;
    	
    	//if delta is positive then move up
    	if(currDelta > 0 && speed != 0){
    		fourBar.moveUp();
    	}
    	// if delta is negative move down.
    	else if (currDelta < 0 && speed != 0) {
    		fourBar.moveDown(true);
		}
    	// Tells the stacker to stop if it should not move up or down.
    	else{
    		fourBar.stopMovement();
    	}
    	System.out.println("[FourBarGoToPosition: execute] slowed down before getting to position to stop:"
    			+ " currentPosVal: " + this.currentPos 
    			+ "targetVal: " + this.target 
    			+ "toleranceVal: " + this.tolerance 
    			+ "initDeltaVal: " + this.initDelta 
    			+ "percentVal: " + this.percent
    			+ "currDeltaVal: " + currDelta);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((fourBar.getPosition() > (target-tolerance)) && (fourBar.getPosition() < (target+tolerance)));
    }

    // Called once after isFinished returns true
    protected void end() {
    	fourBar.stopMovement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fourBar.stopMovement();
    }
}
