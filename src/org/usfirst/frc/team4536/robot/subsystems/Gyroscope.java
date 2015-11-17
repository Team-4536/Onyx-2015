package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyroscope extends Subsystem{
	
	Gyro gyro;
	
	double position;
	double rate;
	
	public void initDefaultCommand() {
		
	}
	
	public Gyroscope(int channel) {
		gyro = new Gyro(channel);
		position = 0;
	}
	
	public double getPos() {
		position = gyro.getAngle();
		if (position > 180) {
			position = position - 360;
		}
		else if (position < -180) {
			position = position + 360;
		}
		return position;
	}
	
	public void reset() {
		gyro.reset();
	}
	
	public double getRate() {
		rate = gyro.getRate();
		if (rate < 0) {
			rate = -rate;
		}
		return rate;
	}
	
}
