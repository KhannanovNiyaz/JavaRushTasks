package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Нияз on 12.05.2018.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types) throws IllegalArgumentException {
        ImageReader it = null;
        if (types == ImageTypes.BMP) {
            it = new BmpReader();
        } else if (types == ImageTypes.JPG) {
            it = new JpgReader();
        } else if (types == ImageTypes.PNG) {
            it = new PngReader();
        }
        if (it == null) {
            throw new IllegalArgumentException();
        }
        return it;
    }
}
