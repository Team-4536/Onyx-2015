package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Accelerometer extends Subsystem {
	
	BuiltInAccelerometer accel = new BuiltInAccelerometer();
	
	double Xval;
	double Yval;
	double Zval;
	
	double Xvel = 0;
	double Yvel = 0;
	double Zvel = 0;
	
	double Xdist = 0;
	double Ydist = 0;
	double Zdist = 0;
	
	double YInitVal;
	double XInitVal;
	double ZInitVal;
	
	public void initDefaultCommand() {
		
	}
	
	public Accelerometer(int Xinput, int Yinput, int Zinput) {
	}
	
	public void Read() {
		Xval = accel.getX();
		Yval = accel.getY();
		Zval = accel.getZ();
		
		Xval = Xval * 9.8;
		Yval = Yval * 9.8;
		Zval = Zval * 9.8;
		
		
		
		Xval = Xval * 0.02;
		Yval = Yval * 0.02;
		Zval = Zval * 0.02;
		
		Xvel = Xvel + Xval;
		Yvel = Yvel + Yval;
		Zvel = Zvel + Zval;
		
		YInitVal = Yvel;
		XInitVal = Xvel;
		ZInitVal = Zvel;
		
		Xvel = Xvel * 0.02;
		//Yvel = Yvel * 0.02;
		//Zvel = Zvel * 0.02;
		
		//Xvel = Xvel * 10;
		
		Xdist = Xdist + Xvel;
		//Ydist = Ydist + Yvel;
		//Zdist = Zdist + Zvel;
		
		//System.out.println("Y " + YInitVal);
		System.out.println("X " + XInitVal);
		//System.out.println("Z " + ZInitVal);
	}
	
	public void Reset() {
		Xdist = 0;
		Ydist = 0;
		Zdist = 0;
	}
}
