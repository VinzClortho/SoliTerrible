package soliterrible;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Suit Pile class
 * Manages the same suit / acending rank card piles
 * @author Jason LaFrance
 */
public class SuitPile extends Foundation {
    private int myWidth, myHeight;
    
    /**
     * Constructor with default values
     */
    public SuitPile(){
        // default values
        this(72, 96, 0);
    }
    
    /**
     * Constructor with specific values
     * @param inWidth Width as an int
     * @param inHeight Height as an int
     * @param inCardGap Display gap between cards as an int
     */
    public SuitPile(int inWidth, int inHeight, int inCardGap){
        myWidth = inWidth;
        myHeight = inHeight;
        myCardGap = inCardGap;
        myCardList = new ArrayList<>();
        myType = FoundationType.SUIT;
        this.setSize(inWidth, inHeight);
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    // Overrides
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.gray);
        g2d.fillRect(0, 0, myWidth, myHeight);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 0, myWidth, myHeight);
        
        if(myCardList.size() > 0)
            g2d.drawImage(myCardList.get(myCardList.size() - 1).getFaceImage(), null, 0, 0);

    }
}
