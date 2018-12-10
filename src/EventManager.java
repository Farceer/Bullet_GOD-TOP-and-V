

import java.io.FileNotFoundException;
import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EventManager {

	private Pane root;
	private SpaceShip ShipBlue;
	private SpaceShip ShipRed;
	private int step;
	private final static int STEP_UP = -100;
	private final static int STEP_DOWN = 100;
	public static ArrayList<Bullet> bulletList;
	private boolean gg = true;


	private boolean isGameEnd;
	private String s[] = new String[] { "Item/ItemEnergy.png", "Item/ItemMachineGun.png",
			"Item/ItemSpeed.png" };
	private Pane root1;
	private Pane root2;
	
	private Scene Gamescene;
	private Stage theStage;
	
	private Scene RedWin;
	private Scene BlueWin;
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
	//************************************************ Plz fix by using  ProgressBarSet ************************************//
	public static int Red_Immune_State = 0;
	public static int Blue_Immune_state = 0;
	public static int Blue_Mutiple_State = 0;
	public static int Red_Mutiple_State = 0;
	public static int BlueBullet_Speed_State = 0;
	public static int RedBullet_Speed_State = 0;
	ProgressBar p = new ProgressBar();
	ProgressBar p2 = new ProgressBar();
	ProgressBar e1 = new ProgressBar();
	ProgressBar e2 = new ProgressBar();

	//************************************************ Plz fix by using  ProgressBarSet ************************************//

	public EventManager(Pane root, Scene scene, Stage theStage,Scene Red,Scene Blue,Pane R,Pane B) throws FileNotFoundException {
		root1=R;
		root2=B;
		RedWin=Red;
		BlueWin=Blue;
		this.root = root;
		Gamescene = scene;
		ResouceLoader loadGameBG = new ResouceLoader();
		ImageView GameBG = loadGameBG.getGameBG();

		this.theStage = theStage;
		this.ShipBlue = new SpaceShip(120, 300, true);
		this.ShipRed = new SpaceShip(680, 300, false);

		bulletList = new ArrayList<Bullet>();
		isGameEnd = false;
		
		
		//Draw Borad
		this.root.getChildren().add(GameBG);
		this.root.getChildren().add(ShipBlue.getSpaceShip());
		this.root.getChildren().add(ShipRed.getSpaceShip());
//************************************************ Plz fix by using  ProgressBarSet ************************************//
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
//************************************************ Plz fix by using  ProgressBarSet ************************************//
	}


	void MoveUnitOne(KeyEvent event) throws FileNotFoundException {

		if (event.getCode() == KeyCode.W) {
			step = STEP_UP;

		} else if (event.getCode() == KeyCode.S) {

			step = STEP_DOWN;

		}

		if (ShipBlue.getY_axis() + step >= 100 && ShipBlue.getY_axis() + step <= 500 && step != 0 && energy1 > 2) {
			ShipBlue.setY_axis(ShipBlue.getY_axis() + step);
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
			int bb = new Random().nextInt(3);
			String xy = new String(s[bb]);
			Potion e = new Potion(220 + (new Random().nextInt(17)) * 20, 100+25 + new Random().nextInt(5) * 100, 3, xy,bb);
			System.out.println("xxx");
			root.getChildren().add(e.getbulletImageView());
			bulletList.add(e);

			n = 0;
		} else {
			n += 10;
		}

	}

	void fireOne(KeyEvent event) throws FileNotFoundException, IllegalStateException  , ConcurrentModificationException ,ClassCastException {
		if (event.getCode() == KeyCode.D && (time1 < Timer.TIME || BlueBullet_Speed_State > 0) && energy1 > 5) {

			Bullet v,vv,vvv;
			double hi = ShipBlue.getSpaceShip().getY() - 100;
			if (hi == 0) {
				hi -= 100;
			}
			if (BlueBullet_Speed_State > 0) {
				v = new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25, 1);
				vv=  new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25+100, 1);
				vvv = new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, hi+25, 1);
			}
			else {
				v = new Bullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25, 1);
				vv=  new Bullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25+100, 1);
				vvv = new Bullet(ShipBlue.getSpaceShip().getX()+25, hi+25, 1);
			}
				
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			if (Blue_Mutiple_State > 0) {
				
				bulletList.add(vv);
				bulletList.add(vvv);
				root.getChildren().addAll(vv.getbulletImageView(), vvv.getbulletImageView());
			}

			time1 = Timer.TIME;

			energy1 -= 5;
			e1.setProgress((double) energy1 / 100.0);

		}
		if (event.getCode() == KeyCode.LEFT && (time2 < Timer.TIME || RedBullet_Speed_State > 0) && energy2 > 5) {
			Bullet v,vv,vvv;
			double hi = ShipRed.getSpaceShip().getY() - 100;
			if (hi == 0) {
				hi -= 100;
			}
			if (RedBullet_Speed_State > 0) {
				v = new SpeedBullet(ShipRed.getSpaceShip().getX()-25, ShipRed.getSpaceShip().getY()+25, -1);
				vv=  new SpeedBullet(ShipRed.getSpaceShip().getX()-25, ShipRed.getSpaceShip().getY()+25+100, -1);
				vvv = new SpeedBullet(ShipRed.getSpaceShip().getX()-25, hi+25, -1);
			}
			else {
				v = new Bullet(ShipRed.getSpaceShip().getX()-25, ShipRed.getSpaceShip().getY()+25, -1);
				vv=  new Bullet(ShipRed.getSpaceShip().getX()-25, ShipRed.getSpaceShip().getY()+25+100, -1);
				vvv = new Bullet(ShipRed.getSpaceShip().getX()-25, hi+25, -1);
			}
				
			bulletList.add(v);
			root.getChildren().add(v.getbulletImageView());
			if (Red_Mutiple_State > 0) {
				
				bulletList.add(vv);
				bulletList.add(vvv);
				root.getChildren().addAll(vv.getbulletImageView(), vvv.getbulletImageView());
			}
			time2 = Timer.TIME;

			energy2 -= 5;
			e2.setProgress((double) energy2 / 100.0);

		}

		if (gg) {
			gg = false;
			
			Thread a = new Thread(() -> {
				while (true) {
					//************************************************ Plz fix by using  ProgressBarSet ************************************//
					try {

						Blue_Mutiple_State -= 10;
						Red_Mutiple_State -= 10;
						Blue_Immune_state -= 1;
						Red_Immune_State -= 1;
						BlueBullet_Speed_State -= 1;
						RedBullet_Speed_State -= 1;
						Thread.sleep(15);

						if (energy1 < 100) {
							energy1 += 0.1;
						}
						if (energy2 < 100) {
							energy2 += 0.1;
						}

						e2.setProgress((double) energy2 / 100.0);
						e1.setProgress((double) energy1 / 100.0);
						//************************************************ Plz fix by using  ProgressBarSet ************************************//
						Platform.runLater(new Runnable() {

							public void run() {
								for (Bullet x : bulletList)

								{
									if (Blue_Immune_state > 0 ) {
										ShipBlue.getSpaceShip().setVisible(false);
									}
									else {
										ShipBlue.getSpaceShip().setVisible(true);
									}

									
									if (Red_Immune_State > 0 ) {
										ShipRed.getSpaceShip().setVisible(false);
									}
									else {
										ShipRed.getSpaceShip().setVisible(true);
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

												if (x.getType() + y.getType() == 1) {
													if (x.getDirection() + y.getDirection() != 2) {
														Blue_Mutiple_State = 2000;
													} else {
														Red_Mutiple_State = 2000;
													}

												}
												if (x.getType() + y.getType() == 2) {
													if (x.getDirection() + y.getDirection() != 2) {
														Blue_Immune_state = 200;

													} else if (Red_Immune_State <= 0) {
														/* asd */ Red_Immune_State = 200;

													}

												} else if (x.getType() + y.getType() == 0) {
													if (x.getDirection() + y.getDirection() != 2) {
														BlueBullet_Speed_State = 150;
													} else {
														RedBullet_Speed_State = 150;
													}
												}

											}

										}

									}

									if (Math.abs(x.getX_axis() - ShipBlue.getX_axis()+25) <50 && x.getY_axis() == ShipBlue.getY_axis()+25
											&& x.getbulletImageView().isVisible() &&
											ShipBlue.getSpaceShip().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpOne -= 1;
										Circle rect = new Circle(x.getX_axis(), x.getY_axis()+10 , 10000);
										root.getChildren().add(rect);

										rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));

										FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
										ft.setFromValue(1);
										ft.setToValue(0);

										ft.play();
										bulletList.remove(x);
								
										if (hpOne >= 0) {
											p.setProgress((double) hpOne / 10.0);
										}
										

									} else if (Math.abs(x.getX_axis() - ShipRed.getX_axis()-25)<50
											&& x.getY_axis() == ShipRed.getY_axis()+25
											&& x.getbulletImageView().isVisible()
											&& ShipRed.getSpaceShip().isVisible()) {
										x.getbulletImageView().setVisible(false);
										hpTwo -= 1;
										Circle rect = new Circle(x.getX_axis()-20, x.getY_axis()+10, 10000);
										root.getChildren().add(rect);

										rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));

										FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
										ft.setFromValue(1);
										ft.setToValue(0);

										ft.play();
			
										if (hpTwo >= 0) {
											p2.setProgress((double) hpTwo / 10.0);
										}
									}
									// BOMB //

									if (hpOne <= 0 || hpTwo <= 0) {
										
										
										if (hpOne <= 0) {
											
											ShipBlue.getSpaceShip().setVisible(false);
											ShipBlue.setBomb(true);
											

										} else if (hpTwo <= 0) {
											
											ShipRed.getSpaceShip().setVisible(false);
											ShipRed.setBomb(true);
											

										}

										for (int i = bulletList.size() - 1; i != -1; i--) { // Remove all old Bullet
											bulletList.get(i).getbulletImageView().setVisible(false);
											bulletList.remove(i);
											System.out.println("Remove");

										}
										
										if (ShipBlue.isBomb() || ShipRed.isBomb()) {

											if(ShipBlue.isBomb())
											{
												theStage.setScene(RedWin);
												root1.getChildren().add( (Group)ShipBlue.Bomb());
												hpOne = 10;
												hpTwo = 10;
												energy1=100;
												energy2=100;
												p.setProgress(1.0);
												p2.setProgress(1.0);
												ShipBlue.BombReset();
												ShipRed.BombReset();
											}
											else
											{
												theStage.setScene(BlueWin);
												root2.getChildren().add((Group) ShipRed.Bomb());
												hpOne = 10;
												hpTwo = 10;
												energy1=100;
												energy2=100;
												p.setProgress(1.0);
												p2.setProgress(1.0);
												ShipBlue.BombReset();
												ShipRed.BombReset();
											}
											Red_Immune_State = 0;
											Blue_Immune_state = 0;
											Blue_Mutiple_State = 0;
											Red_Mutiple_State = 0;
											BlueBullet_Speed_State = 0;
											RedBullet_Speed_State = 0;
	
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

								}}
							
						});


					} catch (Exception e) {
						e.getStackTrace();
					}
					

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

}
