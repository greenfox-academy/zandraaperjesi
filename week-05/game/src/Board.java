import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Board extends JComponent implements KeyListener {

  int heroCoordX;
  int heroCoordY;
  String heroStance;
  Character hero = new Character();

  public Board() {
    heroCoordX = 0;
    heroCoordY = 0;
    heroStance = "hero-down.png";

    // set the size of your draw board
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    // here you have a 720x720 canvas
    // you can create and draw an image using the class below e.g.
    drawMap(graphics);
    hero.drawChar(graphics,heroCoordX, heroCoordY, heroStance);
    repaint();
  }

  public int[][] readMap(String mapName) {
    String mapPath = "assets/" + mapName;
    List<String> mapLines = new ArrayList<>();
    int[][] coords = new int[10][10];
    try {
      Path filePath = Paths.get(mapPath);
      mapLines = Files.readAllLines(filePath);
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          coords[i][j] = (int) mapLines.get(i).charAt(j) - 48;
        }
      }
    } catch (IOException ex) {
      System.out.println("couldn't open file");
    }
    return coords;
  }

  public void drawMap(Graphics graphics) {
    int[][] mapCoords = readMap("01.txt");
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (mapCoords[i][j] == 0) {
          PositionedImage image = new PositionedImage("floor.png", i * 72, j * 72);
          image.draw(graphics);
        }
        else {
          PositionedImage image = new PositionedImage("wall.png", i * 72, j * 72);
          image.draw(graphics);
        }
      }
    }
  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      heroStance = "hero-up.png";
      if(heroCoordY > 0) {
        heroCoordY -= 72;
      }
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      heroStance = "hero-down.png";
      if(heroCoordY < 648) {
        heroCoordY += 72;
      }
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      heroStance = "hero-left.png";
      if(heroCoordX > 0) {
        heroCoordX -= 72;
      }
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      heroStance = "hero-right.png";
      if(heroCoordX < 648) {
        heroCoordX += 72;
      }
    }
    // and redraw to have a new picture with the new coordinates
    repaint();
  }
}