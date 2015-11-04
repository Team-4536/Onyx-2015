package org.usfirst.frc.team4536.robot.commands;

public class RunCamera extends CommandBase {
	
	protected void initialize() {
		requires(camera);
    }
	
    protected void execute() {
    	camera.Begin();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
}
