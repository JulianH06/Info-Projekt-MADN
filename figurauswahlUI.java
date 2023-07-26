import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class figurauswahlUI extends UI implements ActionListener, MouseListener
{
    protected JButton[] KnopfArr = new JButton[4];
    JLabel label1 = new JLabel("Wähle die zu ziehende Figur!");
    private boolean gewaehlt = false;
    
    public figurauswahlUI(farbenum f) throws java.io.IOException
    {
        super(600, 600, 1100, 300);
        
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(32f));
        
        for(int i = 0; i < 4; i++)
        {
            KnopfArr[i] = new JButton(new ImageIcon(ImageIO.read(
            new File("figur"+ f.ordinal() +".jpg"))));
            
            KnopfArr[i].addActionListener(this);
            KnopfArr[i].addMouseListener(this);
            
            frame.add(KnopfArr[i]);
        }

        KnopfArr[0].setBounds(75, 75, 200, 200);
        KnopfArr[1].setBounds(325, 75, 200, 200);
        KnopfArr[2].setBounds(75, 325, 200, 200);
        KnopfArr[3].setBounds(325, 325, 200, 200);
        
        frame.add(label1);
        
        //super.resetsize(600, 600);
    }
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == KnopfArr[0])
        {
            GameManager.aktFigurSetzen(0);
        }
        if(ae.getSource() == KnopfArr[1])
        {
            GameManager.aktFigurSetzen(1);
        }
        if(ae.getSource() == KnopfArr[2])
        {
            GameManager.aktFigurSetzen(2);
        }
        if(ae.getSource() == KnopfArr[3])
        {
            GameManager.aktFigurSetzen(3);
        }
        gewaehlt = true;
        GameManager.Instance.notifyGM();
        super.close();
    }
    
    public void mouseEntered(MouseEvent e)
    {
        JButton Button = (JButton) e.getComponent();
        if(Button == KnopfArr[0])
        {
            try{GameManager.highlightFigur(0);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[1])
        {
            try{GameManager.highlightFigur(1);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[2])
        {
            try{GameManager.highlightFigur(2);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[3])
        {
            try{GameManager.highlightFigur(3);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
    }
    
    public void mouseExited(MouseEvent e)
    {
        JButton Button = (JButton) e.getComponent();
        if(Button == KnopfArr[0])
        {
            try{GameManager.unhighlightFigur(0);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[1])
        {
            try{GameManager.unhighlightFigur(1);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[2])
        {
            try{GameManager.unhighlightFigur(2);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[3])
        {
            try{GameManager.unhighlightFigur(3);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
    }
    
    public void mousePressed(MouseEvent e)
    {}
    
    public void mouseReleased(MouseEvent e)
    {
        JButton Button = (JButton) e.getComponent();
        if(Button == KnopfArr[0])
        {
            try{GameManager.unhighlightFigur(0);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[1])
        {
            try{GameManager.unhighlightFigur(1);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[2])
        {
            try{GameManager.unhighlightFigur(2);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[3])
        {
            try{GameManager.unhighlightFigur(3);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
    }
    
    public void mouseClicked(MouseEvent e)
    {
        JButton Button = (JButton) e.getComponent();
        if(Button == KnopfArr[0])
        {
            try{GameManager.unhighlightFigur(0);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[1])
        {
            try{GameManager.unhighlightFigur(1);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[2])
        {
            try{GameManager.unhighlightFigur(2);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
        if(Button == KnopfArr[3])
        {
            try{GameManager.unhighlightFigur(3);}catch (java.io.IOException ioe)
            {ioe.printStackTrace();} 
        }
    }
    
    public JFrame gibFrame()
    {
        return frame;
    }
    
    public boolean gewaehlt()
    {
        return gewaehlt;
    }
}
