package soliterrible;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


/**
 * CardStack Class
 * This is the only class that actually moves around the board.
 * Contains one or more Cards and is mostly just for drawing the Card dragging.
 * @author Jason LaFrance
 */
public class CardStack extends JPanel {
    private ArrayList<Card> myCards;
   private int myWidth, myHeight;
    private int myCardGap = 20;
    private boolean isDragging;
    
    private Card dragCard;
    private CardStack dragStack;
    
    private int dragStartX, dragStartY;
    
    /**
     * Construct new CardStack object with default values.
     */
    public CardStack(){
        this(new ArrayList<Card>());
    }
    
    /**
     * Construct new CardStack object with specific values.
     * @param inCards A list of Card objects to put in the stack
     */
    public CardStack(List<Card> inCards){
        myCards = new ArrayList<>();
        myCards.addAll(inCards);
        myWidth = 76;
        myHeight = 96 + (inCards.size() * myCardGap);
        isDragging = false;
        this.setSize(myWidth, myHeight);
    }
    
    /**
     * Construct new CardStack object with specific values.
     * @param inCard A single Card object to put in the stack
     */
    public CardStack(Card inCard){
        myCards = new ArrayList<>();
        myCards.add(inCard);
        myWidth = 76;
        myHeight = 96;
        isDragging = false;
        this.setSize(myWidth, myHeight);
    }
    
    /**
     * Get a count of Card objects in stack
     * @return Returns an int of the number of Card objects in the stack.
     */
    public int getCardsInStack() {return myCards.size();}
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int yOffset = 0;
        for(Card c: myCards){
            if(c.getOrientation() == CardOrientation.FACEUP)
                g2d.drawImage(c.getFaceImage(), null, 0, yOffset);
            else 
                g2d.drawImage(c.getBackImage(), null, 0, yOffset);
            yOffset += myCardGap;
        }
    }
    
    /**
     * Get the Card list from the stack.
     * @return Returns an ArrayList<Card> object populated with its Cards.
     */
    public ArrayList<Card> getCardList() {return myCards;}
}
