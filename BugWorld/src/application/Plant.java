package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plant {
    private ImageView imageView;
    private Random random = new Random();

    public Plant(String imagePath, double width, double height, double maxWidth, double maxHeight) {
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
              
        double startX = random.nextDouble() * (maxWidth - width);//keeps it in the world
        double startY = random.nextDouble() * (maxHeight - height);//keeps it in world
        imageView.setX(startX);
        imageView.setY(startY);
   }

    public ImageView getImageView() {
        return imageView;
    }
}

