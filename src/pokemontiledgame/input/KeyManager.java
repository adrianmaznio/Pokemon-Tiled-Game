/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author amazn_000
 */
public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public boolean upTapped,downTapped,leftTapped,rightTapped;
    
    public KeyManager()
    {
        keys = new boolean[256];
    }
    
    public void tick()
    {
        upTapped = keys[KeyEvent.VK_UP];
        downTapped = keys[KeyEvent.VK_DOWN];
        leftTapped = keys[KeyEvent.VK_LEFT];
        rightTapped = keys[KeyEvent.VK_RIGHT];        
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }
    
}
