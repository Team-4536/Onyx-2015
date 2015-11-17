package org.usfirst.frc.team4536.robot.commands;

public class SetGimble extends CommandBase {
	
	public SetGimble() {
		requires(gimble);
	}
	
	protected void initialize() {
    }
    
    protected void execute() {
    	gimble.setLatPos(0);
    	gimble.setVertPos(.6);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
