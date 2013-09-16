/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import searchsortgraphics.GUI.DynamicScreen;

/**
 * @brief WIP - common gateway for performing screen operations on multiple screens
 * @author RoyZheng
 */
public class ScreenManager {

    protected List<DynamicScreen> displays = new ArrayList<DynamicScreen>();

    public ScreenManager() {
    }

    public void addScreen(DynamicScreen ds) {
        this.displays.add(ds);
    }

    public void removeScreen(DynamicScreen ds) {
        this.displays.remove(ds);
    }

    public void setCompare(Integer i, Integer j) {
        this.setSingleColor(i, Color.BLUE);
        this.setSingleColor(j, Color.BLUE);
    }

    public void setSwap(Integer i, Integer j) {
        this.setSingleColor(i, Color.RED);
        this.setSingleColor(j, Color.RED);
    }

    public void setSingleColor(Integer i, Color b) {
        for (DynamicScreen ds : this.displays) {
            ds.setSingleColor(i, b);
        }
    }

    public void setPersistentColor(Integer i, Color b) {
        for (DynamicScreen ds : this.displays) {
            ds.setPersistentColor(i, b);
        }
    }

    public void setBlue(Integer i) {
        this.setSingleColor(i, Color.blue);
    }

    public void setRed(Integer i) {
        this.setSingleColor(i, Color.red);
    }

    public void setYellow(Integer i) {
        this.setSingleColor(i, Color.yellow);
    }

    public void setPersistentBlue(Integer i) {
        this.setPersistentColor(i, Color.blue);
    }

    public void setPersistentYellow(Integer i) {
        this.setPersistentColor(i, Color.yellow);
    }

    public void setPersistentRed(Integer i) {
        this.setPersistentColor(i, Color.red);
    }

    public void removePersistent(Integer i) {
        for (DynamicScreen ds : this.displays) {
            ds.removePersistent(i);
        }
    }

    public void clearPersistent() {
        for (DynamicScreen ds : this.displays) {
            ds.clearPersistent();
        }
    }
}
