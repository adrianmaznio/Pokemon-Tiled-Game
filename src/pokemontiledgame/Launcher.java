/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokemontiledgame;

/**
 *
 * @author amazn_000
 */
public class Launcher
{
    public static void main(String[] args)
    {
        Game game = new Game("Pokemon",800,800);
        game.start();
    }
}
