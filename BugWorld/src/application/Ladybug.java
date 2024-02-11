package application;

import javafx.scene.image.ImageView;

public class Ladybug extends Bug {
	  private static final String ladybugImage = "/images/ladybug.png";//load our image

	  public Ladybug(double width, double height, double maxWidth, double maxHeight) {
	        super(ladybugImage, "Ladybug", 'L', width, height, maxWidth, maxHeight);
	  	}
	    @Override
	    public void smellFood() {
	        Food targetFood = foodsInWorld.get(2);//food index 2 is almond
	        ImageView foodImageView = targetFood.getImageView();

	        if (imageView.getX() < foodImageView.getX()) {
	            imageView.setX(imageView.getX() + 1);//move to right
	        } else if (imageView.getX() > foodImageView.getX()) {
	            imageView.setX(imageView.getX() - 1);	//move to left
	        		}

	        if (imageView.getY() < foodImageView.getY()) {
	            imageView.setY(imageView.getY() + 1); //moves down
	        } else if (imageView.getY() > foodImageView.getY()) {
	            imageView.setY(imageView.getY() - 1);  //moves up
	  }
	    }
			}
