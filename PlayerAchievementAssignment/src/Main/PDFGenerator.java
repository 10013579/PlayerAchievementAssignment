/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Jaron Chen
 */
public class PDFGenerator {
    private ArrayList<Player> player = new ArrayList<Player>();
    private ArrayList<Achievement> achieve = new ArrayList<Achievement>();
    private PDDocument document = new PDDocument();
    CSVRead reader = new CSVRead();
    
    public void execute()
    {
        generatePDFFromString();
        showPDFFile();
    }
    public void showPDFFile()
    {
    }
    public void generatePDFFromString()
    {
    }
    public void addPage()
    {
        PDPage page = new PDPage();
    }
}
