package searchsortgraphics.GUI;

import searchsortgraphics.SSGRunnable;

/**
 * @brief a button used for starting a number generation algorithm
 * @author RoyZheng
 */
public class SSGGenerateButton extends SSGButton{
    
    public SSGGenerateButton(String text,SSGRunnable action)
    {
	super(text,SSGType.NUMBER_GENERATE,action);
    }
}