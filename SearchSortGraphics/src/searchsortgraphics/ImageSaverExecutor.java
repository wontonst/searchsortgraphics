/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics;

import searchsortgraphics.GUI.LoadingBar;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief threadpool that maintains an array of ImageSaver objects
 * @author RoyZheng
 */
public class ImageSaverExecutor {

    ExecutorService exec;
    Core main;
    volatile ArrayList<Future> threads;
    Integer maxthreads;

    ImageSaverExecutor(Core in) {
        this.maxthreads = 8;
        this.main = in;
        this.exec = Executors.newFixedThreadPool(maxthreads);
        this.threads = new ArrayList<Future>();
    }

    public void addRender(BufferedImage img, String fn, LoadingBar b) {
        ImageSaver is = new ImageSaver(img, fn, b);
        this.threads.add(this.exec.submit(is));
        this.removeDone();
        //System.out.println(this.threads.size());
        if (threads.size() > 256) {
            try {
                this.threads.get(200).get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ImageSaverExecutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeDone() {
        for (int i = 0; i != this.threads.size(); i++) {
            if (this.threads.get(i).isDone()) {
                this.threads.remove(i);
                return;
            }
        }
    }

    /**
     * @brief sets the maximum threads to use
     * @param in
     */
    public void setMaxThreads(Integer in) {
        this.maxthreads = in;
        try {
            this.exec.awaitTermination(250 / this.maxthreads, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("ImageSaverExecutor: error settings max threads because executor could not terminate within " + 250 / this.maxthreads + " seconds.");
        }
        this.exec = Executors.newFixedThreadPool(maxthreads);
    }
}
