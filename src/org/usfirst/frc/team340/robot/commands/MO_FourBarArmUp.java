package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MO_FourBarArmUp extends CommandBase {

    public MO_FourBarArmUp() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fourBar.moveUp();
    	System.out.println("[MO_FourBarArmUp: initalize] Moved FourBar Up");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fourBar.moveUp();
    	System.out.println("[MO_FourBarArmUp: execute] Moved FourBar Up");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_FourBarArmUp: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_FourBarArmUp: end] called");
    }
}
