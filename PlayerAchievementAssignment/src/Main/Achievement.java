/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Jaron Chen
 */
public class Achievement {
    private String Description;
    private int Level;
    private int MaxLevel;
    private String Username;

    public Achievement() {
    }
    
    public Achievement(String Description, int Level, int MaxLevel, String Username) {
        this.Description = Description;
        this.Level = Level;
        this.MaxLevel = MaxLevel;
        this.Username = Username;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getMaxLevel() {
        return MaxLevel;
    }

    public void setMaxLevel(int MaxLevel) {
        this.MaxLevel = MaxLevel;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
}
