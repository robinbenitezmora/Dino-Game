import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

class Game extends Frame implements KeyListener {
 final int D_W = 1200;
 final int D_H = 800;
 static int unit = 10;

 Color colorDinosaur = Color.GRAY;
 Color colorGameOver1 = Color.BLACK;
 Color colorGameOver2 = Color.YELLOW;
 Color colorCactus1 = Color.GRAY;
 Color colorCactus2 = Color.BLACK;

 int jump = 0;
 int jumpY = 0;
 int y = 0;
 boolean onEnterPresses = false;
 boolean down = false;
 List<MyGraph> MyGraphs = new ArrayList<>();
 int currentDinosaurX = 0;
 int currentDinosaurY = 0;
 boolean gameOver = false;
 DrawPanel drawPanel = new DrawPanel();

 public static void main(String args[]) {
  new Game();
 }

 public Game() {
  super("Dinosaur Game");
  setSize(1200, 550);
  setVisible(true);
  addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
    dispose();
    System.exit(0);
   }
  });

  addKeyListener(this);
  initCactusG();

  ActionListener listener = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if (gameOver) {
     if (jump >= D_W) {
      jump = 0;
      initCactusG();
      drawPanel repaint();
     } else {
      jumpY += 20;
     } 
    }if(jumpY>=280)

 {
  down = true;
 }if(jumpY<=0)
 {
  onEnterPresses = false;
  down = false;
  jumpY = 0;
 }
}}}