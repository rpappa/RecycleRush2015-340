package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team340.robot.commands.Auto4BarAndDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoMaybe4Bar extends Command {

    public AutoMaybe4Bar() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    Command auto = new Auto4BarAndDrive();

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
	    	if(SmartDashboard.getBoolean("fourBarInAuto")) {
		    	System.out.println("FOUR BAR TRUE");
	    		auto.start();
	    	} else {
	    		System.out.println("NO FOUR BAR");
	    	}
    	} catch(Exception e) {
    		auto.start();
    		System.out.println("FOUR BAR EXCEPITON");
    		System.err.println(e);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	auto.cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	auto.cancel();
    }
}
