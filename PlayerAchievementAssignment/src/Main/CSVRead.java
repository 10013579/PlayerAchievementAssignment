/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaron Chen
 */
public class CSVRead {//variables to be used in the methods
    private String csvFile = "";
    private BufferedReader br = null;
    private String line = "";
    private String SplitBy = ",";
    private List<Player> player = new ArrayList<Player>();
    private List<Achievement> achieve = new ArrayList<Achievement>();
    
    public List<Player> ReturnPlayer ()
    {//return the list of players
        return player;
    }
      
    public void Read(String FileLoc)
    {
        csvFile = FileLoc;
        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {//read the csv file
                String[] Data = line.split(SplitBy);//split the line into proper data pieces
                if ("Player".equals(Data[0])) 
                {//add the player into the arraylist
                    player.add(new Player());
                    player.get(player.size()-1).setUsername(Data[1]);
                    player.get(player.size()-1).setTagName(Data[2]);
                }
                else if ("Achievement".equals(Data[0])) 
                {//add the players achievements to the player
                    player.get(player.size()-1).addAchievements(Data[1], Integer.parseInt(Data[2]), Integer.parseInt(Data[3]));
                }
                else
                {//output error message for unexpected object type
                    System.out.println("Unexpected Object Type:"+Data[0]);
                }
            }
        }
        catch(Exception ex)
        {//catch eqceptions and output
            System.out.println(ex.toString());
        }
    }
}
