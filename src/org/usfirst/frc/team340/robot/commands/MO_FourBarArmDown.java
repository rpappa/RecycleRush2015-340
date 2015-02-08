package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.subsystems.FourBarManipulator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MO_FourBarArmDown extends CommandBase {

    public MO_FourBarArmDown() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fourBar.moveDown();
    	System.out.println("[MO_FourBarArmDown: initialize] Move FourBar Down");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fourBar.moveDown();
    	System.out.println("[MO_FourBarArmDown: execute] Move FourBar Down");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_FourBarArmDown: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_FourBarArmDown: interrupted] called");
    }
}
