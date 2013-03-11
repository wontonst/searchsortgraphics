package searchsortgraphics.Generators;

import searchsortgraphics.Core;

/**
     * @brief generates numbers in reverse number with equal spacing
     */
public class GenerateReverse extends Generator{

    public GenerateReverse(Core i)
    {
	super(i);
    }
    public void generate()
    {
        this.numbers.clear();
        for (int i = 139; i != 0; i--) {
            this.numbers.add(i * (Core.MAXY-20) / 139);
        } 
   }

}