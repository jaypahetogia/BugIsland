package application;

import javafx.scene.image.ImageView;

public class Ant extends Bug {
	  private static final String antImage = "/images/ant.png";

	  public Ant(double width, double height, double maxWidth, double maxHeight) {
	        super(antImage, "Ant", 'A', width, height, maxWidth, maxHeight);
	  }
	    @Override
	    public void smellFood() {
	        Food targetFood = foodsInWorld.get(1);//food index 1 is burger
	        ImageView foodImageView = targetFood.getImageView();

	        if (imageView.getX() < foodImageView.getX()) {
	            imageView.setX(imageView.getX() + 1);//moves right
	        } else if (imageView.getX() > foodImageView.getX()) {
	            imageView.setX(imageView.getX() - 1); //moves left
	        }

	        if (imageView.getY() < foodImageView.getY()) {
	            imageView.setY(imageView.getY() + 1);//moves it down
	        } else if (imageView.getY() > foodImageView.getY()) {
	            imageView.setY(imageView.getY() - 1);//moves it up
	        }
	    }
	}
