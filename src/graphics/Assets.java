/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author amazn_000
 */
public class Assets
{
    private static final int width = 14, height = 21;
    private static final int tWidth = 16, tHeight = 16;
    private static final int firstRow = 21;
    private static final int secondRow = firstRow+16;
    private static final int thirdRow = secondRow + 16;
    
    private static final int maleH = 31;
    private static final int maleW = 18;
    
    private static final int tileW = 16;
    private static final int tileH = 16;
    
    private static final int mTW = 19;
    private static final int mTH = 32;
    
    public static ArrayList<BufferedImage> player = new ArrayList<BufferedImage>();
    public static ArrayList<BufferedImage> assets = new ArrayList<BufferedImage>();
    
    public static BufferedImage hero,heroUp,heroLeft,heroRight,heroDown1,heroDown2,heroUp1,heroUp2,heroLeft1,heroLeft2,heroRight1,heroRight2;
    public static BufferedImage heroWalkingDown1,heroWalkingDown2,heroWalkingUp1,heroWalkingUp2,heroWalkingLeft1,heroWalkingLeft2,heroWalkingRight1,heroWalkingRight2;
    
    public static BufferedImage treeTopLeft, treeTopRight, treeMidLeft, treeMidRight, treeBotLeft, treeBotRight, treeTopLeftGrass,
                                treeTopRightGrass, treeTopLeftMushroom, grass, wildGrass, mushroom, logLeft, logRight,ledgeLeft,ledgeMid,ledgeRight,
                                treeLeftOverlap,treeRightOverlap;
    
    public static BufferedImage malePlayerDown,malePlayerWalkDown1,malePlayerWalkDown2,malePlayerWalkDown3,
                                malePlayerLeft,malePlayerWalkLeft1,malePlayerWalkLeft2,malePlayerWalkLeft3,
                                malePlayerRight,malePlayerWalkRight1,malePlayerWalkRight2,malePlayerWalkRight3,
                                malePlayerUp,malePlayerWalkUp1,malePlayerWalkUp2,malePlayerWalkUp3;
    
    
    public static void init()
    {
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sprites/spritesheet.png"));
    	SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sprites/spritesheet.png"));
        BufferedImage img;
        /*for(int y = 0;y<4;y++)
    	{
    		
        	img = sheet.crop(width*y,0,width,height);
    		
    		player.add(img);
    	}*/
        hero = sheet.crop(0,0,width,height);
        heroUp = sheet.crop(width,0,width,height);
        heroLeft = sheet.crop(width*2,0,width,height);
        heroRight = sheet.crop(width*3,0,width,height);
        
        heroDown1 = sheet.crop(0,height+32,width+1,height);
        heroDown2 = sheet.crop(width+1,height+32,width+1,height);
        heroUp1 = sheet.crop(width*2+2,height+32,width,height);
        heroUp2 = sheet.crop(width*3+2,height+32,width,height);
        heroLeft1 = sheet.crop(width*4+2,height+32,width,height);
        heroLeft2 = sheet.crop(width*5+2,height+32,width,height);
        heroRight1 = sheet.crop(width*6+2,height+32,width,height);
        heroRight2 = sheet.crop(width*7+2,height+32,width,height);
        
        /*for(int i = 0;i<4;i++)
        {
        	for(int y = 0;y<4;y++)
        	{
        		if(y==1)
        		{
        			img = sheet.crop(width*y,height*i,width,height);
        		}
        		else
        		{
        			img = sheet.crop(width*y+1,height*i+1,width,height);
        		}
        		player.add(img);
        	}
        }*/
        sheet = new SpriteSheet(ImageLoader.loadImage("/sprites/PokemonTileSet.png"));
        for(int i = 0;i<50;i++)
        {
        	for(int y = 0;y<8;y++)
        	{
        		img = sheet.crop(tileW*y,tileH*i,tileW,tileH);
        		assets.add(img);
        	}
        }
        
        /*
        hero = sheet.crop(0,0,width,height);
        heroUp = sheet.crop(width,0,width,height);
        heroLeft = sheet.crop(width*2,0,width,height);
        heroRight = sheet.crop(width*3,0,width,height);
        
        treeTopLeft = sheet.crop(0,firstRow,tWidth,tHeight);
        treeTopRight = sheet.crop(tWidth,firstRow,tWidth,tHeight);
        treeMidLeft = sheet.crop(tWidth*2,firstRow,tWidth,tHeight);
        treeMidRight = sheet.crop(tWidth*3,firstRow,tWidth,tHeight);
        treeBotLeft = sheet.crop(tWidth*4,firstRow,tWidth,tHeight);
        treeBotRight = sheet.crop(tWidth*5,firstRow,tWidth,tHeight);
        treeTopLeftGrass = sheet.crop(tWidth*6,firstRow,tWidth,tHeight);
        treeTopRightGrass = sheet.crop(tWidth*7,firstRow,tWidth,tHeight);
        treeTopLeftMushroom = sheet.crop(tWidth*8,firstRow,tWidth,tHeight);
        grass = sheet.crop(tWidth*9,firstRow,tWidth,tHeight);
        
        wildGrass = sheet.crop(0,secondRow,tWidth,tHeight);
        mushroom = sheet.crop(tWidth,secondRow,tWidth,tHeight);
        logLeft = sheet.crop(tWidth*2,secondRow,tWidth,tHeight);
        logRight = sheet.crop(tWidth*3,secondRow,tWidth,tHeight);
        ledgeLeft = sheet.crop(tWidth*4,secondRow,tWidth,tHeight);
        ledgeMid = sheet.crop(tWidth*5,secondRow,tWidth,tHeight);
        ledgeRight = sheet.crop(tWidth*6,secondRow,tWidth,tHeight);
        treeLeftOverlap = sheet.crop(tWidth*7,secondRow,tWidth,tHeight);
        treeRightOverlap = sheet.crop(tWidth*8,secondRow,tWidth,tHeight);
        
        heroWalkingDown1 = sheet.crop(0,thirdRow,width+1,height);
        heroWalkingDown2 = sheet.crop(width+1,thirdRow,width+1,height);
        heroWalkingUp1 = sheet.crop(width*2+1,thirdRow,width,height);
        heroWalkingUp2 = sheet.crop(width*3+1,thirdRow,width,height);
        heroWalkingLeft1 = sheet.crop(width*4+1,thirdRow,width,height);
        heroWalkingLeft2 = sheet.crop(width*5+1,thirdRow,width,height);
        heroWalkingRight1 = sheet.crop(width*6+1,thirdRow,width,height);
        heroWalkingRight2 = sheet.crop(width*7+1,thirdRow,width,height);
        */
    }
}
