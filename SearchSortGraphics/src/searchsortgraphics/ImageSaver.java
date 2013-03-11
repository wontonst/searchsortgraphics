/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics;

import searchsortgraphics.GUI.LoadingBar;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * @brief saves a single image
 * @author RoyZheng
 */
public class ImageSaver implements Runnable {

    BufferedImage img;
    String filename;
    LoadingBar bar;

    public ImageSaver(BufferedImage in, String fn, LoadingBar b) {
        this.img = in;
        this.filename = fn;
        this.bar = b;
    }

    public void run() {
        try {
            String fn = filename;
            // write the image as a PNG
            ImageIO.write(this.img, "png", new File(this.filename));
            this.bar.increase(1);
            System.out.println(fn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
