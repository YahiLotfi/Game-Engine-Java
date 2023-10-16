package sample;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class MyApplication extends javafx.application.Application {

  @Override
  public void start(Stage stage) {


    Scene scene = createScene();

    stage.setTitle("Loading an image");

    stage.setScene(scene);

    stage.show();
  }

  private static Scene createScene() {
    Image image = new Image("sample/image.png");

    //Setting the image view
    ImageView imageView = new ImageView(image);

    //Setting the position of the image
    imageView.setX(100);
    imageView.setY(100);

    //setting the fit height and width of the image view
    imageView.setFitHeight(216);
    imageView.setFitWidth(256);

    //Setting the preserve ratio of the image view
    imageView.setPreserveRatio(true);

    //Creating a Group object
    Group root = new Group(imageView);

    //Creating and returning  a scene object
    return new Scene(root, 600, 600);
  }

  public static void main(String[] args) {
    launch();
  }
}
