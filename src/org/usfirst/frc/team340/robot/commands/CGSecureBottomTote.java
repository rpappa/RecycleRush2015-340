package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CGSecureBottomTote extends CommandGroup {
    
    public  CGSecureBottomTote() {
    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    	addSequential(new StackerToMin());
    	addSequential(new WaitCommand(.25));
    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    }
}
