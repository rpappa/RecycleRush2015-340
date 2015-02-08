package org.usfirst.frc.team340.robot.commands;

/**
 * Command to move the Stacker mechanism all the way to maximum vertical distance, if a tote is in its control.
 * @author Jakob W.
 */
public class StackerLiftTote extends CommandBase {

    public StackerLiftTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerLiftTote: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[StackerLiftTote: execute] moves up if we have a tote and were not at max");
    	if (stacker.isToteInHand() && !stacker.isStackerMax()) {
    		System.out.println("[StackerLiftTote: execute] moves up");
    		stacker.stackerMoveUp(1.0);
    	}
    	else {
    		System.out.println("[StackerLiftTote: execute] stop moving");
    		stacker.stackerStopVertical();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stacker.isStackerMax();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[StackerLiftTote: end] stop moving");
    	stacker.stackerStopVertical();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[StackerLiftTote: interrupted] stop moving");
    	stacker.stackerStopVertical();
    }
}
