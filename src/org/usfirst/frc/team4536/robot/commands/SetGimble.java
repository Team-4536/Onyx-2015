package org.usfirst.frc.team4536.robot.commands;

public class SetGimble extends CommandBase {
	
	public SetGimble() {
		requires(gimble);
	}
	
	protected void initialize() {
    }
    
    protected void execute() {
    	gimble.setLatPos(0.3);
    	gimble.setVertPos(1);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
