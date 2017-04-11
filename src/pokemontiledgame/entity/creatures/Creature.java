/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame.entity.creatures;

import pokemontiledgame.entity.Entity;

/**
 *
 * @author amazn_000
 */
public abstract class Creature extends Entity
{
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 1.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 14,
                            DEFAULT_CREATURE_HEIGHT = 21;
    
    protected int health;
    protected float speed;
    protected float xMove,yMove;
    
    public Creature(int x, int y,int width,int height)
    {
        super(x, y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    public void move()
    {
        x += xMove;
        y += yMove;
    }

    public void setxMove(float xMove)
    {
        this.xMove = xMove;
    }

    public void setyMove(float yMove)
    {
        this.yMove = yMove;
    }

    public float getxMove()
    {
        return xMove;
    }

    public float getyMove()
    {
        return yMove;
    }
    public int getHealth()
    {
        return health;
    }

    public float getSpeed() 
    {
        return speed;
    }
    
}
