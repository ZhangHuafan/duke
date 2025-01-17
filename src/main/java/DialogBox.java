import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.Collections;

/**
 * This is a class that represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private static final int SPACE = 20;
    private static final Color colorBlue = Color.rgb(156, 202, 224);
    private static final Color colorGreen = Color.rgb(202, 224, 156);

    private DialogBox(String text, Image img) {
        super(SPACE);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.setText(text);
        setBackgroundColor(dialog, colorBlue);
        dialog.setFont(new Font(14));
        displayPicture.setImage(img);
        displayPicture.setClip(getImageClip());
    }

    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setBackgroundColor(dialog, colorGreen);
        setAlignment(Pos.CENTER_LEFT);
    }

    private void setBackgroundColor(Label label, Color color) {
        label.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, new Insets(-5, -5, -5, -5))));
    }

    static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    /**
     * Returns a flipped dialog aligning at the left side.
     *
     * @param text a string showing duke's response to user's command
     * @param img  an <code>Image</code> object as duke's profile
     * @return a flipped dialog of duke aligning at the left side of the chat box
     */
    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        return db;
    }

    //@@author ZhangHuafan
    //Reused from https://gist.github.com/jewelsea/7904493 with minor modifications
    private Rectangle getImageClip() {
        Rectangle clip = new Rectangle(displayPicture.getFitWidth(), displayPicture.getFitHeight());
        clip.setArcWidth(100);
        clip.setArcHeight(100);
        return clip;
    }
    //@@author
}
