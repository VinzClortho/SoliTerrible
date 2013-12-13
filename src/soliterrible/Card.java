package soliterrible;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Solitaire Card Class
 * @author Jason LaFrance
 */
public class Card extends JPanel {
    private BufferedImage myFaceImage, myBackImage;
    private int myRank;
    private CardSuit mySuit;
    private CardOrientation myOrientation;
    private int myWidth, myHeight;
    
    /**
     * Initialize Card object with default values
     */
    public Card(){
        this(1, CardSuit.CLUBS, CardOrientation.FACEDOWN);
    }
    
    /**
     * Initialize Card object with specific value
     * @param inRank is an int represeting the face value of the card, where
     *        1 is an Ace and 13 is a King
     * @param inSuit in a CardSuit of the card's suit
     * @param inOrientation is a CardOrientation of the card's orientation
     */
    public Card(int inRank, CardSuit inSuit, CardOrientation inOrientation){
        super();
        myRank = inRank;
        mySuit = inSuit;
        myOrientation = inOrientation;
        myWidth = 0;
        myHeight = 0;
    }
    
    /**
     * Get the card's color, either RED of BLACK
     * @return Returns either CardColor.RED or CardColor.BLACK
     */
    public CardColor getColor() {
        if(mySuit == CardSuit.CLUBS || mySuit == CardSuit.SPADES)
            return CardColor.BLACK;
        else return CardColor.RED;
    }
    
    /**
     * Sets the image for the face of the card
     * @param inImage is an initialized BufferImage
     * @return true if able to set, otherwise false
     */
    public boolean setFaceImage(BufferedImage inImage) {
        boolean ret = false;
        if(inImage != null){
            myFaceImage = inImage;
            if(inImage.getWidth() > myWidth) myWidth = inImage.getWidth();
            if(inImage.getHeight() > myWidth) myHeight = inImage.getHeight();
            ret = true;
        }
        return ret;
    }
    
    /**
     * Sets the image for the back of the card
     * @param inImage is an initialized BufferImage
     * @return true if able to set, otherwise false
     */
    public boolean setBackImage(BufferedImage inImage) {
        boolean ret = false;
        if(inImage != null){
            myBackImage = inImage;
            if(inImage.getWidth() > myWidth) myWidth = inImage.getWidth();
            if(inImage.getHeight() > myWidth) myHeight = inImage.getHeight();
            ret = true;
        }
        return ret;
    }
    
    /**
     * Gets the card's rank
     * @return Returns the card's rank as an int between 1 and 13.
     */
    public int getRank() {return myRank;}
    /**
     * Gets the card suit
     * @return Returns the card's suit as a CardSuit
     */
    public CardSuit getSuit() {return mySuit;}
    /**
     * Gets the cards orientation
     * @return Returns the card's orientation as a CardOrientation
     */
    public CardOrientation getOrientation() {return myOrientation;}
    /**
     * Set the card's orientation, either FACEUP or FACEDOWN
     * @param inOrientation a CardOrientation object
     */
    public void setOrientation(CardOrientation inOrientation) {myOrientation = inOrientation;}
    
    /**
     * Gets the card's face image
     * @return Returns a BufferedImage of the card's face image, or null if it's
     *         uninitialized
     */
    public BufferedImage getFaceImage(){ return myFaceImage;}
    /**
     * gets the card back image
     * @return Returns a BufferedImage of the card's face image, or null if it's
     *         uninitialized
     */
    public BufferedImage getBackImage(){ return myBackImage;}
    
    @Override
    public String toString(){
        String ret = "" + myRank;
        switch(mySuit){
            case HEARTS:
                ret += "H";
                break;
            case DIAMONDS:
                ret += "D";
                break;
            case CLUBS:
                ret += "C";
                break;
            case SPADES:
                ret += "S";
                break;
            default:
        }
        return ret;
    }
}
