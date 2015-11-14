package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc.team4536.robot.commands.*;

public class TurnCatchCommandgroup extends CommandGroup {
	
	Command turnCatch;
	
	public TurnCatchCommandgroup() {
		
	}
	
	protected void initialize() {
		turnCatch = new TurnCatch();
    }
    
    protected void execute() {
    	turnCatch.start();
    	turnCatch.start();
    	turnCatch.start();
    	turnCatch.start();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
