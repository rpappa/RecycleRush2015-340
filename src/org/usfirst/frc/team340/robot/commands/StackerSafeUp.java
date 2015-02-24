package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

/**
 * Manually moves the stacker up safely
 * @author Dayle && Pappa
 */
public class StackerSafeUp extends CommandBase {

    public StackerSafeUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("[StackerSafeUp: initalize] Called :" + stacker.getStackerPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!stacker.isStackerMax()){
    		stacker.stackerMoveUp(RobotMap.StackerUpSpeed);
    	}
    	else {
			stacker.stackerStopVertical();
		}
        System.out.println("[StackerSafeUp: execute] Called :" + stacker.getStackerPosition());
        System.out.println("Is max: " + stacker.isStackerMax() + "	Is min: " + stacker.isStackerMin());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stacker.isStackerMax();
    }

    // Called once after isFinished returns true
    protected void end() {
    	stacker.stackerStopVertical();
        System.out.println("[StackerSafeUp: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	stacker.stackerStopVertical();
        System.out.println("[MO_StackerUp: interrupted] called");
    }
}
