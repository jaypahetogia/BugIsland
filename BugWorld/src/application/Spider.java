package application;

import javafx.scene.image.ImageView;

public class Spider extends Bug {
	 private static final String spiderImage = "/images/spider.png";//load the image

	  public Spider(double width, double height, double maxWidth, double maxHeight) {
	        super(spiderImage, "Spider", 'S', width, height, maxWidth, maxHeight);
	  }
	  
	    @Override
	    public void smellFood() {
	        Food targetFood = foodsInWorld.get(0); //food index 0 is pizza
	        ImageView foodImageView = targetFood.getImageView();
	        if (imageView.getX() < foodImageView.getX()) {
	            imageView.setX(imageView.getX() + 1);  //to move it right
	        } else if (imageView.getX() > foodImageView.getX()) {
	            imageView.setX(imageView.getX() - 1); //to move it left
 }
	        
	        if (imageView.getY() < foodImageView.getY()) {
	            imageView.setY(imageView.getY() + 1); //moves down
	        } else if (imageView.getY() > foodImageView.getY()) {
	            imageView.setY(imageView.getY() - 1);//move up
	        }
	    }
			}

