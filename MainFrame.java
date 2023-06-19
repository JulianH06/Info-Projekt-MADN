import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 1100);
        
        Bildimportierer importer = new Bildimportierer();
        add(importer);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
        });
    }
}
