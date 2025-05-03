
package macromedia;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton {
    
    private boolean mousePress;
    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3,3,3,3));       
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("MENEKANNN");
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MELEPASS");
                mousePress = false;
            }
            
        });
    }   
    
}
