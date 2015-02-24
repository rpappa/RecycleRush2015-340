package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBackup extends CommandGroup {
    
    public  AutoBackup() {
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
    	addParallel(new MO_FourBarClawOpen());
    	addParallel(new StackerToMin());
    	addSequential(new FourBarSafeDown(), 2);
    	addSequential(new DriveStraight(.75,3));
    	addParallel(new MO_FourBarClawClose());
    	addSequential(new StackerGrabTote(2));
    	addSequential(new DriveTurn(.5, .5, 10));
    	addSequential(new DriveStraight(.5,2.5));
    }
}
