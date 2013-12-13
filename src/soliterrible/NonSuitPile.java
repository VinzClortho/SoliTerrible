package soliterrible;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Non Suit Pile class
 * Manages the alternating color / decending rank card piles
 * @author Jason LaFrance
 */

public class NonSuitPile extends Foundation  {
    private int myWidth, myHeight, myBaseHeight;
    
    /**
     * Constructor with specific values
     * @param inWidth Width as an int
     * @param inHeight Height as an int
     * @param inCardGap Display gap between cards as an int
     */
    public NonSuitPile(int inWidth, int inHeight, int inCardGap){
        myWidth = inWidth;
        myBaseHeight = inHeight;
        myCardGap = inCardGap;
        myHeight = myBaseHeight + (18 * myCardGap);
        myType = FoundationType.NONSUIT;
        myCardList = new ArrayList<>();
        isDragging = false;
         
        // set size to hold up to 13 cards
        this.setSize(myWidth, myHeight);
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    // Overrides
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.gray);
        g2d.fillRect(0, 0, myWidth - 1, myBaseHeight - 1);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 0, myWidth - 1, myBaseHeight - 1);
        
        int yOffset = 0;
        
        for(int i = 0; i < myCardList.size(); i++){
            if(myCardList.get(i).getOrientation() == CardOrientation.FACEUP)
                g2d.drawImage(myCardList.get(i).getFaceImage(), null, 0, yOffset);
            else
                g2d.drawImage(myCardList.get(i).getBackImage(), null, 0, yOffset);
            yOffset += myCardGap;
        }
    }
}
