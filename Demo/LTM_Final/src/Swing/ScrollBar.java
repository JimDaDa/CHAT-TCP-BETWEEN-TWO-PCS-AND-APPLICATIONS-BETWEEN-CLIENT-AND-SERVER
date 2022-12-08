package Swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author HOAI THU
 */
public class ScrollBar extends JScrollBar{
    
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(216,219,255));
        setUnitIncrement(20);
    }
}
