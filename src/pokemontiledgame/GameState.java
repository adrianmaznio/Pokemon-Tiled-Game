/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame;

import java.awt.Graphics;
import pokemontiledgame.entity.creatures.Player;


/**
 *
 * @author amazn_000
 */
public class GameState extends State
{
    public Player player;
    TileLayer layer;
    
    TileLayer background;
    TileLayer collision;
    //TileLayer base;
    TileLayer top;
    
    TileLayer under,grass,base,over,middle;
    
    public GameState(Game game)
    {
        super(game);
        //layer = TileLayer.FromFile("route1.txt");
        //background = TileLayer.FromFile("background.txt");
        //collision = TileLayer.FromFile("collision.txt");
        //base = TileLayer.FromFile("base.txt");
        //top = TileLayer.FromFile("top.txt");
        under = TileLayer.FromFile("Under.txt");
        //grass = TileLayer.FromFile("Grass.txt");
        middle = TileLayer.FromFile("Middle.txt");
       // base = TileLayer.FromFile("Base.txt");
        over = TileLayer.FromFile("Over.txt");
        player = new Player(game,11*16,12*16,middle);
    }

    @Override
    public void tick()
    {
        player.tick();
    }

    @Override
    public void render(Graphics g)
    {
        //layer.renderMap(g);
    	//background.renderMap(g);
    	//collision.renderMap(g);
    	under.renderMap(g);
    	//grass.renderMap(g);
    	//base.renderMap(g);
    	middle.renderMap(g);
        player.render(g);
        over.renderMap(g);
        //top.renderMap(g);
        
    }
    public void renderMap(Graphics g)
    {
        //layer.renderMap(g);
    	//background.renderMap(g);
    	//collision.renderMap(g);
    	under.renderMap(g);
    	//grass.renderMap(g);
    	//base.renderMap(g);
    	middle.renderMap(g);
        //player.render(g);
        over.renderMap(g);
        //top.renderMap(g);
        
    }
    
}
