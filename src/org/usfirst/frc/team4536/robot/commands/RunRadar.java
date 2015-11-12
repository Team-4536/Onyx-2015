package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.Timer;

public class RunRadar extends CommandBase {
	
	Timer time;
	
	double Time;
	
	public RunRadar() {
		requires(gimble);
		requires(ultrasonic);
		requires(frontArm);
        requires(backArm);
        requires(driveTrain);
	}
	
	protected void initialize() {
		time = new Timer();
		time.start();
		gimble.setLatPos(.3);
		gimble.setVertPos(1);
    }
    
    protected void execute() {
    	
    	while (time.get() < 3) {
    		if (ultrasonic.returnValue() <= 20) {
    			if (frontArm.isExtended() == false) {
    			frontArm.extend();
    			}
    			frontArm.setThrottle(.5);
    			if (backArm.isExtended() == true) {
    				backArm.retract();
    			}
    			backArm.setThrottle(-.15);
    		}
    	}
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
    	gimble.setLatPos(0.5);
    	gimble.setVertPos(0.7);
    	while (ultrasonic.returnValue() < 100) {
    		driveTrain.arcadeDrive(0, 0.4);
    	}
    	driveTrain.arcadeDrive(0, 0);
    	Time = time.get();
    	while (time.get() < Time + 1) {
    		frontArm.setThrottle(-0.25);
    		backArm.setThrottle(0.25);
    	}
    	gimble.setLatPos(0.3);
    	gimble.setVertPos(1);
    	while (ultrasonic.returnValue() > 20) {
    		driveTrain.arcadeDrive(0.75, 0);
    	}
    	Time = time.get();
    	while (time.get() < Time + 3) {
    		if (frontArm.isExtended() == false) {
    			frontArm.extend();
    			}
    			frontArm.setThrottle(.5);
    			if (backArm.isExtended() == true) {
    				backArm.retract();
    			}
    			backArm.setThrottle(-.15);
    	}
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
    }
    
    protected boolean isFinished() {
    	return false;
    }
    
    protected void end() {
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
    }
    
    protected void interrupted() {
    }
	
}
