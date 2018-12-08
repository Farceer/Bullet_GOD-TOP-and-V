
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class EventManager {
	private Class<?> EventManager;
	private Pane root;
	private int step;
	private final static int STEP_UP = -100;
	private final static int STEP_DOWN = 100;
	public static ArrayList<Bullet> bulletList;
	private boolean isThreadStart ; //gg -> ThreadStart
	// Ship
	private SpaceShip ShieBlue;
	private SpaceShip ShipRed;
	private FileInputStream ShieBlueinputstream = new FileInputStream("res/BlueShip/Blue Ship.png");
	private FileInputStream ShipRedinputstream = new FileInputStream("res/RedShip/Red Ship.png");
	// ShipEvent
	private FileInputStream RedBomb = new FileInputStream("res/RedShip/Red Ship exposive.png");
	private FileInputStream BlueBomb = new FileInputStream("res/BlueShip/Blue Ship exposive.png");

	private ImageView temp_left;
	private ImageView temp_right;

	private ImageView GameBG;

	private boolean isGameEnd;
	// Item Handle
	// private FileInputStream test =new FileInputStream("res/Item/Item
	// Energy.png");
	private String s[] = new String[] { "res/Item/Item Energy.png", "res/Item/Item Move.png",
			"res/Item/Item Speed.png" };

	private Scene Gamescene;
	private Stage theStage;
	// Timer
	private int time1 = 0;
	private int time2 = 0;
	// Game Chacractor HP
	public static int hpOne = 10;
	public static int hpTwo = 10;
	private static int n = 0;
	// Game Chacractor Energy
	public static double energy1 = 100;
	public static double energy2 = 100;
	// Progress Bar
	public static int xand = 0;
	public static int yand = 0;
	public static int fff = 0;
	public static int ggg = 0;
	public static int last1 = 0;
	public static int last2 = 0;
	ProgressBar p = new ProgressBar();
	ProgressBar p2 = new ProgressBar();
	ProgressBar e1 = new ProgressBar();
	ProgressBar e2 = new ProgressBar();
	
	public static boolean magic = true;
	private final ImageLoader loader = new ImageLoader();
	//

	//

	// getShieBlueinputstream();
	// getShipRigtinputstream();
	public EventManager(Pane root, Scene scene, Stage theStage) throws FileNotFoundException {
		this.root = root;
		Gamescene = scene;
		GameBG = getLoader().getGameBG();
		this.theStage = theStage;
		this.ShieBlue = new SpaceShip(120, 300, 1);//Blue > 0 
		this.ShipRed = new SpaceShip(680, 300, -1);//Red > 0 
		bulletList = new ArrayList<Bullet>();
		isGameEnd = false;
		isThreadStart = true ; // New gg that i hate
		
		
		
	}

	void drawBoard() throws FileNotFoundException {
		this.root.getChildren().add(GameBG);
		this.root.getChildren().add(ShieBlue.getSpaceShip());
		this.root.getChildren().add(ShipRed.getSpaceShip());

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

		if (ShieBlue.getY_axis() + step >= 100 && ShieBlue.getY_axis() + step <= 500 && step != 0 && energy1 > 2) {
			ShieBlue.setY_axis(ShieBlue.getY_axis() + step);
			energy1 -= 1;
			e1.setProgress((double) energy1 / 100.0);
		}

		step = 0;


	}

	void MoveUnitTwo(KeyEvent event) throws FileNotFoundException {

		if (event.getCode() == KeyCode.UP) {
			step = -100;
		}
		if (event.getCode() == KeyCode.DOWN) {

			step = 100;
		}
		if (ShipRed.getSpaceShip().getY() + step >= 100 && ShipRed.getSpaceShip().getY() + step <= 500 && step != 0
				&& energy2 > 2) {
			ShipRed.setY_axis(ShipRed.getY_axis() + step);
			energy2 -= 1;
			e2.setProgress((double) energy2 / 100.0);
		}

		step = 0;
		double random = Math.random() * 1900 + 1;
		if (random + n > 2000)

		{
			int rngOne2Three = new Random().nextInt(3);
			Bullet e = new Bullet(220 + (new Random().nextInt(17)) * 20, 100 + new Random().nextInt(5) * 100, 3,
					rngOne2Three);
			System.out.println("xxx");
			root.getChildren().add(e.getbulletImageView());
			bulletList.add(e);

			n = 0;
		} else {
			n += 10;
		}


	}

	void fireOne(KeyEvent event) throws FileNotFoundException, IllegalStateException {
		if (event.getCode() == KeyCode.D && (time1 < Timer.TIME || last1 > 0) && energy1 > 2) {

			FileInputStream inputstream = new FileInputStream("res\\BlueShip\\Blue Ship bullet_.png");
			Bullet v = new Bullet(ShieBlue.getSpaceShip().getX(), ShieBlue.getSpaceShip().getY(), 1, true); // true is blue // false is red
			if (last1 > 0)
				v.setSpeed(2);
			else
				v.setSpeed(1);
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			if (fff > 0) {
				double hi = ShieBlue.getSpaceShip().getY() - 100;
				if (hi == 0) {
					hi -= 100;
				}

				Bullet vv = new Bullet(ShieBlue.getSpaceShip().getX(), ShieBlue.getSpaceShip().getY() + 100, 1,true);
				Bullet vvv = new Bullet(ShieBlue.getSpaceShip().getX(), hi, 1,true);
				vv.setSpeed(v.getSpeed());
				vvv.setSpeed(v.getSpeed());
				bulletList.add(vv);
				bulletList.add(vvv);
				root.getChildren().addAll(vv.getbulletImageView(), vvv.getbulletImageView());
			}

			time1 = Timer.TIME;

			energy1 -= 2;
			e1.setProgress((double) energy1 / 100.0);

		}
		if (event.getCode() == KeyCode.LEFT && (time2 < Timer.TIME || last2 > 0) && energy2 > 2) {
			Bullet v = new Bullet(ShipRed.getSpaceShip().getX(), ShipRed.getSpaceShip().getY(), -1, false);
			if (last2 > 0)
				v.setSpeed(2);
			else
				v.setSpeed(1);
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			if (ggg > 0) {
				Bullet vv = new Bullet(ShipRed.getSpaceShip().getX(), ShipRed.getSpaceShip().getY() + 100, -1, false);
				double hi = ShipRed.getSpaceShip().getY() - 100;
				if (hi == 0) {
					hi -= 100;
				}

				Bullet vvv = new Bullet(ShipRed.getSpaceShip().getX(), hi, -1,false);
				vv.setSpeed(v.getSpeed());
				vvv.setSpeed(v.getSpeed());
				bulletList.add(vv);
				bulletList.add(vvv);
				root.getChildren().addAll(vv.getbulletImageView(), vvv.getbulletImageView());
			}
			time2 = Timer.TIME;

			energy2 -= 2;
			e2.setProgress((double) energy2 / 100.0);

		}

		if (isThreadStart) {
			isThreadStart = false;
			
			Thread a = new Thread(() -> {
				while (true) {

					try {

						fff -= 10;
						ggg -= 10;
						yand -= 1;
						xand -= 1;
						last1 -= 1;
						last2 -= 1;
						Thread.sleep(15);

						if (energy1 < 100) {
							energy1 += 0.1;
						}
						if (energy2 < 100) {
							energy2 += 0.1;
						}

						e2.setProgress((double) energy2 / 100.0);
						e1.setProgress((double) energy1 / 100.0);
						Platform.runLater(new Runnable() {

							public void run() {
								for (Bullet x : bulletList)

								{
									if (yand > 0 && x.getDirection() == 1) {
										double aaa = 500 - x.getX_axis();
										if (aaa < 0) {
											aaa = 0;
										}
										x.getbulletImageView().setScaleX(aaa / 680.0);
										x.getbulletImageView().setScaleY(aaa / 680.0);

									}

									if (xand > 0 && x.getDirection() == -1) {
										double aaa = x.getX_axis() - 300;
										if (aaa < 0) {
											aaa = 0;
										}
										x.getbulletImageView().setScaleX(aaa / 680.0);
										x.getbulletImageView().setScaleY(aaa / 680.0);

									}
									
									if (x.getbulletImageView().getX() <= 800 && x.getbulletImageView().getX() >= 0) {
										x.update();
									} else {
										x.getbulletImageView().setVisible(false);
									}

									for (Bullet y : bulletList) {
										if (y.getDirection() != x.getDirection()
												&& Math.abs(y.getbulletImageView().getX()
														- x.getbulletImageView().getX()) <= 10
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
											bulletList.remove(x);
											bulletList.remove(y);

											//// item hit////
											if (x.getDirection() == 3 || y.getDirection() == 3) {
												if (x.getDirection() + y.getDirection() == 2) {
													energy2 += 20;
													if (energy2 > 100) {
														energy2 = 100;
													}

												} else {
													energy1 += 20;
													if (energy1 > 100) {
														energy1 = 100;
													}

												}

												if (x.type + y.type == 1) {
													if (x.getDirection() + y.getDirection() != 2) {
														fff = 2000;
													} else {
														ggg = 2000;
													}

												}
												if (x.type + y.type == 2) {
													if (x.getDirection() + y.getDirection() != 2) {
														yand = 1000;

													} else if (xand <= 0) {
														/* asd */ xand = 1000;

													}

												} else if (x.type + y.type == 0) {
													if (x.getDirection() + y.getDirection() != 2) {
														last1 = 200;
													} else {
														last2 = 200;
													}
												}

											}

										}

									}

									if (x.getX_axis() == ShieBlue.getX_axis() && x.getY_axis() == ShieBlue.getY_axis()
											&& x.getbulletImageView().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpOne -= 1;
										if (hpOne >= 0) {
											p.setProgress((double) hpOne / 10.0);
										}

									} else if (x.getX_axis() == ShipRed.getX_axis()
											&& x.getY_axis() == ShipRed.getY_axis()
											&& x.getbulletImageView().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpTwo -= 1;
										if (hpTwo >= 0) {
											p2.setProgress((double) hpTwo / 10.0);
										}
									}
									// BOMB //

									if (hpOne <= 0 || hpTwo <= 0) {
										if (hpOne <= 0) {
											temp_left = ShieBlue.Bomb() ;
											root.getChildren().add(temp_left);
											if (  ShieBlue.isBomb() ) {
												root.getChildren().remove(temp_left);
												ShieBlue.BombReClaim();
												theStage.setScene(Gamescene);
											}
										} else if (hpTwo <= 0) {
											temp_right = ShipRed.Bomb() ;
											root.getChildren().add(temp_right);
											if ( ShipRed.isBomb()) {
												root.getChildren().remove(temp_right);
												ShipRed.BombReClaim();
												theStage.setScene(Gamescene);
											}
											
										}
										if ( ShipRed.isBomb() ||  ShieBlue.isBomb()) {
											theStage.setScene(Gamescene);
											hpOne = 10;
											hpTwo = 10;
											p.setProgress(1.0);
											p2.setProgress(1.0);
											break;
										}
											
										
									}
									// BOMB //

									for (int i = bulletList.size() - 1; i != -1; i--) {
										if (bulletList.get(i).getX_axis() >= 799
												|| bulletList.get(i).getX_axis() <= 0) {
											System.out.println(bulletList.size());
											bulletList.get(i).getbulletImageView().setVisible(false);
											bulletList.remove(i);
											System.out.println("xxx");

										} else {
											break;
										}
									}
								}
							}
						});

						// ArrayList<Bullet> A=(ArrayList<Bullet>) bulletList.clone();

						// Thread.sleep(10);

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					

//					if (ShieBlue.isBomb() || ShipRed.isBomb()) {
//						theStage.setScene(Gamescene);
//						hpOne = 10;
//						hpTwo = 10;
//						p.setProgress(1.0);
//						p2.setProgress(1.0);
//						ShieBlue.BombReClaim();
//						ShipRed.BombReClaim();
//						for (int i = bulletList.size() - 1; i != -1; i--) { // Remove all old Bullet
//							bulletList.get(i).getbulletImageView().setVisible(false);
//							bulletList.remove(i);
//							System.out.println("Remove");
//
//						}
//					}
				}
			});

			a.start();

		}

	}


	public Scene getGamescene() {
		return Gamescene;
	}

	public Stage getTheStage() {
		return theStage;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public ImageLoader getLoader() {
		return loader;
	}

}
