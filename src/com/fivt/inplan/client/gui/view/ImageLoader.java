package com.fivt.inplan.client.gui.view;

import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {
	public static void loadImage(String path, ImageView target) {
		try {
			File file = new File(path);
		    String localUrl = file.toURI().toURL().toString();
		    Image localImage = new Image(localUrl, false);
		    target.setImage(localImage);
		} catch (IOException e) {
			//do nothing
		}
	}
}
