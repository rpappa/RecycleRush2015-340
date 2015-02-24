package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.subsystems.FourBarManipulator;

import edu.wpi.first.wpilibj.command.Command;

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
    	if(!fourBar.isMin()){
    		fourBar.moveDown(true);
    	} else {
    		fourBar.stopMovement();
    	}
  	System.out.println("[FourBarSafeDown: execute] Current position: " + fourBar.getPosition() + "    Is min: " + fourBar.isMin() + "    Is max: " + fourBar.isMax());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fourBar.isMin();
    }

    // Called once after isFinished returns true
    protected void end() {
    	fourBar.stopMovement();
    	System.out.println("[FourBarSafeDown: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fourBar.stopMovement();
    	System.out.println("[FourBarSafeDown: interrupted] called");
    }
}
