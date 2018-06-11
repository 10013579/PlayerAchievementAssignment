/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

/**
 *
 * @author Jaron Chen
 */
public class Server {
    //variables to be used in other methods
    private static ServerSocket serversocket ;
    private static Socket socket;
    private static ObjectInputStream inStream;
    
    public static void main(String[] args)
    {
        ArrayList<Player> player = new ArrayList<Player>();
        player = receivePlayers();//create the player arraylist and recieve players from the client 
        System.out.println("************************************************");
        System.out.println("Tagname:"+ player.get(0).getTagName()+". Username: "+ player.get(0).getUsername());
        System.out.println(player.get(0).GetAchievements().get(0).getDescription()+"+"+Integer.toString(player.get(0).GetAchievements().get(0).getLevel())+"+"+Integer.toString(player.get(0).GetAchievements().get(0).getMaxLevel()));
        System.out.println(player.get(0).GetAchievements().get(1).getDescription()+"+"+Integer.toString(player.get(0).GetAchievements().get(1).getLevel())+"+"+Integer.toString(player.get(0).GetAchievements().get(1).getMaxLevel()));
        System.out.println(player.get(0).GetAchievements().get(2).getDescription()+"+"+Integer.toString(player.get(0).GetAchievements().get(2).getLevel())+"+"+Integer.toString(player.get(0).GetAchievements().get(2).getMaxLevel()));
        System.out.println(player.get(0).GetAchievements().get(3).getDescription()+"+"+Integer.toString(player.get(0).GetAchievements().get(3).getLevel())+"+"+Integer.toString(player.get(0).GetAchievements().get(3).getMaxLevel()));
        System.out.println(player.get(0).GetAchievements().get(4).getDescription()+"+"+Integer.toString(player.get(0).GetAchievements().get(4).getLevel())+"+"+Integer.toString(player.get(0).GetAchievements().get(4).getMaxLevel()));
        System.out.println("Tagname:"+ player.get(1).getTagName()+". Username: "+ player.get(1).getUsername());
        System.out.println(player.get(1).GetAchievements().get(0).getDescription()+"+"+Integer.toString(player.get(1).GetAchievements().get(0).getLevel())+"+"+Integer.toString(player.get(1).GetAchievements().get(0).getMaxLevel()));
        System.out.println(player.get(1).GetAchievements().get(1).getDescription()+"+"+Integer.toString(player.get(1).GetAchievements().get(1).getLevel())+"+"+Integer.toString(player.get(1).GetAchievements().get(1).getMaxLevel()));
        System.out.println(player.get(1).GetAchievements().get(2).getDescription()+"+"+Integer.toString(player.get(1).GetAchievements().get(2).getLevel())+"+"+Integer.toString(player.get(1).GetAchievements().get(2).getMaxLevel()));
        System.out.println(player.get(1).GetAchievements().get(3).getDescription()+"+"+Integer.toString(player.get(1).GetAchievements().get(3).getLevel())+"+"+Integer.toString(player.get(1).GetAchievements().get(3).getMaxLevel()));
        System.out.println(player.get(1).GetAchievements().get(4).getDescription()+"+"+Integer.toString(player.get(1).GetAchievements().get(4).getLevel())+"+"+Integer.toString(player.get(1).GetAchievements().get(4).getMaxLevel()));
        System.out.println("Tagname:"+ player.get(2).getTagName()+". Username: "+ player.get(2).getUsername());
        System.out.println(player.get(2).GetAchievements().get(0).getDescription()+"+"+Integer.toString(player.get(2).GetAchievements().get(0).getLevel())+"+"+Integer.toString(player.get(2).GetAchievements().get(0).getMaxLevel()));
        System.out.println(player.get(2).GetAchievements().get(1).getDescription()+"+"+Integer.toString(player.get(2).GetAchievements().get(1).getLevel())+"+"+Integer.toString(player.get(2).GetAchievements().get(1).getMaxLevel()));
        System.out.println(player.get(2).GetAchievements().get(2).getDescription()+"+"+Integer.toString(player.get(2).GetAchievements().get(2).getLevel())+"+"+Integer.toString(player.get(2).GetAchievements().get(2).getMaxLevel()));
        System.out.println(player.get(2).GetAchievements().get(3).getDescription()+"+"+Integer.toString(player.get(2).GetAchievements().get(3).getLevel())+"+"+Integer.toString(player.get(2).GetAchievements().get(3).getMaxLevel()));
        System.out.println(player.get(2).GetAchievements().get(4).getDescription()+"+"+Integer.toString(player.get(2).GetAchievements().get(4).getLevel())+"+"+Integer.toString(player.get(2).GetAchievements().get(4).getMaxLevel()));
    }//output the players that have been sent from the client and put into the arraylist
    public static ArrayList<Player> receivePlayers()
    {
        ArrayList<Player> plyr = new ArrayList<Player>();//create an arraylist to store and return the players
        try
        {
            serversocket = new ServerSocket(4445);//set the port
            while(true)
            {
                socket = serversocket.accept();//accept connections to the server
                System.out.println("Connected");
                inStream = new ObjectInputStream(socket.getInputStream());
                Player p = (Player)inStream.readObject();//put the player received into a player class
                //output the data of the player received
                System.out.println("Object Received: Tagname:"+ p.getTagName()+". Username: "+ p.getUsername());
                System.out.println(p.GetAchievements().get(0).getDescription()+"+"+Integer.toString(p.GetAchievements().get(0).getLevel())+"+"+Integer.toString(p.GetAchievements().get(0).getMaxLevel()));
                System.out.println(p.GetAchievements().get(1).getDescription()+"+"+Integer.toString(p.GetAchievements().get(1).getLevel())+"+"+Integer.toString(p.GetAchievements().get(1).getMaxLevel()));
                System.out.println(p.GetAchievements().get(2).getDescription()+"+"+Integer.toString(p.GetAchievements().get(2).getLevel())+"+"+Integer.toString(p.GetAchievements().get(2).getMaxLevel()));
                System.out.println(p.GetAchievements().get(3).getDescription()+"+"+Integer.toString(p.GetAchievements().get(3).getLevel())+"+"+Integer.toString(p.GetAchievements().get(3).getMaxLevel()));
                System.out.println(p.GetAchievements().get(4).getDescription()+"+"+Integer.toString(p.GetAchievements().get(4).getLevel())+"+"+Integer.toString(p.GetAchievements().get(4).getMaxLevel()));
                if (p == null) {
                    break;//stop accepting new connections if null is sent to the server
                }
                else 
                {//add player to the arraylist so it can be returned
                    plyr.add(p); 
                }
            }
            socket.close();//close the connection to the server
        }
        catch(Exception ex)
        {//catch and display any exceptions
            System.out.println(ex.toString());
        }
        return plyr;//return the players arraylist
    } 
    
}
