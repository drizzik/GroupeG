package TP7;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;
import TP6.*;

import java.io.*;
import java.util.Vector;

import java.util.Random;

/**
 * Write a description of class Terrain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Terrain extends Objet
{

    private Noeud m_translationOrigine;
    /**
     * Constructor for objects of class Terrain
     */
    public Terrain(Noeud _parent)
    {
        super(_parent);

        Vecteur3D vecteur0 = new Vecteur3D(0.0f,0.0f,0.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        m_translationOrigine=translation0;

        String textureCube = "/TP7/res/gris2.jpg";

        int dimension = 50;
        int matriceTerrain[][] = new int[dimension][dimension];
        SimplexNoise test = new SimplexNoise();
        // Remplissage de la matrice avec valeurs aléatoires
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){
                // int noise = shittyNoise();
                // int valeurPrec = 0;
                // if (j==0 && i>0)
                // valeurPrec = matriceTerrain[i-1][14];
                // else if (j==0 && i==0)
                // valeurPrec=0;
                // else if (i==0 && j>0)
                // valeurPrec = matriceTerrain[i][j-1];
                // else
                // valeurPrec = Math.abs((matriceTerrain[i][j-1]+matriceTerrain[i-1][j])/2);

                // switch (noise){
                // case 0 : matriceTerrain[i][j] = valeurPrec-2;
                // break;
                // case 1 : matriceTerrain[i][j] = valeurPrec-1;
                // break;
                // case 2 : matriceTerrain[i][j] = valeurPrec;
                // break;
                // case 3 : matriceTerrain[i][j] = valeurPrec+1;
                // break;
                // case 4 : matriceTerrain[i][j] = valeurPrec+2;
                // break;
                //}   

                float res = test.noise((float)i/30.0f,(float)j/30.0f);
                //System.out.println(res);
                matriceTerrain[i][j] = (int)(res*10);
                //System.out.println(matriceTerrain[i][j]);
            }
        }

        // Affichage des cubes
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){
                float hauteur = (float)matriceTerrain[i][j];

                Vecteur3D vecteur1 = new Vecteur3D(15-2*i,hauteur,15-2*j);
                Transformation translation1 = new Translation(translation0, vecteur1);
                CubeFilDeFer cube = new CubeFilDeFer(translation1);
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void dessine()
    {
        m_translationOrigine.affiche();
    }

    /**
     * 
     */
    public int shittyNoise()
    {
        double alea = Math.random() * 120; // random entre 0 et 100
        int niveau = 0;
        if (alea >= 0 && alea <= 15)
            niveau = 0;
        else if (alea > 15  && alea <= 40)
            niveau = 1;
        else if (alea > 40 && alea <= 80)
            niveau = 2;
        else if (alea > 80 && alea <= 105)
            niveau = 3;
        else if (alea > 105 && alea <= 120)
            niveau = 4;

        return niveau;
    }
}
