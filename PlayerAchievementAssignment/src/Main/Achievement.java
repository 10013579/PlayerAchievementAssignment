/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.io.Serializable;

/**
 *
 * @author Jaron Chen
 */
public class Achievement implements Serializable{
    //variables of the class
    public static final long serialVersionUID = 5950169519310163575L;
    private String Description;
    private int Level;
    private int MaxLevel;

    //getters, setters, and constructors for the class
    public Achievement() {
    }
    
    public Achievement(String Description, int Level, int MaxLevel) {
        this.Description = Description;
        this.Level = Level;
        this.MaxLevel = MaxLevel;
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
    
}
