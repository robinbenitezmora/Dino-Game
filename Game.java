import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javax.swing.Timer;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Import the ActionListener class
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Color;
import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics; // Add missing import statement
import java.awt.Graphics; // Add missing import statement

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
      // ...

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

   @Override
   public void keyTyped(java.awt.event.KeyEvent e) {
   }

   class DrawPanel extends Component {
      public void paint(Graphics g) {
         // ...

         // ...

         g2.setColor(Color.GREEN); // Replace Color.colorCactus1 with a valid color constant from the Color class
         g2.fillRect(MyGraph.x, MyGraph.y, 50, 50);
         g2.setColor(Color.GREEN); // Replace Color.colorCactus2 with a valid color constant from the Color class
         g2.fillRect(MyGraph.x + 10, MyGraph.y + 10, 30, 30);
      }
   }

   class MyGraph {
      int x;
      int y;

      public MyGraph(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   public void addCactus() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeCactus() {
      MyGraphs.remove(0);
   }

   public void addDinosaur() {
      currentDinosaurX = 0;
      currentDinosaurY = D_H - 100;
   }

   public void removeDinosaur() {
      currentDinosaurX = 0;
      currentDinosaurY = 0;
   }

   public void addUnit() {
      unit++;
   }

   public void removeUnit() {
      unit--;
   }

   public void addColorDinosaur() {
      colorDinosaur = Color.RED;
   }

   public void removeColorDinosaur() {
      colorDinosaur = Color.GRAY;
   }

   public void addColorGameOver1() {
      colorGameOver1 = Color.RED;
   }

   public void removeColorGameOver1() {
      colorGameOver1 = Color.BLACK;
   }

   public void addColorGameOver2() {
      colorGameOver2 = Color.RED;
   }

   public void removeColorGameOver2() {
      colorGameOver2 = Color.YELLOW;
   }

   public void addColorCactus1() {
      colorCactus1 = Color.RED;
   }

   public void removeColorCactus1() {
      colorCactus1 = Color.GRAY;
   }

   public void addColorCactus2() {
      colorCactus2 = Color.RED;
   }

   public void removeColorCactus2() {
      colorCactus2 = Color.BLACK;
   }

   public void addJump() {
      jump++;
   }

   public void removeJump() {
      jump--;
   }

   public void addJumpY() {
      jumpY++;
   }

   public void removeJumpY() {
      jumpY--;
   }

   public void addY() {
      y++;
   }

   public void removeY() {
      y--;
   }

   public void addOnEnterPresses() {
      onEnterPresses = true;
   }

   public void removeOnEnterPresses() {
      onEnterPresses = false;
   }

   public void addDown() {
      down = true;
   }

   public void removeDown() {
      down = false;
   }

   public void addMyGraphs() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeMyGraphs() {
      MyGraphs.remove(0);
   }

   public void addCurrentDinosaurX() {
      currentDinosaurX++;
   }

   public void removeCurrentDinosaurX() {
      currentDinosaurX--;
   }

   public void addCurrentDinosaurY() {
      currentDinosaurY++;
   }

   public void removeCurrentDinosaurY() {
      currentDinosaurY--;
   }

   public void addGameOver() {
      gameOver = true;
   }

   public void removeGameOver() {
      gameOver = false;
   }

   public void addDrawPanel() {
      drawPanel.setBackground(Color.RED);
   }

   public void removeDrawPanel() {
      drawPanel.setBackground(Color.WHITE);
   }

   public void addTimer() {
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

   public void removeTimer() {
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
      timer.stop();
   }

   public void addColor() {
      colorDinosaur = Color.RED;
      colorGameOver1 = Color.RED;
      colorGameOver2 = Color.RED;
      colorCactus1 = Color.RED;
      colorCactus2 = Color.RED;
   }

   public void removeColor() {
      colorDinosaur = Color.GRAY;
      colorGameOver1 = Color.BLACK;
      colorGameOver2 = Color.YELLOW;
      colorCactus1 = Color.GRAY;
      colorCactus2 = Color.BLACK;
   }

   public void addDinosaurX() {
      currentDinosaurX = 0;
   }

   public void removeDinosaurX() {
      currentDinosaurX = 0;
   }

   public void addDinosaurY() {
      currentDinosaurY = D_H - 100;
   }

   public void removeDinosaurY() {
      currentDinosaurY = 0;
   }

   public void addDinosaurWidth() {
      currentDinosaurX = 0;
   }

   public void removeDinosaurWidth() {
      currentDinosaurX = 0;
   }

   public void addDinosaurHeight() {
      currentDinosaurY = D_H - 100;
   }

   public void removeDinosaurHeight() {
      currentDinosaurY = 0;
   }

   public void addCactusX() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeCactusX() {
      MyGraphs.remove(0);
   }

   public void addCactusY() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeCactusY() {
      MyGraphs.remove(0);
   }

   public void addCactusWidth() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeCactusWidth() {
      MyGraphs.remove(0);
   }

   public void addCactusHeight() {
      MyGraphs.add(new MyGraph(D_W, D_H - 100));
   }

   public void removeCactusHeight() {
      MyGraphs.remove(0);
   }

   public void addJumpY1() {
      jumpY = 0;
   }

   public void removeJumpY1() {
      jumpY = 0;
   }

   public void addJumpY2() {
      jumpY = 100;
   }

   public void removeJumpY2() {
      jumpY = 100;
   }

   public void addJumpY3() {
      jumpY = 0;
   }

   public void removeJumpY3() {
      jumpY = 0;
   }

   public void addJumpY4() {
      jumpY = 100;
   }

   public void removeJumpY4() {
      jumpY = 100;
   }

   public void addJumpY5() {
      jumpY = 0;
   }

   public void removeJumpY5() {
      jumpY = 0;
   }

   public void addJumpY6() {
      jumpY = 100;
   }

   public void removeJumpY6() {
      jumpY = 100;
   }

   public void addJumpY7() {
      jumpY = 0;
   }

   public void removeJumpY7() {
      jumpY = 0;
   }

   public void addJumpY8() {
      jumpY = 100;
   }

   public void removeJumpY8() {
      jumpY = 100;
   }

   public void addJumpY9() {
      jumpY = 0;
   }

   public void removeJumpY9() {
      jumpY = 0;
   }

   public void addJumpY10() {
      jumpY = 100;
   }

   public void removeJumpY10() {
      jumpY = 100;
   }
}
