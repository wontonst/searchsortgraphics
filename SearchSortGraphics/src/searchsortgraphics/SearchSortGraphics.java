package searchsortgraphics;

/**
 * @mainpage mainpage SearchSortGraphics 0.1.2 build 20121231
 *
 * @section summary Summary
 *
 * <p>SearchSortGraphics aims to graphically render all sorting and search
 * algorithms and output an array of image files for encoding into a video. <a
 * href="http://fixounet.free.fr/avidemux/">Avidemux</a> is an excellent
 * software for this purpose. The program is written all in Java.</p>
 *
 * @section High-Level Architecture
 *
 * The BaseGUI class contains methods for the actual search and sort algorithms
 * as well as saving of frames into the user specified directory.
 *
 * @section Todo
 *
 * <ul><li>Split the BaseGUI class to separate the menu and menu
 * interactions from the rest of the class.</li>
 * <li>Redo GUI to CardLayout without displaying Screen.</li>
 * <li>Every x frames show a preview on main display.</li>
 * <span style="text-decoration:line-through">
 * <li>Split the BaseGUI class to separate the algorithms from the rest of
 * class. </li> 
 * </span></ul>
 */
/**
 * @brief initializes the application GUI and various components
 * @author RoyZheng
 */
public class SearchSortGraphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaseGUI gui = new BaseGUI();
    }
}
