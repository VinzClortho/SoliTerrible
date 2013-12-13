package soliterrible;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * The Foundation class manages all of the card dragging and dropping.
 * @author Jason LaFrance
 */
public class Foundation extends JPanel implements MouseListener,
        MouseMotionListener {
    /**
     * The type of Foundation that the subclass is.
     */
    protected FoundationType myType;
    /**
     * The Foundation's card list
     */
    protected List<Card> myCardList;
    
    /**
     * 
     */
    protected Card dragCard;
    /**
     * The stack of cards to drag around the game board
     */
    protected CardStack dragStack;
    /**
     * Stores which card is clicked on the pile as the top drag card
     */
    protected int clickedCard;
    /**
     * The X origin of the drag
     */
    protected int dragStartX,
    /**
     * The Y origin of the drag
     */
    dragStartY;
    /**
     * Wether or not the Foundation is in drag mode
     */
    protected boolean isDragging;
    /**
     * The display gap between cards, if any
     */
    protected int myCardGap;    
    
    // Trigger Listener
    private List<FoundationListener> listeners = new ArrayList<FoundationListener>();
    
    /**
     * Figures out is the drop off point for the card drag is valid.
     * This does the rule checking!
     * @param inPoint A point relative to the game board.
     * @return Returns the Foundation to do the drop to
     *      or null if an invalid drop.
     */
    protected Foundation getDrop(Point inPoint){
        Foundation dropFoundation;
        
        for(int i = 0; i < this.getParent().getComponentCount(); i++){
            if(this.getParent().getComponent(i) instanceof Foundation && this.getParent().getComponent(i).getBounds().contains(inPoint)){
                dropFoundation = (Foundation)(this.getParent().getComponent(i));
                // check the drop logic
                switch(dropFoundation.getType()){
                    case NONSUIT:
                        // if dropping on a populated foundation...
                        if(dropFoundation.getCardCount() > 0){
                            Card A = dropFoundation.getCardList().get(dropFoundation.getCardList().size() - 1);
                            Card B = dragStack.getCardList().get(0);
                            // check rank
                            if(B.getRank() == A.getRank() - 1){
                                // check color
                                if(B.getColor() != A.getColor()){
                                    // add card stack to drop zone!
                                    return dropFoundation;
                                }
                            }
                        } else if (dragStack.getCardList().get(0).getRank() == 13) {
                            return dropFoundation;
                        }
                        break;
                    case SUIT:
                        // only deal with a single incoming card
                        if(dragStack.getCardsInStack() != 1) return null;
                        // if dropping on a populated foundation...
                        if(dropFoundation.getCardCount() > 0){
                            Card A = dropFoundation.getCardList().get(dropFoundation.getCardList().size() - 1);
                            Card B = dragStack.getCardList().get(0);
                            // check rank
                            if(B.getRank() == A.getRank() + 1 && B.getSuit() == A.getSuit()){
                                return dropFoundation;
                            }
                        } else if (dragStack.getCardList().get(0).getRank() == 1) {
                            return dropFoundation;
                        }
                        break;
                    default:
                }
            }
        }
        return null;
    }
    
    /**
     * Sets the top card, if any, to FACEUP
     */
    public void flipTopCard() {
        if(myCardList.size() > 0)
            myCardList.get(myCardList.size() - 1).setOrientation(CardOrientation.FACEUP);
    }
    
    /**
     * Add a single card to the Foundation's stack.
     * @param inCard The Card object to add to the Foundation's Card stack
     */
    public void addCard(Card inCard) {
        myCardList.add(inCard);
        fireAction();
    }
    
    /**
     * Add multiple Card objects to the Foundation's stack
     * @param inCards A List<> object of the Cards to add to the stack
     */
    public void addCards(List<Card> inCards) {
        myCardList.addAll(inCards);
        fireAction();
    }
    
    // trigger the listeners
    private void fireAction(){
        if(this.getParent() != null)
            this.getParent().repaint();
        for (int i = 0; i < listeners.size(); i++)
            listeners.get(i).triggered(this);
    }
    /**
     * Get the Foundation's type
     * @return Returns a FoundationType
     */
    public FoundationType getType() {return myType;}

    /**
     * Returns the list of Cards in the stack
     * @return Returns an ArrayList<> of the Card objects in the stack
     */
    public ArrayList<Card> getCardList() {
        ArrayList<Card> n = new ArrayList<>();
        n.addAll(myCardList);
        return n;
    }
    
    /**
     * Find out if the card stack is empty
     * @return Returns true for empty,  false otherwise.
     */
    public boolean isEmpty() {
        return myCardList.isEmpty();
    }
    
    /**
     * Get a count of the cards in the stack
     * @return Returns an int of the number of Card objects in the stack
     */
    public int getCardCount() {
        return myCardList.size();
    }
    
    // FoundationListener Overrides
    /**
     * Removes the parameter listener. 
     * @param listener
     */
    public void removeListener(FoundationListener listener){
	listeners.remove(listener);
    }
    
    /**
     * Removes all parameter listeners.
     */
    public void removeAllListeners(){
	listeners.clear();
    }
    /**
     * Adds the parameter listener. 
     * @param listener
     */
    public void addListener(FoundationListener listener){
	listeners.add(listener);
    }
    
    // MouseListener Overrides
    @Override
    public void mousePressed(MouseEvent e) {
        if(myCardList.size() > 0){
            
            if(myCardGap > 0) clickedCard = e.getY() / myCardGap;
            else clickedCard = 0;
            
            if(clickedCard >= myCardList.size()) clickedCard = myCardList.size() - 1;
            if(this.getType() == FoundationType.DISCARD) clickedCard = myCardList.size() - 1;
            else if(this.getType() == FoundationType.SUIT) clickedCard = myCardList.size() - 1;
            
            if(myCardList.get(clickedCard).getOrientation() == CardOrientation.FACEUP){
                dragStack = new CardStack(myCardList.subList(clickedCard, myCardList.size()));
                myCardList.removeAll(dragStack.getCardList());
                this.getParent().add(dragStack);
                this.getParent().setComponentZOrder(dragStack, 0);
                dragStartX = e.getX();
                dragStartY = e.getY();
                dragStack.setLocation(this.getX(), this.getY()  + (clickedCard * myCardGap));
                isDragging = true;
                this.getParent().repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int dropX = this.getX() + e.getX();
        int dropY = this.getY() + e.getY();
        Point dP = new Point(dropX, dropY);
        // just drop it back for now
        if(isDragging && dragStack != null){
            Foundation dropFoundation = getDrop(dP);
            if( dropFoundation != null) {
                // can move card!
                dropFoundation.addCards(dragStack.getCardList());
                // notify the listeners
                this.flipTopCard();
                //fireAction();
            } else {
                this.addCards(dragStack.getCardList());
            }
            this.getParent().remove(dragStack);
            this.getParent().repaint();
            dragStack = null;
            isDragging = false;
        }

        this.getParent().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    
    // MouseMotionListener
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(isDragging && dragStack != null) {
            int newX = this.getX() + (e.getX() - dragStartX);
            int newY = this.getY() + (e.getY() - dragStartY);
            dragStack.setLocation(newX, newY + (clickedCard * myCardGap));
        }
       
    }
    
}
