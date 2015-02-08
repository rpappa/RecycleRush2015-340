package org.usfirst.frc.team340.robot.commands;

/**
 * Command which will send the stacker arm to its maximum position.
 * @author Jakob W.
 */
public class StackerToMax extends CommandBase {

    public StackerToMax() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerToMax: Initialize]");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[StackerToMax: execute] encoderVal "+stacker.getStackerPosition());
    	if (!stacker.isStackerMax()) {
    		stacker.stackerMoveUp(1.0);
    		System.out.println("[StackerToMax: execute] moving up");
    	}
    	else {
    		stacker.stackerStopVertical();
    		System.out.println("[StackerToMax: execute] stop moving");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stacker.isStackerMax();
    }

    // Called once after isFinished returns true
    protected void end() {
    	stacker.stackerStopVertical();
    	System.out.println("[StackerToMax: end] stop moving");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	stacker.stackerStopVertical();
    	System.out.println("[StackerToMax: interrupted]stop moving");
    }
}
