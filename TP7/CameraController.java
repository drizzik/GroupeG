package TP7;
import TP4.Vecteur3D;

import TP6.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Mouse;

/**
 * Write a description of class CameraController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CameraController extends Translation
{
    private Vecteur3D position = null;
	private float yaw = 0.0f;
	private float pitch = 0.0f;
	private float x,y,z;
	
	public CameraController(Noeud parent, float _x, float _y, float _z){
	    super(parent,new Vecteur3D(_x,_y,_z));	
	    x = _x;
		y = _y;
		z = _z;
		
	}
	
	public void yaw(float amount){
		yaw += amount;
	}
	
	public void pitch(float amount){
		pitch += amount;
	}
	
	public void walkForward(float distance){
	    x -= distance * (float)Math.sin(Math.toRadians(yaw));
	    z += distance * (float)Math.cos(Math.toRadians(yaw));
	}
	
	public void walkBackwards(float distance){
		x += distance * (float)Math.sin(Math.toRadians(yaw));
		z -= distance * (float)Math.cos(Math.toRadians(yaw));
	}
	
	public void strafeLeft(float distance){
		x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
		z += distance * (float)Math.cos(Math.toRadians(yaw-90));
	}
	
	public void strafeRight(float distance){
		x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
		z += distance * (float)Math.cos(Math.toRadians(yaw+90));
	}
	
	public void lookThrough(){
	GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(x, y, z);
	}
}
