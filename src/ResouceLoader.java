import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ResouceLoader {

	private Object getClass;
	// ClassMenu
	private ImageView GameTitle, Menu, StartGUI, QuitGUI,ReStartGUI;
	// ClassEventmanager
	public ImageView RedWin, BlueWin, GameBG;
	// Class Spaceship
	private ImageView BlueShip, RedShip, BlueBomb, RedBomb;

	// Class Bullet
	private ImageView BlueBullet, RedBullet, ItemSpeed, ItemEnergy, ItemMove;

	private ImageView Input_image;

	
	private Media  bgMusic;
	public ResouceLoader() {
		//Music
		try {
			this.bgMusic  =new Media(Main.class.getResource("music/BGmusic.mp4").toURI().toString());
			// Main manu
			this.Menu = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/MenuBG.png"))));
			this.GameTitle = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/Bullet GOD title.png"))));
			this.StartGUI = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/Start.png"))));
			this.ReStartGUI = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/Restart.png"))));
			this.QuitGUI = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/Quit.png"))));
			// ClassEventmanager
			this.RedWin = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/RED TEAM WIN.png"))));
			this.BlueWin = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/BLUE TEAM WIN.png"))));
			this.GameBG = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BG/GameBG.png"))));
			// Class Spaceship
			this.BlueShip = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BlueShip/Blue Ship.png"))));
			this.RedShip = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("RedShip/Red Ship.png"))));
			this.BlueBomb = new ImageView(
					new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BlueShip/Blue Ship exposive.png"))));
			this.RedBomb = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("RedShip/Red Ship exposive.png"))));

			// Class Bullet
			this.RedBullet = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("RedShip/Red Ship bullet.png"))));
			this.BlueBullet = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("BlueShip/Blue Ship bullet_.png"))));
			this.ItemSpeed = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("Item/Item Speed.png"))));
			this.ItemEnergy = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("Item/Item Energy.png"))));
			this.ItemMove = new ImageView(new Image(this.getClass().getResourceAsStream(classLoaderNewString ("Item/Item Move.png"))));
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

	
	public String classLoaderNewString (String string) {
		return new String(string);
	}
	public Object getGetClass() {
		return getClass;
	}

	public ImageView getGameTitle() {
		GameTitle.setFitHeight(200);
		GameTitle.setFitWidth(371.4285);
		GameTitle.setTranslateX(210);
		GameTitle.setTranslateY(100);
		return GameTitle;
	}

	public ImageView getMenu() {
		Menu.setFitHeight(600);
		Menu.setFitWidth(800);
		return Menu;
	}

	public ImageView getStartGUI() {
		StartGUI.setFitHeight(50);
		StartGUI.setFitWidth(150);
		return StartGUI;
	}

	public ImageView getQuitGUI() {
		QuitGUI.setFitHeight(50);
		QuitGUI.setFitWidth(150);
		return QuitGUI;
	}

	public ImageView getRedWin() {
		RedWin.setFitHeight(200);
		RedWin.setFitWidth(371.4285);
		RedWin.setTranslateX(220);
		RedWin.setTranslateY(100);
		return RedWin;
	}

	public ImageView getBlueWin() {
		BlueWin.setFitHeight(200);
		BlueWin.setFitWidth(371.4285);
		BlueWin.setTranslateX(220);
		BlueWin.setTranslateY(100);
		return BlueWin;
	}

	public ImageView getBlueShip() {
		BlueShip.setFitHeight(100);
		BlueShip.setFitWidth(50);
		BlueShip.setPreserveRatio(true);
		return BlueShip;
	}

	public ImageView getRedShip() {
		RedShip.setFitHeight(100);
		RedShip.setFitWidth(50);
		RedShip.setPreserveRatio(true);
		return RedShip;
	}

	public ImageView getBlueBomb() {
		BlueBomb.setFitHeight(130);
		BlueBomb.setFitWidth(130);

		return BlueBomb;
	}

	public ImageView getRedBomb() {
		RedBomb.setFitHeight(130);
		RedBomb.setFitWidth(130);

		return RedBomb;
	}

	public ImageView getBlueBullet() {
		BlueBullet.setFitHeight(50);
		BlueBullet.setFitWidth(50);
		return BlueBullet;
	}

	public ImageView getRedBullet() {
		RedBullet.setFitHeight(50);
		RedBullet.setFitWidth(50);
		return RedBullet;
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

	public ImageView getGameBG() {
		GameBG.setFitHeight(600);
		GameBG.setFitWidth(800);
		return GameBG;
	}

	public ImageView getReStartGUI() {
		ReStartGUI.setFitHeight(50);
		ReStartGUI.setFitWidth(150);
		return ReStartGUI;
	}

	public ImageView getInput_image() {
		return Input_image;
	}

	public Media getBgMusic() {
		return bgMusic;
	}

}
