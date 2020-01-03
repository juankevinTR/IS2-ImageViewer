package com.juankevintrujillo.ui;

import com.juankevintrujillo.model.Image;

public interface ImageDisplay {
    Image current();

    void show(Image image);
}
