package TP7;

import TP4.Vecteur3D;

import TP6.*;

import org.lwjgl.input.Keyboard;

/**
 * Write a description of class DeplacementTerrain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeplacementTerrain extends Translation
{
    
    /**
     * Constructor for objects of class DeplacementTerrain
     */
    public DeplacementTerrain(Noeud _parent, Vecteur3D _coordonnees)
    {
        super(_parent, _coordonnees);
    }
    
    public void transforme(){
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX(),coordsReelles.getY(),coordsReelles.getZ()+0.5f);
            this.setCoordonnes(coordsNouvelles);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX()+0.5f,coordsReelles.getY(),coordsReelles.getZ());
            this.setCoordonnes(coordsNouvelles);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX(),coordsReelles.getY(),coordsReelles.getZ()-0.5f);
            this.setCoordonnes(coordsNouvelles);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX()-0.5f,coordsReelles.getY(),coordsReelles.getZ());
            this.setCoordonnes(coordsNouvelles);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX(),coordsReelles.getY()+0.5f,coordsReelles.getZ());
            this.setCoordonnes(coordsNouvelles);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            Vecteur3D coordsReelles = this.getCoordonnees();
            Vecteur3D coordsNouvelles = new Vecteur3D(coordsReelles.getX(),coordsReelles.getY()-0.5f,coordsReelles.getZ());
            this.setCoordonnes(coordsNouvelles);
        }
        super.transforme();
    }
    
}
