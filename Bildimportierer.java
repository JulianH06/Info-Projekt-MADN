import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;

public class Bildimportierer extends JPanel {
    private BufferedImage photo;

    public Bildimportierer() {
        try {
            File file = new File("Spielbrett.jpg");
            photo = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (photo != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double imageAspectRatio = (double) photo.getWidth() / photo.getHeight();
            double panelAspectRatio = (double) panelWidth / panelHeight;

            int x, y, width, height;

            if (imageAspectRatio > panelAspectRatio) {
                width = panelWidth;
                height = (int) (panelWidth / imageAspectRatio);
                x = 0;
                y = (panelHeight - height) / 2;
            } else {
                width = (int) (panelHeight * imageAspectRatio);
                height = panelHeight;
                x = (panelWidth - width) / 2;
                y = 0;
            }

            g.drawImage(photo, x, y, width, height, null);
        } else {
            System.out.println("Image not found.");
        }
    }

    public BufferedImage getPhoto() {
        return photo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Image Importer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Bildimportierer importer = new Bildimportierer();
                frame.add(importer);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Access the loaded image
                BufferedImage loadedImage = importer.getPhoto();
                if (loadedImage != null) {
                    // Do something with the image
                    // For example, you can save it to a file
                    try {
                        File outputImage = new File("SavedImage.jpg");
                        ImageIO.write(loadedImage, "JPEG", outputImage);
                        System.out.println("Image saved successfully to: " + outputImage.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No image loaded.");
                }
            });
    }
}
