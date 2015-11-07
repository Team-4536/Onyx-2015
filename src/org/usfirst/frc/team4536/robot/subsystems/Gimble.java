package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gimble extends Subsystem{
	
	Servo servoLat;
	Servo servoVert;
	
	public void initDefaultCommand() {
		
	}
	
	public Gimble(int latChan, int vertChan) {
		servoLat = new Servo(latChan);
		servoVert = new Servo(vertChan);
	}
	
	public void setLatPos(double latPos) {
		servoLat.setPosition(latPos);
	}
	
	public void setVertPos(double vertPos) {
		servoVert.setPosition(vertPos);
	}
	
}
