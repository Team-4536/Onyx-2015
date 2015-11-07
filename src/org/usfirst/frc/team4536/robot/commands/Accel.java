package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class Accel extends CommandBase {
	
	public Accel() {
		requires(accelerometer);
	}
	
	protected void initialize() {
		
    }
    
    protected void execute() {
    	accelerometer.Read();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	accelerometer.Reset();
    }
    
    protected void interrupted() {
    }
	
}
