
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

    Vecteur3D vecteur0;
    Transformation translation0;

    int dimension;
    int matriceTerrain[][];
    /**
     * Constructor for objects of class Terrain
     */
    public Terrain(Noeud _parent)
    {
        super(_parent);

        vecteur0 = new Vecteur3D(0.0f,0.0f,0.0f);
        translation0 = new Translation(this, vecteur0);
        m_translationOrigine=translation0;

        String textureCube = "/TP7/res/gris2.jpg";

        dimension = 50;
        matriceTerrain = new int[dimension][dimension];
        SimplexNoise test = new SimplexNoise();
        // Remplissage de la matrice avec valeurs aléatoires
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){

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

                //Vecteur3D vecteur1 = new Vecteur3D(dimension-2*i,hauteur,dimension-2*j);
                Vecteur3D vecteur1 = new Vecteur3D(dimension-2*i-1,hauteur,dimension-2*j-1);
                Transformation translation1 = new Translation(translation0, vecteur1);
                CubeCouleur cube = new CubeCouleur(translation1, new Vecteur3D(0.964f, 0.803f, 0.505f));
                CubeFilDeFer contour = new CubeFilDeFer(translation1);

                boolean cubeWithTree = treeGeneration();
                if (cubeWithTree)
                {
                    Vecteur3D vecteurTree = new Vecteur3D(1.0f,0.0f,-1.0f);
                    Transformation translationTree = new Translation(translation1, vecteurTree);
                    Arbre arbre1 = new Arbre(translationTree);
                }
            }
        }

        Vecteur3D vecteur1 = new Vecteur3D(dimension-2*25-1,10,dimension-2*25-1);
        Transformation translation1 = new Translation(translation0, vecteur1);
        CubeCouleur cube = new CubeCouleur(translation1, new Vecteur3D(0.0f, 0.0f, 0.0f));

        Vecteur3D vecteur3= new Vecteur3D(dimension-2*24-1,10,dimension-2*24-1);
        Transformation translation3 = new Translation(translation0, vecteur3);
        CubeCouleur cube3 = new CubeCouleur(translation3, new Vecteur3D(0.0f, 0.0f, 0.0f));

        Vecteur3D vecteur4 = new Vecteur3D(dimension-2*24-1,10,dimension-2*25-1);
        Transformation translation4 = new Translation(translation0, vecteur4);
        CubeCouleur cube4 = new CubeCouleur(translation4, new Vecteur3D(0.0f, 0.0f, 0.0f));

        Vecteur3D vecteur5 = new Vecteur3D(dimension-2*25-1,10,dimension-2*24-1);
        Transformation translation5 = new Translation(translation0, vecteur5);
        CubeCouleur cube5 = new CubeCouleur(translation5, new Vecteur3D(0.0f, 0.0f, 0.0f));

        Vecteur3D vecteur2 = new Vecteur3D(0.0f,12,0.0f);
        Transformation translation2 = new Translation(translation0, vecteur2);
        CubeCouleur cube2 = new CubeCouleur(translation2, new Vecteur3D(1.0f, 1.0f, 1.0f));
    }

    public void spawnBlock(float _posx, float _posz)
    {
        // System.out.println(_posx);
        // System.out.println(_posz);
        // System.out.println("------------");
        System.out.println((int)(dimension-1-_posx)/2);
        System.out.println((int)(dimension-1-_posz)/2);
        System.out.println("-------------------------------------");
        // int realPosX = Math.round(_posx+_posx/2);
        // int realPosZ = Math.round(_posz+_posz/2);
        // System.out.println(realPosX);
        // System.out.println(realPosZ);
        // System.out.println("------------");

        int xMatrice = (int)((dimension-1-_posx)/2);
        int zMatrice = (int)((dimension-1-_posz)/2);
        float xPosReelle = dimension-2*xMatrice-1;
        float zPosReelle = dimension-2*zMatrice-1;

        if (xMatrice >= 0 && xMatrice < dimension && zMatrice >= 0 && zMatrice < dimension )
        {
            // Vecteur3D vecteur1 = new Vecteur3D(xMatrice,matriceTerrain[xMatrice][zMatrice],zMatrice);
            Vecteur3D vecteur1 = new Vecteur3D(-xPosReelle,matriceTerrain[xMatrice][zMatrice],-zPosReelle);
            Transformation translation1 = new Translation(translation0, vecteur1);
            CubeCouleur cube = new CubeCouleur(translation1, new Vecteur3D(0.0f, 0.0f, 0.0f));
        }
        else 
        {
            // Vecteur3D vecteur1 = new Vecteur3D(xMatrice,matriceTerrain[xMatrice][zMatrice],zMatrice);
            Vecteur3D vecteur1 = new Vecteur3D(-xPosReelle,10,-zPosReelle);
            Transformation translation1 = new Translation(translation0, vecteur1);
            CubeCouleur cube = new CubeCouleur(translation1, new Vecteur3D(0.0f, 0.0f, 0.0f));
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
    public boolean treeGeneration()
    {
        double alea = Math.random() * 100; // random entre 0 et 100
        boolean res;
        if (alea >=0 && alea <= 2)
            res = true;
        else
            res = false;
        return res;
    }

}
