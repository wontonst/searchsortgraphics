package searchsortgraphics.Generators;

import searchsortgraphics.BaseGUI;

/**
     * @brief generates numbers in reverse number with equal spacing
     */
public class GenerateReverse extends Generator{

    public GenerateReverse(BaseGUI i)
    {
	super(i);
    }
    public void generate()
    {
        this.numbers.clear();
        for (int i = 139; i != 0; i--) {
            this.numbers.add(i * 1000 / 139);
        } 
   }

}