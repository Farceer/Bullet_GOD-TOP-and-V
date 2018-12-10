

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import ProgressBarSet.defaultProgessBar;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Group;
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

	
	private SpaceShip ShipBlue,ShipRed;
	private int step;
	private final static int STEP_UP = -100;
	private final static int STEP_DOWN = 100;
	private boolean isTheardStart ;
	private Pane rootPane,rootRedPane,rootBluePane;
	private Scene Gamescene,RedWin,BlueWin;
	private Stage theStage;
	public static ArrayList<Bullet> bulletList;
	// Timer
	private int time1 = 0;
	private int time2 = 0;
	private static int n = 0 ;

	// Progress Bar
	private static int Red_Immune_State = 0;
	private static int Blue_Immune_State = 0;
	private static int Blue_Mutiple_State = 0;
	private static int Red_Mutiple_State = 0;
	private static int BlueBullet_Speed_State = 0;
	private static int RedBullet_Speed_State = 0;
	private ProgressBar blueShipHealthBar ,redShipHealthBar,blueShipEnergyBar,redShipEnergyBar ;



	public EventManager(Pane rootPane, Scene scene, Stage theStage,Scene Red,Scene Blue,Pane RedPane,Pane BluePane) throws FileNotFoundException {
		this.rootRedPane=RedPane;
		this.rootBluePane=BluePane;
		this.RedWin=Red;
		this.BlueWin=Blue;
		this.rootPane = rootPane;
		this.Gamescene = scene;
		ResouceLoader loadGameBG = new ResouceLoader();
		ImageView GameBG = loadGameBG.getGameBG();
		this.theStage = theStage;
		this.ShipBlue = new SpaceShip(120, 300, true);
		this.ShipRed = new SpaceShip(680, 300, false);
		bulletList = new ArrayList<Bullet>();
		isTheardStart = true;
		 blueShipHealthBar  = new  defaultProgessBar("-fx-accent: blue;", 0, 1)   ;
		 blueShipEnergyBar  = new  defaultProgessBar("-fx-accent: Green;", 0, 30)  ;
		 redShipHealthBar    = new  defaultProgessBar("-fx-accent: Red;", 400, 0)  ; 
		 redShipHealthBar.setRotate(180);
		 redShipEnergyBar     = new  defaultProgessBar("-fx-accent: Orange;", 400, 30)  ;
		 redShipEnergyBar.setRotate(180);
		//Draw Borad
		 this.rootPane.getChildren().addAll(GameBG,ShipBlue.getSpaceShip(),ShipRed.getSpaceShip(),blueShipHealthBar,blueShipEnergyBar,redShipHealthBar, redShipEnergyBar);
	}


	void MoveUnitOne(KeyEvent event) throws FileNotFoundException {
	
		if (event.getCode() == KeyCode.W) {
			step = STEP_UP;

		} else if (event.getCode() == KeyCode.S) {

			step = STEP_DOWN;

		}

		if (ShipBlue.getY_axis() + step >= 100 && ShipBlue.getY_axis() + step <= 500 && step != 0 && ShipBlue.getEnergy() > 2) {
			ShipBlue.setY_axis(ShipBlue.getY_axis() + step);
			ShipBlue.setEnergy(ShipBlue.getEnergy()-1);
			blueShipEnergyBar.setProgress((double) ShipBlue.getEnergy() / 100.0);
			
			potionRng();
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
				&& ShipRed.getEnergy() > 2) {
			ShipRed.setY_axis(ShipRed.getY_axis() + step);
			ShipRed.setEnergy(ShipRed.getEnergy()-1);
			redShipEnergyBar.setProgress((double) ShipRed.getEnergy() / 100.0);
			potionRng();
		
		}

		step = 0;


	}

	void fireOne(KeyEvent event) throws FileNotFoundException, IllegalStateException  , ConcurrentModificationException ,ClassCastException {
		if (event.getCode() == KeyCode.D && (time1 < Timer.TIME || BlueBullet_Speed_State > 0) && ShipBlue.getEnergy() > 5) {
			
			Bullet v,vv,vvv;
			potionRng();
			double hi = ShipBlue.getSpaceShip().getY() - 100;
			if (hi == 0) {
				hi -= 100;
			}
			if (BlueBullet_Speed_State > 0) {
				v = new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25, 1);
				vv=  new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25+100, 1);
				vvv = new SpeedBullet(ShipBlue.getSpaceShip().getX()+25, hi+25, 1);
			}
			else {	potionRng();
				v = new Bullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25, 1);
				vv=  new Bullet(ShipBlue.getSpaceShip().getX()+25, ShipBlue.getSpaceShip().getY()+25+100, 1);
				vvv = new Bullet(ShipBlue.getSpaceShip().getX()+25, hi+25, 1);
			}
				
			bulletList.add(v);
			rootPane.getChildren().add(v.getImageView());
			if (Blue_Mutiple_State > 0) {
				
				bulletList.add(vv);
				bulletList.add(vvv);
				rootPane.getChildren().addAll(vv.getImageView(), vvv.getImageView());
			}
			if(Blue_Immune_State<0)
			{
				time1 = Timer.TIME;
				ShipBlue.setEnergy(ShipBlue.getEnergy()-3);
			}
		
			blueShipEnergyBar.setProgress((double) ShipBlue.getEnergy() / 100.0);

		}
		if (event.getCode() == KeyCode.LEFT && (time2 < Timer.TIME || RedBullet_Speed_State > 0) && ShipRed.getEnergy() > 5) {
			Bullet v,vv,vvv;
			potionRng();
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
			rootPane.getChildren().add(v.getImageView());
			if (Red_Mutiple_State > 0) {
			
				bulletList.add(vv);
				bulletList.add(vvv);
				rootPane.getChildren().addAll(vv.getImageView(), vvv.getImageView());
			}
			if(Red_Immune_State<=0)
			{
			time2 = Timer.TIME;

			ShipRed.setEnergy(ShipRed.getEnergy()-3); 
			}
			redShipEnergyBar.setProgress((double) ShipRed.getEnergy() / 100.0);

		}

		if (isTheardStart) {
			isTheardStart = false;
			
			Thread a = new Thread(() -> {
				while (true) {
					try {

						Blue_Mutiple_State -= 10;
						Red_Mutiple_State -= 10;
						Red_Immune_State -=1;
						Blue_Immune_State -=1;
						BlueBullet_Speed_State -= 1;
						RedBullet_Speed_State -= 1;
						Thread.sleep(15);
						
						
						if (ShipBlue.getEnergy() < 100) {
							ShipBlue.setEnergy(ShipBlue.getEnergy()+0.1); 
						}
						if (ShipRed.getEnergy() < 100) {
							ShipRed.setEnergy(ShipRed.getEnergy()+0.1); 
						}
						blueShipEnergyBar.setProgress((double) ShipBlue.getEnergy()  / 100.0);
						redShipEnergyBar.setProgress((double) ShipRed.getEnergy() / 100.0);
						Platform.runLater(new Runnable() {

							public void run() {
								for (Bullet x : bulletList)

								{
									

									
									
									if (x.getImageView().getX() <= 800 && x.getImageView().getX() >= 0) {
										x.update();
									} else {
										x.getImageView().setVisible(false);
									}

									for (Bullet y : bulletList) {
										if (y.getDirection() != x.getDirection()
												&& Math.abs(y.getImageView().getX()
														- x.getImageView().getX()) <= 10
												&& x.getImageView().getY() == y.getImageView().getY()
												&& x.getImageView().isVisible()
												&& y.getImageView().isVisible()) {
											
											x.Bomb();
											y.Bomb();
											rootPane.getChildren().add(y.Bomb());
											bulletList.remove(x);
											bulletList.remove(y);

											//// item hit////
											if (x.getDirection() == 3 || y.getDirection() == 3) {
												if (x.getDirection() + y.getDirection() == 2) {
													ShipRed.setEnergy(ShipRed.getEnergy()+20); 


												} else {
													ShipBlue.setEnergy(ShipBlue.getEnergy()+20);


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
														Blue_Immune_State = 150;

													} else if (Red_Immune_State <= 0) {
														/* asd */ Red_Immune_State = 150;

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
											&& x.getImageView().isVisible() 
											) {
										ShipBlue.setHp(ShipBlue.getHp()-1);
								
										Circle rect = new Circle(x.getX_axis(), x.getY_axis()+10 , 10000);
										rootPane.getChildren().add(rect);
										rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
										FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
										ft.setFromValue(1);
										ft.setToValue(0);

										ft.play();
										x.Bomb();
										bulletList.remove(x);
										
										if (ShipBlue.getHp() >= 0) {
											blueShipHealthBar.setProgress((double) ShipBlue.getHp() / 10.0);
										}
										

									} else if (Math.abs(x.getX_axis() - ShipRed.getX_axis()-25)<50
											&& x.getY_axis() == ShipRed.getY_axis()+25
											&& x.getImageView().isVisible()
										) {
										
										ShipRed.setHp(ShipRed.getHp()-1);
										x.Bomb();
										Circle rect = new Circle(x.getX_axis()-20, x.getY_axis()+10, 10000);
										rootPane.getChildren().add(rect);

										rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));

										FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
										ft.setFromValue(1);
										ft.setToValue(0);

										ft.play();
										bulletList.remove(x);
			
										if (ShipRed.getHp() >= 0) {
											redShipHealthBar.setProgress((double) ShipRed.getHp()  / 10.0);
										}
									}

									if (ShipRed.getHp()  <= 0 || ShipBlue.getHp() <= 0) {
										
										
										if (ShipBlue.getHp() <= 0) {
											
											ShipBlue.getSpaceShip().setVisible(false);
											ShipBlue.setBomb(true);
											

										} else if (ShipRed.getHp() <= 0) {
											
											ShipRed.getSpaceShip().setVisible(false);
											ShipRed.setBomb(true);
											

										}

										for (int i = bulletList.size() - 1; i != -1; i--) { // Remove all old Bullet
											bulletList.get(i).getImageView().setVisible(false);
											bulletList.remove(i);
											System.out.println("Remove");

										}
										
										if (ShipBlue.isBomb() || ShipRed.isBomb()) {

											if(ShipBlue.isBomb())
											{
												theStage.setScene(RedWin);
												rootRedPane.getChildren().add( (Group)ShipBlue.Bomb());
												blueShipHealthBar.setProgress(1.0);
												redShipHealthBar.setProgress(1.0);
												ShipBlue.BombReset();
												ShipRed.BombReset();
											}
											else
											{
												theStage.setScene(BlueWin);
												rootBluePane.getChildren().add((Group) ShipRed.Bomb());
												blueShipHealthBar.setProgress(1.0);
												redShipHealthBar.setProgress(1.0);
												ShipBlue.BombReset();
												ShipRed.BombReset();
											}
											Red_Immune_State = 0;
											Blue_Immune_State = 0;
											Blue_Mutiple_State = 0;
											Red_Mutiple_State = 0;
											BlueBullet_Speed_State = 0;
											RedBullet_Speed_State = 0;
	
										}
										

									}

									for (int i = bulletList.size() - 1; i != -1; i--) {
										if (bulletList.get(i).getX_axis() >= 799
												|| bulletList.get(i).getX_axis() <= 0) {
											System.out.println(bulletList.size());
											bulletList.get(i).getImageView().setVisible(false);
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

	@SuppressWarnings("unused")
	private void potionRng() throws FileNotFoundException {
		double random = Math.random() * 1900 + 1;
		if (random + n > 2000)

		{
			int Rng = new Random().nextInt(3);
			Bullet e = new Potion(220 + (new Random().nextInt(17)) * 20, 100+25 + new Random().nextInt(5) * 100, 3,Rng);
			rootPane.getChildren().add(e.getImageView());
			bulletList.add(e);

			n = 0;
		} else {
			n += 10;
		}
	}

}
