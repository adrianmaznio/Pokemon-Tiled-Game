/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame.tiles;

import graphics.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author amazn_000
 */
public class Tile
{
    
    protected BufferedImage img;
    protected int width = 16,height = 16;
    protected int x,y;
    protected int id;
    protected boolean canWalk;
    
    public Tile(int id)
    {
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public int getID()
    {
        return id;
    }
    
    public boolean canWalk()
    {
        if(this.id > 0)
        {
            canWalk = false;
        }
        else
        {
            canWalk = true;
        }
        return canWalk;
    }
    
}
