import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(4);
        gira();
        come();
    }

    public void gira()
    {
        if (Greenfoot.isKeyDown("left"))    {
            turn(-3);
        }
        
        if (Greenfoot.isKeyDown("right"))    {
            turn(3);
        }
    }

    public void come()
    {
        if (isTouching(Worm.class)) {
            Greenfoot.playSound("eating.wav");
            removeTouching(Worm.class);
            CrabWorld mundo = (CrabWorld)getWorld();
            mundo.incrementaGusanos();
            List lista = mundo.getObjects(Worm.class);
            if (lista.size() == 0)  {  // if (lista.isEmpty())
                Label etiquetaGanador = new Label("Winner", 50);
                mundo.addObject(etiquetaGanador, 250, 250);
                Greenfoot.stop();
            }
/*  ListIterator<?> it = lista.iterator();
            while(it.hasNext()) {
            }*/
        }
    }
}
