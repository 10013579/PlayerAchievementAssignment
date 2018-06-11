/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Desktop;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Jaron Chen
 */
public class PDFGenerator {//variables to be used in other methods
    private List<Player> player = new ArrayList<Player>();
    private PDDocument document = new PDDocument();
    private DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
    private Calendar cal = Calendar.getInstance();

    public void execute(List<Player> play)
    {//method to be used when creating a pdf
        player = play;
        generatePDFFromString();
        showPDFFile();
    }
    public void showPDFFile()
    {
        try
        {
            File pdfFile = new File("C:/Users/Jaron Chen/Documents/doc.pdf");
        if (pdfFile.exists()) {//find the pdf created in the other method
            if (Desktop.isDesktopSupported()) 
            {
                Desktop.getDesktop().open(pdfFile);//open the pdf
            } 
            else 
            {
                System.out.println("Awt Desktop is not supported!");
            }
        }
        else
        {//telling the user if there are problems
            System.out.println("File does not exist.");
        }
        }
        catch(Exception ex)
        {//exception catching and output
            System.out.println(ex.toString());
        }
    }
    public void generatePDFFromString()
    {
        Player tempplyr = new Player();//create a player variable
        for (int i = 0; i < player.size(); i++) {
            tempplyr = player.get(i);//populate the player variable
            addPage(tempplyr);//send the player to the addpage method to print into a pdf
        }
        try
        {//saving and ending the pdf creation
            document.save("C:/Users/Jaron Chen/Documents/doc.pdf");
            document.close();
        }
        catch(Exception ex)
        {//exception catcing and output
            System.out.println(ex.toString());
        }
    }
    public void addPage(Player inPlayer)
    {//variables that are used in the method
        PDPage page1 = new PDPage();
        document.addPage(page1);//adding the pdf page to the document
        Achievement tempachv = new Achievement();
        try
        {//writing out the player data into a pdf page and formatting the page
            PDPageContentStream pdcs = new PDPageContentStream(document, page1);
            pdcs.beginText();
            pdcs.setFont(PDType1Font.HELVETICA, 12);
            pdcs.setLeading(3);
            pdcs.newLineAtOffset(25, 725);
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            String outputText = "Player > "
                    +inPlayer.getUsername()
                    +", "+inPlayer.getTagName()
                    +", "+ df.format(cal.getTime());
            pdcs.showText(outputText);
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine(); 
            pdcs.showText(" ");
            pdcs.newLine(); 
            outputText = "Achievements > ";
            pdcs.showText(outputText);
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine();
            pdcs.showText(" ");
            pdcs.newLine(); 
            for (int i = 0; i < inPlayer.GetAchievements().size(); i++) {
                tempachv=inPlayer.GetAchievements().get(i);
                pdcs.newLine();
                outputText = tempachv.getDescription()
                        +", "+ Integer.toString(tempachv.getLevel())
                        +", "+ Integer.toString(tempachv.getMaxLevel());
                pdcs.showText(outputText);
                pdcs.newLine();
                pdcs.showText(" ");
                pdcs.newLine();
                pdcs.showText(" ");
                pdcs.newLine();
                pdcs.showText(" ");
                pdcs.newLine(); 
                pdcs.showText(" ");
                pdcs.newLine(); 
            }
            pdcs.endText();
            pdcs.close();//closing the page editing
            
        }
        catch(Exception ex)
        {//exception catching and output
            System.out.println(ex.toString());
        }
        
    }
}
