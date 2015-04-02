package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoGetBins extends CommandGroup {
	
	public  AutoGetBins() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
//    	addSequential(new DriveStraight(-.3,5));
    	addParallel(new StackerToMin(), 4);
//    	addSequential(new DriveStraight(-.3, 30), .4);
    	addSequential(new BinGrabberInitialRelease(.4), .4);
    	addSequential(new WaitCommand(2.5), 2.5);
    	addSequential(new DriveStraight(-.3, 30), .4);
    	addSequential(new WaitCommand(.5), .5);
//    	addSequential(new DriveStraight(-.3, 30), .4);
    	
//    	addSequential(new DriveStraight(-.3, 30), .15);
//    	addSequential(new WaitCommand(.25), .5);
    	addSequential(new DriveStraight(.3, 30), .4);
    	addSequential(new AutoWiggle(), 2);
//    	addSequential(new WaitCommand(.5), .5);
//    	addSequential(new AutoWiggle(), 5);
//    	addSequential(new WaitCommand(1), 1);
    	addSequential(new DriveNoEncoders(1), .75);
    	addSequential(new DriveNoEncoders(-.75), .25);
//    	addSequential(new BinGrabberUp(), 7);
    	addSequential(new AutoMaybe4Bar(), 10);
//    	addSequential(new MO_BinGrabberContractGrabber());
//    	addSequential(new MO_BinGrabberTop());
    }
}
