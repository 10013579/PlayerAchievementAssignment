/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.Serializable;


/**
 *
 * @author Jaron Chen
 */
public class Player implements Serializable{
    //variables of the player class
    public static final long serialVersionUID = 5950169519310163575L;
    private String Username;
    private String TagName;

    //getters, setters, and constructors of the class
    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
    private List<Achievement> achievements = new ArrayList<Achievement>();
    
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

    public List<Achievement> GetAchievements()
    {
        return achievements;
    }
    
    public Player(String Username, String TagName, List<Achievement> achievement) {
        this.Username = Username;
        this.TagName = TagName;
        this.achievements = achievement;
    }
    
    //methods for adding achievements to player
    public void addAchievements(String Description, int Level, int MaxLevel)
    {
        achievements.add(new Achievement(Description, Level, MaxLevel));
    }
    
    public void addAchievements(Achievement A)
    {
        achievements.add(A);
    }
    //methods for sorting by level and description
    public void sortLevel()
    {
        achievements.sort(Comparator.comparing(Achievement::getLevel));
    }
    public void sortDescription()
    {
        achievements.sort(Comparator.comparing(Achievement::getDescription));
    }
    //method for searching the achievements list
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
    //method for clearing the achievements
    public void clearAchievements()
    {
        achievements.clear();
    }
}
