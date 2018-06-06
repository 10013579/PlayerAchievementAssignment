/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Jaron Chen
 */
public class Player {
    private String Username;
    private String TagName;

    private ArrayList<Achievement> achievements = new ArrayList<Achievement>();
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String TagName) {
        this.TagName = TagName;
    }

    public Player() {
    }

    public ArrayList<Achievement> GetAchievements()
    {
        return achievements;
    }
    
    public Player(String Username, String TagName) {
        this.Username = Username;
        this.TagName = TagName;
    }
    
    public void addAchievements(String Description, int Level, int MaxLevel)
    {
        achievements.add(new Achievement(Description, Level, MaxLevel, Username));
    }
    
    public void addAchievements(Achievement A)
    {
        achievements.add(A);
    }
    public void sortDescription()
    {
        achievements.sort(Comparator.comparing(Achievement::getDescription));
    }
    public Achievement Search(String SearchText)
    {
        Achievement output = new Achievement();
        for (int i = 0; i < achievements.size()-1; i++) {
            if (SearchText == achievements.get(i).getDescription()) {
                output = achievements.get(i);
            }
        }
        return output;
    }
    
    public void clearAchievements()
    {
        achievements.clear();
    }
}
