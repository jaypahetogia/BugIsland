package application;

import java.util.List;
import java.util.Random;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Bug {
    protected ImageView imageView;
    protected String name;
    protected char symbol;
    protected int x;
    protected int y;
    protected int energyLevel;
    protected int id;
    protected double stepSize = 8.0;
    protected Random random = new Random();
    private static int idCount = 0;
    protected List<Food> foodsInWorld;

  public Bug(String imagePath, String name, char symbol, double width, double height, double maxWidth, double maxHeight) {
        this.name = name;
        this.symbol = symbol;
        this.energyLevel = 100;//default
        this.id = idCount++;//for a unique id

        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        
      //random starting positions
        double startX = random.nextDouble() * (maxWidth - width);
        double startY = random.nextDouble() * (maxHeight - height);
        imageView.setX(startX);
        imageView.setY(startY);

        this.x = (int) startX;
        this.y = (int) startY;

        imageView.setOnMouseClicked(e -> showDetails());//click event to show details
  		}
  private void showDetails() {
      String details = String.format("Name: %s%nSymbol: %s%nX: %d%nY: %d%nEnergy: %d%nID: %d",//print details of bug
              name, symbol, x, y, energyLevel, id);
      Alert alert = new Alert(Alert.AlertType.INFORMATION, details);
      alert.setHeaderText(name + " Details");
      alert.showAndWait();
  }
    
    public void setFoodsInWorld(List<Food> foods) {
        this.foodsInWorld = foods;
    }

    public abstract void smellFood();//smellFood is overriden by each bug for different food

    public ImageView getImageView() {
        return imageView;
    }

    public void moveRandomly(ReadOnlyDoubleProperty readOnlyDoubleProperty, ReadOnlyDoubleProperty readOnlyDoubleProperty2, List<Obstacle> obstacles) {
        int direction = random.nextInt(4);
        
        x = (int) imageView.getX();
        y = (int) imageView.getY();

        double dx = 0;
        double dy = 0;

        switch(direction) {
            case 0: dy = -stepSize; break;//North
            case 1: dy = stepSize; break;  //South
            case 2: dx = stepSize; break;  //East
            case 3: dx = -stepSize; break; //West
        }

        double newX = Math.max(0, Math.min(readOnlyDoubleProperty.get() - imageView.getFitWidth(), imageView.getX() + dx));
        double newY = Math.max(0, Math.min(readOnlyDoubleProperty2.get() - imageView.getFitHeight(), imageView.getY() + dy));

        imageView.setX(newX);
        imageView.setY(newY);
        
        // Check intersections with obstacles
        for (Obstacle obstacle : obstacles) {
            if (obstacle.intersects(imageView)) {
                imageView.setX(imageView.getX() - dx);
                imageView.setY(imageView.getY() - dy);
                break;  
            }
        }
    }
    
    
    public void reset(double maxWidth, double maxHeight) {
        // Set random starting positions
        double startX = random.nextDouble() * (maxWidth - imageView.getFitWidth());
        double startY = random.nextDouble() * (maxHeight - imageView.getFitHeight());
        
        imageView.setX(startX);
        imageView.setY(startY);
    }

}


