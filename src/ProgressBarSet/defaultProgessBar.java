package ProgressBarSet;

import javafx.scene.control.ProgressBar;

public class defaultProgessBar extends ProgressBar {
	private final int Height = 30;
	private final int Width = 400;
	public defaultProgessBar (String Style,double xLayout,double yLayout) {
		this.setProgress(1.0);
		this.setPrefWidth(Width);
		this.setPrefHeight(Height);
		this.setStyle(Style);
		this.setLayoutX(xLayout);
		this.setLayoutY(yLayout);
	}
}

//root.getChildren().add(p);
//
//p2.setProgress(1.0);
//p2.setPrefWidth(400);
//p2.setPrefHeight(30);
//p2.setStyle("-fx-accent: Red;");
//p2.setRotate(180);
//p2.setLayoutX(400);
//p2.setTranslateY(0);
//root.getChildren().add(p2);
//
//e1.setProgress(1.0);
//e1.setPrefWidth(400);
//e1.setPrefHeight(30);
//e1.setStyle("-fx-accent: Green;");
//
//e1.setLayoutX(0);
//e1.setLayoutY(30);
//
//e2.setProgress(1.0);
//e2.setPrefWidth(400);
//e2.setPrefHeight(30);
//e2.setStyle("-fx-accent: Orange;");
//e2.setRotate(180);
//e2.setLayoutX(400);
//e2.setTranslateY(30);
//root.getChildren().add(e2);
//
//root.getChildren().add(e1);