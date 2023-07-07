import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPanelWithBackground extends JPanel {

    private BufferedImage backgroundImage;

    public JPanelWithBackground() {
        try {
            // Load the background image from file
            backgroundImage = ImageIO.read(new File("spielbrett.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, 1000, 1000, null);

        // Draw multiple circles on top of the background
        int[] circleX = {
                94, 173, 252, 331, 410, 410, 410, 410, 410, 492, 574, 573, 573, 573, 573, 652, 731, 810, 889, 889, 889, 573, 652, 731, 810, 573, 573, 573, 573, 492, 410, 410, 410, 410, 410, 94, 173, 252, 331, 94, 91,91,172,172,894,894,813,813, 91,91,172,172,894,894,813,813,173, 252, 331, 410, 573, 652, 731, 810, 492,492,492,492,493,493,493,493};
        
        int[] circleY = {
                403, 403, 403, 403, 403, 325, 246, 167, 91, 90, 90, 325, 246, 167, 403, 403, 403, 403, 403, 481, 561, 561, 561, 561, 561, 796, 718, 640, 873, 873, 873, 796, 718, 640, 561, 561, 561, 561, 561, 481, 94,174,94,174,94,174,94,174,873, 794, 873, 795, 872, 795, 873, 795, 481, 481, 481, 481, 481, 481, 481, 481,325, 246, 167, 403,559, 794, 715, 639};
                                                                                                                                                                                
        int[] circleRadius = {                                                                                                                                                          
                30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22};
        for (int i = 0; i < circleX.length; i++) {
            
            g.setColor(new Color(0, 0, 255, 0)); // Transparent blue (RGB: 0, 0, 255, alpha: 0)

            g.fillOval(circleX[i] - circleRadius[i], circleY[i] - circleRadius[i], circleRadius[i] * 2, circleRadius[i] * 2);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        paintComponent(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame("JPanel with Background and Circles");
                    JPanelWithBackground panel = new JPanelWithBackground();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(1000, 1000);
                    frame.add(panel);
                    frame.setVisible(true);
                }
            });
    }
}
