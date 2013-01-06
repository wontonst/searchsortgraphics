package searchsortgraphics.GUI;

import searchsortgraphics.SSGRunnable;
/**
 * @brief a button used for starting a sorting algorithm
 * @author RoyZheng
 */
public class SSGSortButton extends SSGButton {

    public SSGSortButton(String text, SSGRunnable in) {
        super(text, SSGType.SORT_CHOOSE,in);
    }

}