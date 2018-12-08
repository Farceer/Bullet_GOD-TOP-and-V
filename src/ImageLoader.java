import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {
	
	
	private Object getClass;
	//ClassMenu
	private   ImageView GameTitle,Menu,StartGUI,QuitGUI;
	//ClassEventmanager
	public    ImageView RedWin,BlueWin,GameBG;
	//Class Spaceship
	private   ImageView BlueShip,RedShip,BlueBomb,RedBomb;

	//Class Bullet 
	private   ImageView BlueBullet,RedBullet,ItemSpeed,ItemEnergy,ItemMove;

	public ImageLoader() {
		
		//Main manu
		this.Menu = new ImageView(new Image(this.getClass().getResourceAsStream("BG/MenuBG.png")));
		this.GameTitle = new ImageView(new Image(this.getClass().getResourceAsStream("BG/Bullet GOD title.png")));
		this.StartGUI = new ImageView(new Image(this.getClass().getResourceAsStream("BG/Start.png")));
		this.QuitGUI = new ImageView(new Image(this.getClass().getResourceAsStream("BG/Quit.png")));
		//ClassEventmanager
		this.RedWin = new ImageView(new Image(this.getClass().getResourceAsStream("BG/RED TEAM WIN.png")));
		this.BlueWin = new ImageView(new Image(this.getClass().getResourceAsStream("BG/BLUE TEAM WIN.png")));
		this.GameBG = new ImageView(new Image(this.getClass().getResourceAsStream("BG/GameBG.png")));
		//Class Spaceship
		this.BlueShip =	 new ImageView(new Image(this.getClass().getResourceAsStream("BlueShip/Blue Ship.png")));
		this.RedShip =	new ImageView(new Image(this.getClass().getResourceAsStream("RedShip/Red Ship.png")));
		this.BlueBomb = 	new ImageView(new Image(this.getClass().getResourceAsStream("BlueShip/Blue Ship exposive.png")));
		this.RedBomb = 	new ImageView(new Image(this.getClass().getResourceAsStream("RedShip/Red Ship exposive.png")));
		
		//Class Bullet 
		this.RedBullet = new ImageView(new Image(this.getClass().getResourceAsStream("RedShip/Red Ship bullet.png")));
		this.BlueBullet = new ImageView(new Image(this.getClass().getResourceAsStream("BlueShip/Blue Ship bullet_.png")));
		this.ItemSpeed	= new ImageView(new Image(this.getClass().getResourceAsStream("Item/Item Speed.png")));
		this.ItemEnergy	= new ImageView(new Image(this.getClass().getResourceAsStream("Item/Item Energy.png")));
		this.ItemMove	= new ImageView(new Image(this.getClass().getResourceAsStream("Item/Item Move.png")));
	}

	public Object getGetClass() {
		return getClass;
	}

	public ImageView getGameTitle() {
		GameTitle.setFitHeight(200);
		GameTitle.setFitWidth(371.4285);
		GameTitle.setTranslateX(200);
		GameTitle.setTranslateY(100);
		return GameTitle;
	}

	public ImageView getMenu() {
		Menu.setFitHeight(600);
		Menu.setFitWidth(800);
		return Menu;
	}

	public ImageView getStartGUI() {
		StartGUI.setFitHeight(30);
		StartGUI.setFitWidth(150);
		return StartGUI;
	}

	public ImageView getQuitGUI() {
		QuitGUI.setFitHeight(30);
		QuitGUI.setFitWidth(150);
		return QuitGUI;
	}

	public ImageView getRedWin() {
		QuitGUI.setFitHeight(500);
		QuitGUI.setFitWidth(250);
		return RedWin;
	}

	public ImageView getBlueWin() {
		QuitGUI.setFitHeight(500);
		QuitGUI.setFitWidth(250);
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


}
