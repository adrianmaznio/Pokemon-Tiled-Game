package pokemontiledgame.entity.creatures;

import graphics.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemontiledgame.Game;
import pokemontiledgame.TileLayer;
import pokemontiledgame.entity.Entity;
import pokemontiledgame.tiles.Tile;

/**
 *
 * @author amazn_000
 */
public class Player extends Creature
{
    private Game game;
    BufferedImage curState = Assets.hero;
    private Entity[][] grid;
    private Tile[][] curMap;
    private Tile curTile;
    private boolean canWalk = false;
    private int tile = 16;
    
    boolean lockWalking;
    boolean lockTurning;
    int turningTick = 4;
    
    private static final int UP = 2,DOWN = 0,LEFT = 1,RIGHT = 3;
    private int facing;
    private int turning;
    private TileLayer map;
    
    public Player(Game game, int x, int y, TileLayer layer)
    {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        map = layer;
        this.game = game;
        curMap = layer.getMap();
        grid = new Entity[curMap.length][curMap[0].length];
        curTile = curMap[x/tile][y/tile];
    }

    @Override
    public void tick()
    {
        getInput();
    }
    
    private void getInput()
    {
        /*if (!lockTurning) {
            if (game.getKeyManager().upTapped) {
                turning = UP;
                lockTurning = true;
            }
            else if (game.getKeyManager().downTapped) {
                turning = DOWN;
                lockTurning = true;
            }
            else if (game.getKeyManager().leftTapped) {
                turning = LEFT;
                lockTurning = true;
            }
            else if (game.getKeyManager().rightTapped) {
                turning = RIGHT;
                lockTurning = true;
            }
        }*/
        if (!lockWalking && turningTick < 0) {
            if (game.getKeyManager().upTapped) {
                facing = UP;
                yMove--;
                lockWalking = true;
            }
            else if (game.getKeyManager().downTapped) {
                facing = DOWN;
                yMove++;
                lockWalking = true;
            }
            else if (game.getKeyManager().leftTapped) {
                facing = LEFT;
                xMove--;
                lockWalking = true;
            }
            else if (game.getKeyManager().rightTapped) {
                facing = RIGHT;
                xMove++;
                lockWalking = true;
            }
            if (turningTick < -5)
                lockTurning = false;
        }
        handleMovement();
        turningTick--;
    }
    
    private void handleMovement() {
    	//System.out.println("Player: " + x/tile + " " + y/tile + "\n Up: " + x/tile + " " + ((y/tile) - 1));
    	//map.printMap();
	        
	        //canWalk();
	        if (lockWalking) {
	            x += xMove * speed;
	            y += yMove * speed;
	        }
	        if (x % 16 == 0 && y % 16 == 0) {
	            lockWalking = false;
	            xMove = 0;
	            yMove = 0;
	        }
    	
    }
    
    public boolean canWalk()
    {
    	if(facing == UP)
    	{
    		if(curMap[x/tile][(y/tile)-1].canWalk())
        	{
        		return true;
        	}
    	}
    	if(facing == RIGHT)
    	{
    		if(curMap[(x/tile)+1][y/tile].canWalk())
        	{
        		return true;
        	}
    	}
    	if(facing == DOWN)
    	{
    		if(curMap[x/tile][(y/tile)+1].canWalk())
        	{
        		return true;
        	}
    	}
    	if(facing == LEFT)
    	{
    		if(curMap[(x/tile)-1][y/tile].canWalk())
        	{
        		return true;
        	}
    	}
    	return false;
    }
    
    @Override
    public void render(Graphics g)
    {
        g.drawImage(curState, (int)x, (int)y-5, width, height, null);
        if(facing == UP)
        {
            curState = Assets.heroUp;
        }
        if(facing == DOWN)
        {
            curState = Assets.hero;
        }
        if(facing == LEFT)
        {
            curState = Assets.heroLeft;
        }
        if(facing == RIGHT)
        {
            curState = Assets.heroRight;
        }
    	/*
    	g.drawImage(curState, (int)x, (int)y+2, width, height, null);
        if(facing == UP)
        {
            curState = Assets.heroUp;
        }
        if(facing == DOWN)
        {
            curState = Assets.hero;
        }
        if(facing == LEFT)
        {
            curState = Assets.heroLeft;
        }
        if(facing == RIGHT)
        {
            curState = Assets.heroRight;
        }*/
    }
    
    public int getLocX()
    {
    	return (x/16);
    }
    public int getLocY()
    {
    	return (y/16);
    }

}
