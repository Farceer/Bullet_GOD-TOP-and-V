package Button;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ButtonPress extends Button {
	private Button PressButton;


	public ButtonPress(ImageView image) {
		super();
		this.setGraphic(image);
		this.setBackground(null);


	}

	public Button getButton() {
		return PressButton;
	}

}
