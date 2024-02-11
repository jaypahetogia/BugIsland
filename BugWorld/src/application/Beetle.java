package application;

import javafx.scene.image.ImageView;

public class Beetle extends Bug {
	  private static final String beetleImage = "/images/beetle.png";//load image

	  public Beetle(double width, double height, double maxWidth, double maxHeight) {
	        super(beetleImage, "Beetle", 'B', width, height, maxWidth, maxHeight);
	  				}
	    @Override
	     public void smellFood() {
	      Food targetFood = foodsInWorld.get(3);//food index 3 is fruits
	      ImageView foodImageView = targetFood.getImageView();
	        if (imageView.getX() < foodImageView.getX()) {
	            imageView.setX(imageView.getX() + 1);//move it to the right
	        } else if (imageView.getX() > foodImageView.getX()) {
	            imageView.setX(imageView.getX() - 1);//move to the left
	   }

	        if (imageView.getY() < foodImageView.getY()) {
	            imageView.setY(imageView.getY() + 1); //moves it down
	        } else if (imageView.getY() > foodImageView.getY()) {
	            imageView.setY(imageView.getY() - 1); //moves it up
	       }
	}
	}
