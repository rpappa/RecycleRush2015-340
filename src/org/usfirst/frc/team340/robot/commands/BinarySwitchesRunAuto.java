package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BinarySwitchesRunAuto extends CommandBase {
	int autoMode;
    Command auto1;
    Command auto2;
    Command auto3;
    Command auto4;
    public BinarySwitchesRunAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binaryAutoSwitches);
    	auto1 = new AutoMobility();
        auto2 = new AutoMobilityLonger();
        auto3 = new AutoGetBins();
        auto4 = new Auto4BarStillBinGrab();
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
    		autoMode = binaryAutoSwitches.getMode();
    	} catch (Exception e) {
    		SmartDashboard.putBoolean("autoException", true);
    		System.err.println(e);
    	}
    	/*switch (autoMode) {
		case 0:
			break;
		case 1:
			auto1.start();
			SmartDashboard.putNumber("auto", 1);
			break;
		case 2:
			auto2.start();
			SmartDashboard.putNumber("auto", 2);
			break;
		case 3:
			auto3.start();
			SmartDashboard.putNumber("auto", 3);
			break;
		case 4:
			auto4.start();
			SmartDashboard.putNumber("auto", 4);
			break;*/
    	System.out.println(autoMode);
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
    	auto1.cancel();
    	auto2.cancel();
    	auto3.cancel();
    	auto4.cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	auto1.cancel();
    	auto2.cancel();
    	auto3.cancel();
    	auto4.cancel();
    }
}
