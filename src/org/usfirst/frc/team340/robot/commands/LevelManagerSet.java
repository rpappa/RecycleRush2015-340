package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team340.robot.subsystems.LevelManager;
//import org.usfirst.frc.team340.robot.subsystems.NoSub;

/**
 *
 */
public class LevelManagerSet extends CommandBase {
	int level;
    public LevelManagerSet(int level) {
    	this.level = level;
    	requires(noSub);
        //requires(levelManager);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	LevelManager.setLevel(level);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
