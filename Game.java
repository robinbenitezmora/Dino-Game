import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javax.swing.Timer;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Import the ActionListener class
import java.awt.event.KeyListener;

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
      setSize(D_W, D_H);
      setResizable(false);
      setVisible(true);
      addKeyListener(this);
      add(drawPanel);
      drawPanel.setBackground(Color.WHITE);
      drawPanel.repaint();
      Timer timer = new Timer(100, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (onEnterPresses) {
               if (jump == 0) {
                  if (down) {
                     if (currentDinosaurY < D_H - 100) {
                        currentDinosaurY += 10;
                     } else {
                        down = false;
                     }
                  } else {
                     if (currentDinosaurY > 0) {
                        currentDinosaurY -= 10;
                     } else {
                        down = true;
                     }
                  }
               } else {
                  if (jumpY < 100) {
                     currentDinosaurY -= 10;
                     jumpY += 10;
                  } else {
                     jump = 0;
                     jumpY = 0;
                  }
               }
               for (MyGraph MyGraph : MyGraphs) {
                  if (MyGraph.x > 0) {
                     MyGraph.x -= 10;
                  } else {
                     MyGraph.x = D_W;
                  }
                  if (MyGraph.x == currentDinosaurX && MyGraph.y == currentDinosaurY) {
                     gameOver = true;
                  }
               }
               drawPanel.repaint();
            }
         }
      });
      timer.start();
   }

   @Override
   public void keyPressed(java.awt.event.KeyEvent e) {
      if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
         onEnterPresses = true;
      }
      if (e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
         if (jump == 0) {
            jump = 1;
         }
      }
   }

   @Override
   public void keyReleased(java.awt.event.KeyEvent e) {
      if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      onEnterPresses = false;
      }
   }
