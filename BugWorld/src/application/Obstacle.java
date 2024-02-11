package application;

import java.util.Random;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacle {
    private ImageView imageView;
    private Random random = new Random();
    
    public Obstacle(String imagePath, double width, double height, double maxWidth, double maxHeight) {
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        
        double startX = random.nextDouble() * (maxWidth - width);//to keep it in the world
        double startY = random.nextDouble() * (maxHeight - height);//keep in the world
        
        imageView.setX(startX);
        imageView.setY(startY);
      }

    public ImageView getImageView() {
        return imageView;
  }

    //checking for obstacles intersection
    public boolean intersects(Node other) {
        return imageView.getBoundsInParent().intersects(other.getBoundsInParent());
    }
	}


