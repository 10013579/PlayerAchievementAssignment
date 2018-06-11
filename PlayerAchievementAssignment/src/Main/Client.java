/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaron Chen
 */
public class Client {
    //variables to use in the methods
    private static Socket socket = null;
    private static ObjectOutputStream outputstream;
    
    public static void main(String[] args)
    {
        List<Player> plyr = new ArrayList<Player>();
        CSVRead read = new CSVRead();//creates the reader and the player list so there are players to send
        read.Read("C:/Users/Jaron Chen/Documents/JavaAchievement.csv");
        plyr = read.ReturnPlayer();//gets the players from the csv file
        Player a = plyr.get(0);//puts the player into its own object and sends it to the server
        sendPlayer(a);
        Player b = plyr.get(1);
        sendPlayer(b);
        Player c = plyr.get(2);
        sendPlayer(c);
        sendPlayer(null);//sending null player to tell the server to shut down
        
    }
    public static void sendPlayer(Player pl)
    {
        try
        {
            socket =  new Socket(InetAddress.getLocalHost(), 4445);
            System.out.println("Connected");//connecting to the server and telling the user
            outputstream =  new ObjectOutputStream(socket.getOutputStream());
            if (pl==null) {//tells the user when sending a null object, which would tell the server  to shut down
                System.out.println("Sending Null Object");
            }
            else
            {//tell the user of the object to be sent to the server
            System.out.println("Object to send: Tagname:"+ pl.getTagName()+". Username: "+ pl.getUsername());
            System.out.println(pl.GetAchievements().get(0).getDescription()+"+"+Integer.toString(pl.GetAchievements().get(0).getLevel())+"+"+Integer.toString(pl.GetAchievements().get(0).getMaxLevel()));
            System.out.println(pl.GetAchievements().get(1).getDescription()+"+"+Integer.toString(pl.GetAchievements().get(1).getLevel())+"+"+Integer.toString(pl.GetAchievements().get(1).getMaxLevel()));
            System.out.println(pl.GetAchievements().get(2).getDescription()+"+"+Integer.toString(pl.GetAchievements().get(2).getLevel())+"+"+Integer.toString(pl.GetAchievements().get(2).getMaxLevel()));
            System.out.println(pl.GetAchievements().get(3).getDescription()+"+"+Integer.toString(pl.GetAchievements().get(3).getLevel())+"+"+Integer.toString(pl.GetAchievements().get(3).getMaxLevel()));
            System.out.println(pl.GetAchievements().get(4).getDescription()+"+"+Integer.toString(pl.GetAchievements().get(4).getLevel())+"+"+Integer.toString(pl.GetAchievements().get(4).getMaxLevel()));
            }
            outputstream.writeObject(pl);
            outputstream.flush();//write the object, send it to the server, and close the connection
            outputstream.close();
            socket.close();
        }
        catch(Exception ex)
        {//exception catching for any potential execeptions
            System.out.println(ex.toString());
        }
    }
}
