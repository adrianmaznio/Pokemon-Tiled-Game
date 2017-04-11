/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame;

import graphics.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import pokemontiledgame.tiles.Tile;

/**
 *
 * @author amazn_000
 */
public class TileLayer
{
    private Tile[][] map;
    private BufferedImage tileSheet;
    private int tile = 16;
    
    public TileLayer(Tile[][] existingMap)
    {
        map = new Tile[existingMap.length][existingMap[0].length];
        
        for(int y = 0;y<map.length;y++)
        {
            for(int x=0;x<map[y].length;x++)
            {
                map[y][x] = existingMap[y][x];
            }
        }
        tileSheet = LoadTileSheet("map.png");
    }
    
    public TileLayer(int width, int height)
    {
        map = new Tile[height][width];
    }
    public static TileLayer FromFile(String fileName)
    {
        TileLayer layer = null;
        
        ArrayList<ArrayList<Tile>> tempLayout = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String currentLine;
            
            while((currentLine = br.readLine()) != null)
            {
                if(currentLine.isEmpty())
                {
                    continue;
                }
                
                ArrayList<Tile> row =  new ArrayList<>();
                
                String[] values = currentLine.trim().split(",");
                for(String string : values)
                {
                    if(!string.isEmpty())
                    {
                        int id = Integer.parseInt(string) - 1;
                        
                        row.add(new Tile(id));
                    }
                }
                
                tempLayout.add(row);
            }
        }
        catch(IOException e)
        {
            
        }
        int width = tempLayout.get(0).size();
        int height = tempLayout.size();
        layer =  new TileLayer(width,height);
        
        for(int y = 0; y < height; y++)
        {
            for(int x = 0;x < width;x++)
            {
                layer.map[y][x] = tempLayout.get(y).get(x);
            }
        }
        layer.tileSheet = layer.LoadTileSheet("map.png");
        
        return layer;
    }
    public BufferedImage LoadTileSheet(String fileName)
    {
        BufferedImage img = null;
        
        try
        {
            img = ImageIO.read(new File(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Could not load image!");
        }
        
        return img;
    }
    public void printMap()
    {
        System.out.println("The Map:");
        for(int i =  0;i< map.length;i++)
        {
            for(int j = 0;j < map[i].length;j++)
            {
                System.out.print(map[i][j].getID() + " ");
            }
            System.out.print("\n");
        }
    }
    
    public Tile[][] getMap()
    {
        return map;
    }
    
    //int playerx = GameState.getLocX();
    //int playery = GameState.getLocY();
    
    public void renderMap(Graphics g)
    {
    					 //this.map.length
        for(int x = 0; x < this.map.length; x++)
        {					//this.map[x].length
            for(int y = 0;y < this.map[x].length;y++)
            {
            	for(int i = 0;i<400;i++)
            	{
            		if(map[x][y].getID() == i)
            		{
            			g.drawImage(Assets.assets.get(i), y*tile, x*tile, tile, tile, null);
            		}
            	}
                
                //printMap();
                //layer.map[y][x] = tempLayout.get(y).get(x);
            }
        }
    }
    
    public int getTileID(Tile tile)
    {
        return tile.getID();
    }
    
}
