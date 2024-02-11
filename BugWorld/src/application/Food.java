package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Food {
    private ImageView imageView;
    private Random random = new Random();

    public Food(String imagePath, double width, double height, double maxWidth, double maxHeight) {
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        double startX = random.nextDouble() * (maxWidth - width);
        double startY = random.nextDouble() * (maxHeight - height);

        imageView.setX(startX);
        imageView.setY(startY);
    }

    public ImageView getImageView() {
        return imageView;
    }
    //checking for collision with food
    public boolean isCollidingWith(ImageView other) {
        return imageView.getBoundsInParent().intersects(other.getBoundsInParent());
    }
}

