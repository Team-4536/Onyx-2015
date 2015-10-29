package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasonic extends Subsystem {
	
	AnalogInput ultra;
	double distance;
	
	public void initDefaultCommand() {
	}
	
	public Ultrasonic(int analogIn) {
		ultra = new AnalogInput(analogIn);
	}
	
	public double returnValue() {
		distance = ultra.getValue() / 226.5 * 0.3917 * 12;
		System.out.println(distance);
		return distance;
	}
}
