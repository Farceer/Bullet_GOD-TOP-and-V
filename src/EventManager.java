
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EventManager {

	private Pane root;
	private SpaceShip ShipLeft;
	private SpaceShip ShipRight;
	private int step;
	private final static int STEP_UP = -100;
	private final static int STEP_DOWN = 100;
	public static ArrayList<Bullet> bulletList;
	private boolean gg = true;
	// private SleepThread sleep=new SleepThread();
	// private SleepThread sleep2=new SleepThread();
	private FileInputStream ShipLeftinputstream = new FileInputStream("res/BlueShip/Blue Ship.png");
	private FileInputStream ShipRightinputstream = new FileInputStream("res/RedShip/Red Ship.png");
	private FileInputStream RedBomb = new FileInputStream("res/RedShip/Red Ship exposive.png");
	private FileInputStream BlueBomb = new FileInputStream("res/BlueShip/Blue Ship exposive.png");
	private FileInputStream BG = new FileInputStream("res/BG/Untitled-1.png");
	private FileInputStream test =new FileInputStream("res/Item/Item Energy.png");
	private Scene Gamescene;
	private Stage theStage;
	private int time1 = 0;
	private int time2 = 0;
	public static int hpOne = 10;
	public static int hpTwo = 10;
	private static int n=0;
	
	public static double energy1=100;
	public static double energy2=100;
	ProgressBar p = new ProgressBar();
	ProgressBar p2 = new ProgressBar();
	ProgressBar e1 = new ProgressBar();
	ProgressBar e2 = new ProgressBar();

	//
	private ImageView GameBG;
	//

	// getShipLeftinputstream();
	// getShipRigtinputstream();
	public EventManager(Pane root, Scene scene, Stage theStage) throws FileNotFoundException {
		this.root = root;
		Gamescene = scene;
		GameBG = new ImageView(new Image(BG));
		GameBG.setFitHeight(600);
		GameBG.setFitWidth(800);
		this.theStage = theStage;
		this.ShipLeft = new SpaceShip(120, 300, ShipLeftinputstream);
		this.ShipRight = new SpaceShip(680, 300, ShipRightinputstream);
		
		bulletList = new ArrayList<Bullet>();
	}

	void drawBoard() throws FileNotFoundException {
		this.root.getChildren().add(GameBG);
		this.root.getChildren().add(ShipLeft.getSpaceShip());
		this.root.getChildren().add(ShipRight.getSpaceShip());
		
		p.setProgress(1.0);
		p.setPrefWidth(400);
		p.setPrefHeight(30);
		p.setStyle("-fx-accent: blue;");
		;
		p.setLayoutX(0);
		p.setLayoutY(1);
		root.getChildren().add(p);
		
		p2.setProgress(1.0);
		p2.setPrefWidth(400);
		p2.setPrefHeight(30);
		p2.setStyle("-fx-accent: Red;");
		p2.setRotate(180);
		p2.setLayoutX(400);
		p2.setTranslateY(0);
		root.getChildren().add(p2);
		
		e1.setProgress(1.0);
		e1.setPrefWidth(400);
		e1.setPrefHeight(30);
		e1.setStyle("-fx-accent: Green;");
		
		e1.setLayoutX(0);
		e1.setLayoutY(30);
		
		e2.setProgress(1.0);
		e2.setPrefWidth(400);
		e2.setPrefHeight(30);
		e2.setStyle("-fx-accent: Orange;");
		e2.setRotate(180);
		e2.setLayoutX(400);
		e2.setTranslateY(30);
		root.getChildren().add(e2);
		
		
		
		root.getChildren().add(e1);
		



	}

	void MoveUnitOne(KeyEvent event) throws FileNotFoundException {

		if (event.getCode() == KeyCode.W) {
			step = STEP_UP;

		} else if (event.getCode() == KeyCode.S) {

			step = STEP_DOWN;

		}
		// ************************************* Fix Center
		// *************************************//
		if (ShipLeft.getY_axis() + step >= 100 && ShipLeft.getY_axis() + step <= 500 && step!=0 && energy1>2) {
			ShipLeft.setY_axis(ShipLeft.getY_axis() + step);
			energy1-=1;
			e1.setProgress((double) energy1/100.0);
		}

		step = 0;

		
		// sleep2.run();

	}

	void MoveUnitTwo(KeyEvent event) throws FileNotFoundException {

		if (event.getCode() == KeyCode.UP) {
			step = -100;
		} else if (event.getCode() == KeyCode.DOWN) {

			step = 100;
		}
		// ************************************* Fix Center
		// *************************************//
		if (ShipRight.getSpaceShip().getY() + step >= 100 && ShipRight.getSpaceShip().getY() + step <= 500 && step!=0 && energy2>2 ) {
			ShipRight.setY_axis(ShipRight.getY_axis() + step);
			energy2-=1;
			e2.setProgress((double) energy2/100.0);
		}

		step = 0;
		double random = Math.random() * 1900 + 1;
		if(random+n>2000)
		{	FileInputStream xy =new FileInputStream("res/Item/Item Energy.png");
			Bullet e=new Bullet(220+(new Random().nextInt(34))*10,100+new Random().nextInt(5)*100, 3, xy);
			System.out.println("xxx");
			root.getChildren().add(e.getbulletImageView());
			bulletList.add(e);
	
			n=0;
		}
		else
		{
			n+=10;
		}
		// sleep.run();

	}

	void fireOne(KeyEvent event) throws FileNotFoundException,IllegalStateException {
		if (event.getCode() == KeyCode.D && time1 != Timer.TIME && energy1>2) {
			FileInputStream inputstream = new FileInputStream("res\\BlueShip\\Blue Ship bullet_.png");
			Bullet v = new Bullet(ShipLeft.getSpaceShip().getX(), ShipLeft.getSpaceShip().getY(), 1, inputstream);
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			time1 = Timer.TIME;
			
			energy1-=2;
			e1.setProgress((double) energy1/100.0);
		} else if (event.getCode() == KeyCode.LEFT && time2 != Timer.TIME && energy2>2) {
			FileInputStream inputstream = new FileInputStream("res/RedShip/Red Ship bullet.png");
			Bullet v = new Bullet(ShipRight.getSpaceShip().getX(), ShipRight.getSpaceShip().getY(), -1, inputstream);
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			time2 = Timer.TIME;
			energy2-=2;
			e2.setProgress((double) energy2/100.0);
		}
		
		
		
		

		
	
		
		if (gg) {
			gg = false;
			
			Thread a = new Thread(() -> {
				while (true) {

					try {
						
						
						Thread.sleep(10);
						if(energy1<100)
						{
							energy1+=0.025;
						}
						if(energy2<100)
						{
							energy2+=0.025;
						}
					
						e2.setProgress((double) energy2/100.0);
						e1.setProgress((double) energy1/100.0);
						Platform.runLater(new Runnable() {

							public void run() {
								for (Bullet x : bulletList)

								{

									if (x.getbulletImageView().getX() <= 800 && x.getbulletImageView().getX() >= 0) {
										x.update();
									} else {
										x.getbulletImageView().setVisible(false);
									}

									for (Bullet y : bulletList) {
										if (y.getDirection() != x.getDirection()
												&& y.getbulletImageView().getX() == x.getbulletImageView().getX()
												&& x.getbulletImageView().getY() == y.getbulletImageView().getY()
												&& x.getbulletImageView().isVisible()
												&& y.getbulletImageView().isVisible()) {
											x.getbulletImageView().setVisible(false);
											y.getbulletImageView().setVisible(false);

											Circle rect = new Circle(x.getX_axis() + 25, x.getY_axis() + 25, 45);
											root.getChildren().add(rect);

											rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));

											FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
											ft.setFromValue(1);
											ft.setToValue(0);

											ft.play();
											if(x.getDirection()==3 || y.getDirection()==3)
											{
												if(x.getDirection()+y.getDirection()==2)
												{
													energy2+=20;
													if(energy2>100)
													{
														energy2=100;
													}
										
												}
												else
												{
													energy1+=20;
													if(energy1>100)
													{
														energy1=100;
													}
												
												}
											}

										}

									}
									if (x.getX_axis() == ShipLeft.getX_axis() && x.getY_axis() == ShipLeft.getY_axis()
											&& x.getbulletImageView().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpOne -= 1;
										if (hpOne >= 0) {
											p.setProgress((double) hpOne / 10.0);
										}

									} else if (x.getX_axis() == ShipRight.getX_axis()
											&& x.getY_axis() == ShipRight.getY_axis()
											&& x.getbulletImageView().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpTwo -= 1;
										if (hpTwo >= 0) {
											p2.setProgress((double) hpTwo / 10.0);
										}
									}

									if (hpOne <= 0 || hpTwo <= 0) {
										if (hpOne <= 0) {

											root.getChildren().add(ShipLeft.Bomb(BlueBomb));

										} else if (hpTwo <= 0) {

											root.getChildren().add(ShipRight.Bomb(RedBomb));

										}

										for (int i = bulletList.size() - 1; i != -1; i--) { // Remove all old Bullet
											bulletList.get(i).getbulletImageView().setVisible(false);
											bulletList.remove(i);
											System.out.println("Remove");

										}
										
										if (ShipLeft.isBomb() || ShipRight.isBomb()) {
											theStage.setScene(Gamescene);
											hpOne = 10;
											hpTwo = 10;
											p.setProgress(1.0);
											p2.setProgress(1.0);
											ShipLeft.BombReClaim();
											ShipRight.BombReClaim();
											ShipLeft.setBomb(false);
											ShipRight.setBomb(false);
											
											//https://github.com/Farceer/Bullet_GOD-TOP-and-V.git
											break;
										}
										

									}

								}
								for (int i = bulletList.size() - 1; i != -1; i--) {
									if (bulletList.get(i).getX_axis() >= 799 || bulletList.get(i).getX_axis() <= 0) {
										System.out.println(bulletList.size());
										bulletList.get(i).getbulletImageView().setVisible(false);
										bulletList.remove(i);
										System.out.println("xxx");

									} else {
										break;
									}
								}

							}
						});

						// ArrayList<Bullet> A=(ArrayList<Bullet>) bulletList.clone();

						// Thread.sleep(10);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
			a.start();

		}

	}

	void Bomb(double X_axis, double Y_axis, FileInputStream inputstream) {

	}

	public FileInputStream getShipLeftinputstream() {

		return ShipLeftinputstream;
	}

	public FileInputStream getShipRightinputstream() {
		return ShipRightinputstream;
	}

	public Scene getGamescene() {
		return Gamescene;
	}

	public Stage getTheStage() {
		return theStage;
	}

}
