package warehouse.infrastructure.Services;


import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Component
public class ImageProcessor {

    public byte[] loadImageFromFileToByteArray(String path) throws IOException {
        BufferedImage img = null;
        byte[] imageInByte;
        img = ImageIO.read(new File(path));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        baos.flush();
        imageInByte = baos.toByteArray();
        baos.close();

        return imageInByte;
    }

    public BufferedImage loadByteArrayToImage(byte[] byteArray) throws IOException {
        InputStream in = new ByteArrayInputStream(byteArray);
        return ImageIO.read(in);
    }
}
