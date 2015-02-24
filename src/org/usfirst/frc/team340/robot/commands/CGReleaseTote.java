package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGReleaseTote extends CommandGroup {
    
    public  CGReleaseTote() {
    	addSequential(new MO_FourBarClawOpen());
    	addSequential(new FourBarToMax());
//    	addSequential(new DriveStraight(-1, 5));
    }
}
