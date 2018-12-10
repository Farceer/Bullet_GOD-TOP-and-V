package Potion;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
public class ResouceLoader  {


	// Class Bullet
	private ImageView  ItemSpeed, ItemEnergy, ItemMove;

	private ImageView Input_image;

	public ResouceLoader() {
		// Music
		try {
			// Class Bullet
			this.ItemSpeed = new ImageView(
					new Image(this.getClass().getResourceAsStream(classLoaderNewString("Item/ItemSpeed.png"))));
			this.ItemEnergy = new ImageView(
					new Image(this.getClass().getResourceAsStream(classLoaderNewString("Item/ItemEnergy.png"))));
			this.ItemMove = new ImageView(
					new Image(this.getClass().getResourceAsStream(classLoaderNewString("Item/ItemMachineGun.png"))));
		} catch (Exception e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Image Lost");
			alert.setHeaderText("Error");
			alert.setTitle("Error Detect");
			alert.show();
		}

	}

	public ResouceLoader(String input) {
		Input_image = new ImageView(new Image(this.getClass().getResourceAsStream(input)));
	}

	public ImageView getInputImage() {
		return Input_image;
	}

	public String classLoaderNewString(String string) {
		return new String(string);
	}



	public ImageView getItemSpeed() {
		ItemSpeed.setFitHeight(50);
		ItemSpeed.setFitWidth(50);
		return ItemSpeed;
	}

	public ImageView getItemEnergy() {
		ItemEnergy.setFitHeight(50);
		ItemEnergy.setFitWidth(50);
		return ItemEnergy;
	}

	public ImageView getItemMove() {
		ItemMove.setFitHeight(50);
		ItemMove.setFitWidth(50);
		return ItemMove;
	}



	public ImageView getInput_image() {
		return Input_image;
	}


///////////////////////////////////////**************************CLean Code Alredy*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Alredy*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Alredy*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Alredy*********************************************/////////////////////////////
}
