package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.Timer;

public class Catch extends CommandBase {
	
	Timer time;
	
	double Time;
	
	boolean running;
	
	public Catch() {
		requires(gimble);
		requires(ultrasonic);
		requires(frontArm);
        requires(backArm);
	}
	
	protected void initialize() {
		time = new Timer();
		running = true;
		gimble.setLatPos(.2);
		gimble.setVertPos(.8);
    }
    
    protected void execute() {
    	time.reset();
    	time.start();
    	gimble.setLatPos(.2);
		gimble.setVertPos(.8);
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
    	while (ultrasonic.returnValue() > 20) {
    	}
    	Time = time.get();
    	while (time.get() < Time + 2) {
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
		Time = time.get();
		while (time.get() < Time + 1) {
		}
    	Time = time.get();
    	while (time.get() < Time + 2) {
    		frontArm.setThrottle(-.4);
    		backArm.setThrottle(.4);
    	}
    	running = false;
    }
    
    protected boolean isFinished() {
    	return false;
    }
    
    protected void end() {
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
		time.reset();
		running = false;
    }
    
    protected void interrupted() {
    	end();
    }
	
}
