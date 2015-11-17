package org.usfirst.frc.team4536.robot.commands;

public class GetAngle extends CommandBase {
	
	double angle;
	
	public GetAngle() {
		requires(gyro);
	}
	
	protected void initialize() {
    }
    
    protected void execute() {
    	angle = gyro.getPos();
    	System.out.println(angle);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	gyro.reset();
    }
    
    protected void interrupted() {
    	end();
    }
	
}
