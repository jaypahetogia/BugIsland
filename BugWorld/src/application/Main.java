package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int worldWidth = 800;//worlds width
    private static final int worldHeight = 600;//worlds height
    
    private List<Food> foods = new ArrayList<>();
    private static final String rockImage = "/images/rock.png";
    private static final String backgrndImage = "/images/background.jpg";
    final String plantImage = "/images/tree.png";
    
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
     //--------------------------------->>>OUR BACKGROUND<<<---------------------------------------
       // Load the background image
        Image backgroundImage = new Image(backgrndImage);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);
        backgroundImageView.fitWidthProperty().bind(root.widthProperty());
        backgroundImageView.fitHeightProperty().bind(root.heightProperty());
        backgroundImageView.setPreserveRatio(false);  //the image to stretch to fit pane
        backgroundImageView.fitWidthProperty().bind(root.widthProperty());
        backgroundImageView.fitHeightProperty().bind(root.heightProperty());
        
  //------------------------------------->>>OUR OBSTACLES<<<---------------------------------------
        List<Obstacle> obstacles = new ArrayList<>();
       

        double rockWidth = 70;
        double rockHeight = 70;
    
           Obstacle obstacle1 = new Obstacle(rockImage, rockWidth, rockHeight, 500, 500);//creating new objects here
           Obstacle obstacle2 = new Obstacle(rockImage, rockWidth, rockHeight, 600, 300);
            Obstacle obstacle3 = new Obstacle(rockImage, rockWidth, rockHeight, 900, 700);
            Obstacle obstacle4 = new Obstacle(rockImage, rockWidth, rockHeight, 400, 900);
            
            obstacles.add(obstacle1);//adding these objects to the List
             obstacles.add(obstacle2);
           obstacles.add(obstacle3);
            obstacles.add(obstacle4);
            
            root.getChildren().addAll(obstacle1.getImageView(), obstacle2.getImageView(), obstacle3.getImageView(), obstacle4.getImageView());//add all obstacles to pane
        
        
  //-------------------------------------->>>OUR PLANTS<<<------------------------------------------      
        double plantWidth = 200;
        double plantHeight = 200;
        Plant plant1 = new Plant("/images/tree.png", plantWidth, plantHeight, worldWidth, worldHeight);
        Plant plant2 = new Plant("/images/tree.png", plantWidth, plantHeight, worldWidth, worldHeight);
        Plant plant3 = new Plant("/images/tree.png", plantWidth, plantHeight, worldWidth, worldHeight);
        Plant plant4 = new Plant("/images/tree.png", plantWidth, plantHeight, worldWidth, worldHeight);
        
        plant1.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.2)); //20% of world worldWidth to adapt to resizing window width
        plant1.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.2)); //20% of world worldHeight to adapt to resizing window height
        plant2.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.2)); 
        plant2.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.2)); 
        plant3.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.2)); 
        plant3.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.2)); 
        plant4.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.2)); 
        plant4.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.2)); 
        root.getChildren().addAll(plant1.getImageView(), plant2.getImageView(), plant3.getImageView(), plant4.getImageView());//bind to main pane
 
 //------------------------------------->>>OUR FOOD<<<---------------------------------       
        double foodWidth = 70;
        double foodHeight = 70;
        Food food1 = new Food("/images/pizza.png", foodWidth, foodHeight, worldWidth, worldHeight);//new food objects
        Food food2 = new Food("/images/burger.png", foodWidth, foodHeight, worldWidth, worldHeight);
        Food food3 = new Food("/images/almond.png", foodWidth, foodHeight, worldWidth, worldHeight);
        Food food4 = new Food("/images/fruits.png", foodWidth, foodHeight, worldWidth, worldHeight);
        
        foods.add(food1);//add these new food to List
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        
        food1.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); //10% of world's width in resizing
        food1.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); //10% of world's height in resizing
        food2.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); 
        food2.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); 
        food3.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); 
        food3.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); 
        food4.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); 
        food4.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); 
        
        root.getChildren().addAll(food1.getImageView(), food2.getImageView(), food3.getImageView(), food4.getImageView());//bind it to main pane
        
   //----------------------------------------->>>OUR BUGS<<<-------------------------------------------------------
        Spider spider = new Spider(10, 10, worldWidth, worldHeight);
        Ladybug ladybug = new Ladybug(30, 30, worldWidth, worldHeight);
        Beetle beetle = new Beetle(50, 50, worldWidth, worldHeight);
        Ant ant = new Ant(80, 20, worldWidth, worldHeight);

        spider.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.16)); 
        spider.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.16)); 
        ladybug.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); 
        ladybug.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); 
        beetle.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.15)); 
        beetle.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.15)); 
        ant.getImageView().fitWidthProperty().bind(root.widthProperty().multiply(0.1)); 
        ant.getImageView().fitHeightProperty().bind(root.heightProperty().multiply(0.1)); 
               root.getChildren().addAll(spider.getImageView(), ladybug.getImageView(), beetle.getImageView(), ant.getImageView());
        
  //------------------------------------------>>>OUR BUTTONS<<<-------------------------------------------------------      
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button restartButton = new Button("Restart");
        //positioning and binding on pane
        playButton.layoutXProperty().bind(root.widthProperty().multiply(0.25).subtract(playButton.widthProperty().divide(2)));
        playButton.setLayoutY(10); // 10 units from the top

        pauseButton.layoutXProperty().bind(root.widthProperty().multiply(0.50).subtract(pauseButton.widthProperty().divide(2)));
        pauseButton.setLayoutY(10);

        restartButton.layoutXProperty().bind(root.widthProperty().multiply(0.75).subtract(restartButton.widthProperty().divide(2)));
        restartButton.setLayoutY(10);
 
        root.getChildren().addAll(playButton, pauseButton, restartButton);
   

   //------------------------------------------>>>SCENE & ANIMATION<<<--------------------------------------------------     
        Scene scene = new Scene(root, worldWidth, worldHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bug World");
        primaryStage.show();

        //animation timer for the bugs' movement
        AnimationTimer bugTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	spider.moveRandomly(root.widthProperty(), root.heightProperty(), obstacles);
                ladybug.moveRandomly(root.widthProperty(), root.heightProperty(), obstacles);
                beetle.moveRandomly(root.widthProperty(), root.heightProperty(), obstacles);
                ant.moveRandomly(root.widthProperty(), root.heightProperty(), obstacles);
                
                List<Bug> bugs = Arrays.asList(spider, ladybug, beetle, ant);
                for (Bug bug : bugs) {
                    for (Food food : foods) {
                        if (food.isCollidingWith(bug.getImageView())) {
                            root.getChildren().remove(food.getImageView()); // Remove food from world when eaten by a bug
                            
                        }
                    }
                }
            }
            
        };
        //--------actions for each button--------
        playButton.setOnAction(e -> {
            bugTimer.start();
        });

        pauseButton.setOnAction(e -> {
            bugTimer.stop();
        });

        restartButton.setOnAction(e -> {
            bugTimer.stop();
            
            // Reset bug positions
            spider.reset(worldWidth, worldHeight);
            ladybug.reset(worldWidth, worldHeight);
            beetle.reset(worldWidth, worldHeight);
            ant.reset(worldWidth, worldHeight);

            bugTimer.start();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
