package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FourBarSafeUp extends CommandBase {

    public FourBarSafeUp() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[FourBarSafeUp: execute] Current position: " + fourBar.getPosition() + "    Is min: " + fourBar.isMin() + "    Is max: " + fourBar.isMax());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!fourBar.isMax()){
    	    fourBar.moveUp();
    	} else {
    		fourBar.stopMovement();
    	}
    	System.out.println("[FourBarSafeUp: execute] Current position: " + fourBar.getPosition() + "    Is min: " + fourBar.isMin() + "    Is max: " + fourBar.isMax());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fourBar.isMax();
    }

    // Called once after isFinished returns true
    protected void end() {
    	fourBar.stopMovement();
    	System.out.println("[FourBarSafeUp: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fourBar.stopMovement();
    	System.out.println("[FourBarSafeUp: end] called");
    }
}