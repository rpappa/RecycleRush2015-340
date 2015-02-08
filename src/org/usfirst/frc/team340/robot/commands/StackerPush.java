package org.usfirst.frc.team340.robot.commands;

/**
 * Command which pushes out the tote stack from the stacker mechanism.
 * @author Jakob W.
 */
public class StackerPush extends CommandBase {

    public StackerPush() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerPush: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!stacker.isStackerOut()) {
    		System.out.println("[StackerPush: execute] push out");
    		stacker.stackerOut();
    	}
    	else {
    		System.out.println("[StackerPush: execute] stop pushing");
    		stacker.stackerStopPusher();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stacker.isStackerOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[StackerPush: end] stop pushing");
    	stacker.stackerStopPusher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[StackerPush: interrupted] stop pushing");
    	stacker.stackerStopPusher();
    }
}
