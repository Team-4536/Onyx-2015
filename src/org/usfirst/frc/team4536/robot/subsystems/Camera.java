package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera extends Subsystem {
	
	CameraServer cam;
	
	public Camera() {
		
	}
	
	public void initDefaultCommand() {
    }
	
	public void Begin() {
		cam.startAutomaticCapture();
	}
	
}
