package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

/**
 * Manually moves the stacker intake down
 * @author Tai
 */
public class MO_StackerDown extends CommandBase{

    public MO_StackerDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stacker.stackerMoveDown(RobotMap.StackerDownSpeed);
        System.out.println("[MO_StackerMoveDown: initialize] called :" + stacker.getStackerPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("[MO_StackerMoveDown: execute] called :" + stacker.getStackerPosition());
        System.out.println("Is max: " + stacker.isStackerMax() + "	Is min: " + stacker.isStackerMin());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("[MO_StackerMoveDown: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("[MO_StackerMoveDown: interupted] called");
    }
}
