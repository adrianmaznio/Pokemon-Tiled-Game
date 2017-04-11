/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author amazn_000
 */
public class DrawPanel extends JPanel
{
    private TileLayer layer;
    
    public DrawPanel()
    {
        
        layer = TileLayer.FromFile("/res/route1.txt");
    }
    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        layer.renderMap(g);
    }
    
}
