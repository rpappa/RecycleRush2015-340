package org.usfirst.frc.team340.robot.commands;

/**
 * Command which will, if there is a tote in the stacker hand, move the stacker down until the tote is realeased or the minimum range of motion is reached.
 * @author Jakob W.
 */
public class StackerReleaseTote extends CommandBase {

    public StackerReleaseTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.println("[StackerReleaseTote: initialize] ");

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (/*stacker.isToteInHand() &&*/ !stacker.isStackerMin()) {
    		System.out.println("[StackerReleaseTote: execute] Move Stacker Down");
    		stacker.stackerMoveDown(.5);
    	}
    	else {
    		System.out.println("[StackerReleaseTote: execute] Stop Stacker Movement");
    		stacker.stackerStopVertical();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (/*!stacker.isToteInHand() ||*/ stacker.isStackerMin());
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println("[StackerReleaseTote: end] Stop Stacker Movement");
    	stacker.stackerStopVertical();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		System.out.println("[StackerReleaseTote: interrupted] Stop Stacker Movement");
    	stacker.stackerStopVertical();
    }
}
