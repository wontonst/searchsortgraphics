package searchsortgraphics.GUI;

import javax.swing.JButton;
import searchsortgraphics.SSGRunnable;

/**
 * @brief a superclass button used for displaying an algorithm
 * @author RoyZheng
 */
public class SSGButton extends JButton {

    protected SSGType type;
    protected SSGRunnable action;
    
public SSGButton(String text, SSGType t,SSGRunnable action) {
        super(text);
        this.type = t;
	this.action = action;
    }

    public SSGType getType() {
        return this.type;
    }
    public void perform() {
       Thread t= (new Thread((Runnable)this.action));
       t.setName(this.action.getThreadName());
       t.start();
    }

}