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
