/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics.GUI;

import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import searchsortgraphics.Algorithms.BogoSort;
import searchsortgraphics.Algorithms.BubbleSort;
import searchsortgraphics.Algorithms.CocktailSort;
import searchsortgraphics.Algorithms.CombSort;
import searchsortgraphics.Algorithms.GnomeSort;
import searchsortgraphics.Algorithms.GnomeSortOptimized;
import searchsortgraphics.Algorithms.InsertionSort;
import searchsortgraphics.Algorithms.OddEvenSort;
import searchsortgraphics.Algorithms.QuickSort;
import searchsortgraphics.Algorithms.SelectionSort;
import searchsortgraphics.Algorithms.ShellSort;
import searchsortgraphics.Algorithms.StoogeSort;
import searchsortgraphics.BaseGUI;

/**
 * @brief tabbed panel for displaying all the sorting algorithms
 * @author RoyZheng
 */
public class SortChooser extends JTabbedPane {

    BaseGUI main;
    ActionListener listener;
    //exchange sorts
    SSGSortButton bubblesort;///<starts bubble sort rendering
    SSGSortButton cocktailsort;///<starts cocktail sort rendering
    SSGSortButton gnomesort;///<starts gnome sort rendering
    SSGSortButton gnomesortoptimized;///<start optimized gnome sort rendering
    SSGSortButton oddevensort;///<start odd-even sort rendering
    SSGSortButton combsort;///<start comb sort rendering
    SSGSortButton quicksort;///<start quicksort rendering
    SSGSortButton stoogesort;///<starts stoogesort rendering
    SSGSortButton bogosort;///<starts bogosort rendering
    //selection sorts
    SSGSortButton selectionsort;///<starts selection sort rendering
    //insertion sorts
    SSGSortButton insertionsort;///<starts insertionsort rendering
    SSGSortButton shellsort;///<starts shellsort rendering
    ButtonDisplay exchange;
    ButtonDisplay insertion;
    ButtonDisplay selection;

    public SortChooser(BaseGUI main, ActionListener al) {
        this.main = main;
        this.listener = al;
        this.create();
    }

    private void create() {
        this.createExchangeSort();
        this.createInsertionSort();
        this.createSelectionSort();
    }

    private void createExchangeSort() {
        this.exchange = new ButtonDisplay();
        this.bubblesort = new SSGSortButton("Bubble Sort", new BubbleSort(this.main));
        this.bubblesort.addActionListener(this.listener);
        this.exchange.addButton(this.bubblesort);
        this.cocktailsort = new SSGSortButton("Cocktail Sort", new CocktailSort(this.main));
        this.cocktailsort.addActionListener(this.listener);
        this.exchange.addButton(this.cocktailsort);
        this.gnomesort = new SSGSortButton("Gnome Sort", new GnomeSort(this.main));
        this.gnomesort.addActionListener(this.listener);
        this.exchange.addButton(this.gnomesort);
        this.gnomesortoptimized = new SSGSortButton("<html>GnomeSort<br />(optimized)</html", new GnomeSortOptimized(this.main));
        this.gnomesortoptimized.addActionListener(this.listener);
        this.exchange.addButton(this.gnomesortoptimized);
        this.oddevensort = new SSGSortButton("Odd-Even Sort", new OddEvenSort(this.main));
        this.oddevensort.addActionListener(this.listener);
        this.exchange.addButton(this.oddevensort);
        this.combsort = new SSGSortButton("Comb Sort", new CombSort(this.main));
        this.combsort.addActionListener(this.listener);
        this.exchange.addButton(this.combsort);
        this.quicksort = new SSGSortButton("Quick Sort", new QuickSort(this.main));
        this.quicksort.addActionListener(this.listener);
        this.exchange.addButton(this.quicksort);
        this.stoogesort = new SSGSortButton("Stooge Sort", new StoogeSort(this.main));
        this.stoogesort.addActionListener(this.listener);
        this.exchange.addButton(this.stoogesort);
        this.bogosort = new SSGSortButton("Bogo Sort", new BogoSort(this.main));
        this.bogosort.addActionListener(this.listener);
        this.exchange.addButton(this.bogosort);
        this.addTab("Exchange", null, this.exchange, "exchange sorts");
    }

    private void createSelectionSort() {
        this.selection = new ButtonDisplay();
        this.selectionsort = new SSGSortButton("Selection Sort", new SelectionSort(this.main));
        this.selectionsort.addActionListener(this.listener);
        this.selection.addButton(this.selectionsort);
        this.addTab("Selection", null, this.selection, "selection sorts");
    }

    private void createInsertionSort() {
        this.insertion = new ButtonDisplay();
        this.insertionsort = new SSGSortButton("Insertion Sort", new InsertionSort(this.main));
        this.insertionsort.addActionListener(this.listener);
        this.insertion.addButton(this.insertionsort);
        this.shellsort = new SSGSortButton("Shell Sort", new ShellSort(this.main));
        this.shellsort.addActionListener(this.listener);
        this.insertion.addButton(this.shellsort);
        this.addTab("Insertion", null, this.insertion, "insertion sorts");
    }

    private void createMergeSort() {
    }

    private void createDistributionSort() {
    }

    private void createConcurrentSort() {
    }

    private void createHybridSort() {
    }
}
