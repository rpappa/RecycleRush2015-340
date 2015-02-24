package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.subsystems.LevelManager;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CGScoreGarbageBin extends CommandGroup {
    
    public  CGScoreGarbageBin() {
    	addSequential(new MO_FourBarClawClose());
    	addSequential(new FourBarGoToLevel(LevelManager.getLevel(),10));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new MO_FourBarClawOpen());
    }
}
