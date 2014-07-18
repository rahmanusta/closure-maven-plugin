package com.kodcu;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by usta on 15.07.2014.
 */
public class IOHelper {

    public static byte[] readAllBytes(Path path) {
        byte[] temp = new byte[]{};
        try {
            temp = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
