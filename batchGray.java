package batchGrayscale;

import edu.duke.*;
import java.io.*;

/**
 * Write a description of batchGray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class batchGray {
    
    public ImageResource makeGrey (ImageResource inImage){
        
        //make an OutImage same size as InImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        //for each pixel of outImage
        for (Pixel p: outImage.pixels()){ 
        
        //create new pixel to store RGB value
        Pixel inPixel = inImage.getPixel(p.getX(),p.getY());
        //get RGB value of inImage
        //create avg value
        int avgValue = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
        //set outImage RGB to avg value
        p.setRed (avgValue);
        p.setBlue(avgValue);
        p.setGreen(avgValue);
       }
        
        return outImage;
    }
    
    public ImageResource makeInverted (ImageResource inImage){
        
        //make an OutImage same size as InImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        //for each pixel of outImage
        for (Pixel p: outImage.pixels()){ 
        
        //create new pixel to store RGB value
        Pixel inPixel = inImage.getPixel(p.getX(),p.getY());
        //get RGB value of inImage
        p.setRed (255-inPixel.getRed());
        p.setBlue(255-inPixel.getBlue());
        p.setGreen(255-inPixel.getGreen());
       }
        
        return outImage;
    }
    
    
    public void batchMakeGrey(){
        DirectoryResource dr = new DirectoryResource();
            for (File f: dr.selectedFiles()){
                ImageResource inImage = new ImageResource(f);
                ImageResource grey = makeGrey(inImage);
                //change the name of the file
                String fileName = inImage.getFileName();
                //String newFileName = "C:\\Users\\manmiche\\Documents\\ATA\\batchGrayscale\\images\\gray-"+fileName;
                String newFileName = "gray-"+fileName;
                grey.draw();
                grey.setFileName(newFileName);
                //save the image
                grey.save();
                
            }
    
    }
    
    public void batchMakeInverted(){
        DirectoryResource dr = new DirectoryResource();
            for (File f: dr.selectedFiles()){
                ImageResource inImage = new ImageResource(f);
                ImageResource inv = makeInverted(inImage);
                //change the name of the file
                String fileName = inImage.getFileName();
                String newFileName = "C:\\Users\\manmiche\\Documents\\ATA\\batchGrayscale\\images\\inverted-"+fileName;
                inv.setFileName(newFileName);
                //inImage = makeGrey(inImage);
                //save the image
                inv.save();
                
            }
    
    }
    
    public void testGrey(){
        ImageResource img = new ImageResource();
        ImageResource grey = makeGrey(img);
        grey.draw();
    }
    
    public void testInverted(){
        ImageResource img = new ImageResource();
        ImageResource inv = makeInverted(img);
        inv.draw();
    }
}
