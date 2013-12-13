package soliterrible;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Discard Pile Class
 * Manages the face up pile of un-pulled deck cards.
 * @author Jason LaFrance
 */
public class DiscardPile extends Foundation {
    
    private int myWidth, myHeight;
    
    /**
     * Constructor with default values.
     */
    public DiscardPile(){
        // default values
        this(72, 96, 0);
    }
    
    /**
     * Constructor with specific values.
     * @param inWidth Width of cards as an int.
     * @param inHeight Height of cards as an int.
     * @param inCardGap Spacing to show between cards as an int.
     */
    public DiscardPile(int inWidth, int inHeight, int inCardGap){
        myWidth = inWidth;
        myHeight = inHeight;
        myCardGap = inCardGap;
        myCardList = new ArrayList<>();
        myType = FoundationType.DISCARD;
        this.setSize(inWidth, inHeight);
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    /**
     * Clear the whole pile.
     */
    public void clearCards() {
        myCardList.clear();
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
