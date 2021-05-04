import java.nio.ByteBuffer;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CanvasTest extends Application{
    private static final int RECT_WIDTH  = 20;
    private static final int RECT_HEIGHT = 20;
    
    @Override
    public void start(final Stage stage){
      final Canvas canvas = new Canvas(400, 100);
      final GraphicsContext gc = canvas.getGraphicsContext2D();

      gc.setLineWidth(2.0);
      gc.setFill(Color.RED);

      gc.strokeRoundRect(10, 10, 50, 50, 10, 10);
      gc.fillOval(70, 10, 50, 20);

      gc.strokeText("Hello Canvas", 10, 85);

      final String imagePath = "anurag_3.jpg";
      final Image image = new Image(imagePath);
      gc.drawImage(image, 130, 10, 60, 80);

      writePixels(gc);

      final Pane root = new Pane();
      root.getChildren().add(canvas);

      final Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Drawing on a Canvas");
      stage.show(); 
    }

    private void writePixels(final GraphicsContext gc){
        final byte[] pixels           = this.getPixelsData();
        final PixelWriter pixelWriter = gc.getPixelWriter();

        final PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
        final int spacing     = 5;
        final int imageWidth  = 200;
        final int imageHeight = 100;
        
        final int rows    = imageHeight / (RECT_HEIGHT + spacing);
        final int columns = imageWidth / (RECT_WIDTH + spacing);

        for(int y = 0; y < rows; ++y){
            for(int x = 0; x < columns; ++x){
                final int xPos = 200 + x * (RECT_WIDTH + spacing);
                final int yPos = y * (RECT_HEIGHT + spacing);
                pixelWriter.setPixels(
                    xPos, yPos,
                    RECT_WIDTH, RECT_HEIGHT,
                    pixelFormat, 
                    pixels, 0,
                    RECT_WIDTH * 3
                 );
            }
        }
    }

    private byte[] getPixelsData(){
        final byte[] pixels = new byte[RECT_WIDTH * RECT_HEIGHT * 3];
        final double ratio = 1.0 * RECT_HEIGHT / RECT_WIDTH;

        for(int y = 0; y < RECT_HEIGHT; ++y){
            for(int x = 0;  x < RECT_WIDTH; ++x){
                int i = y * RECT_WIDTH * 3 + x * 3;
                if( x <= y/ratio){
                    pixels[i]     = -1;
                    pixels[i + 1] = 0;
                    pixels[i + 2] = 0;
                    continue;
                } 
                pixels[i]     = 0;
                pixels[i + 1] = -1;
                pixels[i + 2] = 0;
            }
        }
        return pixels;
    }
}
