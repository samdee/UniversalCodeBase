/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TPARobotDrive extends RobotDrive {
    
    private double m_magnitude;
    private double m_direction;
    private double m_rotation;
    private final TPAJoystick joystick;
    
   public TPARobotDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor, TPAJoystick joystick) {
        super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        this.joystick=joystick;
    }
    
    public void mecanumDrive_Polar() {
        double throttle=(joystick.getZ()- 1) / -2;
        TPALCD.getInstance().println(1, "Speed multiplier: x" + throttle);
        SmartDashboard.putNumber("Speed multiplier", throttle);
        m_magnitude = joystick.getMagnitude() * throttle;
        m_direction = joystick.getDirectionDegrees();
        m_rotation = joystick.getTwist() * throttle;
        
        mecanumDrive_Polar(m_magnitude, m_direction, m_rotation);
    }
}