package com.juankevintrujillo.controller;

import com.juankevintrujillo.model.Image;
import com.juankevintrujillo.persistence.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        FileImageLoader imageLoader = new FileImageLoader("images");
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
