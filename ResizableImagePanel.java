import javax.swing.*;
import java.awt.*;

class ResizableImagePanel extends JPanel {
    private Image backgroundImage;

    public ResizableImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Görseli panel boyutuna göre yeniden çiz
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


//				ResizableImagePanel backgroundPanel = new ResizableImagePanel("assets/background-stats.jpg");

// frameadı.add(backgroundPanel);