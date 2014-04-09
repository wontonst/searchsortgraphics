/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics.Algorithms;

import java.util.List;
import searchsortgraphics.Core;

/**
 *
 * @author roycr_000
 */
public class HeapSort extends Algorithm {

    public HeapSort(Core c) {
        super(c);
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {

    }

    @Override
    public void performSort(List<Integer> array) {
        //heapfiy
        int start = Math.floor((array.size() - 2) / 2);

    }
}
