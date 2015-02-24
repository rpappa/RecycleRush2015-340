package org.usfirst.frc.team340.robot.commands;

/**
 * Command Which will send four bar manipulator to min.
 *@author Kyle W.
 */
public class FourBarToMin extends CommandBase {

    public FourBarToMin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(fourBar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.println("[FourBarToMin: initialize] Move FourBar Down");		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!fourBar.isMin()) {
    		System.out.println("[FourBarToMin: execute] Move FourBar Down");
    		fourBar.moveDown(true);
    	} else {
    		fourBar.stopMovement();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fourBar.isMin();
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println("[FourBarToMin: end] stop movement of the four bar");
    	fourBar.stopMovement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		System.out.println("[FourBarToMin: interrupted] stop movement of the fourbar");
    	fourBar.stopMovement();
    }
}
