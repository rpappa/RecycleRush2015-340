package org.usfirst.frc.team340.robot.commands;

/**
 * Command  which retracts the tote pushing part of the stacker mechanism.
 * @author Jakob W.
 */
public class StackerRetract extends CommandBase {

    public StackerRetract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerRetract: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (stacker.isStackerOut()) {
    		System.out.println("[StackerRetract: execute] pull in");
    		stacker.stackerIn();
    	}
    	else {
    		System.out.println("[StackerRetract: execute] stop pulling");
    		stacker.stackerStopPusher();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !stacker.isStackerOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[StackerRetract: execute] stop pulling");
    	stacker.stackerStopPusher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[StackerRetract: execute] stop pulling");
    	stacker.stackerStopPusher();
    }
}
