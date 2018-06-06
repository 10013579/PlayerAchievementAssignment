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
public class CSVRead {
    private String csvFile = "";
    private BufferedReader br = null;
    private String line = "";
    private String SplitBy = ",";
    private ArrayList<Player> player = new ArrayList<Player>();
    private ArrayList<Achievement> achieve = new ArrayList<Achievement>();
    
    public ArrayList<Player> ReturnPlayer ()
    {
        return player;
    }
    
    public ArrayList<Achievement> ReturnAchievement()
    {
        return achieve;
    }
    
    public void Read(String FileLoc)
    {
        Player temp = new Player();
        csvFile = FileLoc;
        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {
                String[] Data = line.split(SplitBy);
                if ("Player".equals(Data[0])) 
                {
                    temp.setUsername(Data[1]);
                    temp.setTagName(Data[2]);
                }
                else if ("Achievement".equals(Data[0])) 
                {
                    temp.addAchievements(Data[1], Integer.parseInt(Data[2]), Integer.parseInt(Data[3]));
                }
                else
                {
                    System.out.println("Unexpected Object Type:"+Data[0]);
                }
                if (temp.GetAchievements().size() == 5) {
                    player.add(new Player(temp.getUsername(),temp.getTagName()));
                    for (int i = 0; i <temp.GetAchievements().size(); i++) {
                        achieve.add(new Achievement(temp.GetAchievements().get(i).getDescription(),temp.GetAchievements().get(i).getLevel(),temp.GetAchievements().get(i).getMaxLevel(),temp.GetAchievements().get(i).getUsername()));
                    }
                    temp.clearAchievements();

                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
