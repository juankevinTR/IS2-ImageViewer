package com.juankevintrujillo.persistence;

import com.juankevintrujillo.model.Image;

import java.io.*;

public class FileImageLoader implements ImageLoader {
    private final File[] files;
    private final static String[] imageExtensions = new String[]{"jpg", "png", "bmp"};

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return files[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream(new FileInputStream(files[i]));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return i == files.length - 1 ? imageAt(0) : imageAt(i + 1);
            }

            @Override
            public Image prev() {
                return i == 0 ? imageAt(files.length - 1) : imageAt(i - 1);
            }
        };
    }

    private FilenameFilter withImageExtension() {

        return (dir, name) -> {
            for (String extension : imageExtensions) {
                if (name.endsWith(extension)) return true;
            }
            return false;
        };
    }
}

