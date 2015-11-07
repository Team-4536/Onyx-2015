package org.usfirst.frc.team4536.robot.commands;

public class GetDistance extends CommandBase {
	
	public GetDistance() {
		requires(ultrasonic);
	}
	
	protected void initialize() {
    }
    
    protected void execute() {
    	ultrasonic.returnValue();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
