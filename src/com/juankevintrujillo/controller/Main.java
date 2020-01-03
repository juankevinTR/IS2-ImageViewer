package com.juankevintrujillo.controller;

import com.juankevintrujillo.model.Image;
import com.juankevintrujillo.persistence.FileImageLoader;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getenv().get("HOME") + "/Documents/src/java-projects/ImageViewer/images/");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
