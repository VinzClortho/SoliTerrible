package soliterrible;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Deck Pile Class
 * Special case Foundation that manages shuffling and dealing of Card objects
 * @author Jason LaFrance
 */
public class DeckPile extends JPanel implements MouseListener {
    
    private ArrayList<Card> myCardList;
    private FoundationType myType;
    private int myWidth, myHeight;
    private int myCardGap;    
    
    /**
     * Constructor with default values
     */
    public DeckPile(){
        // default values
        this(72, 96);
    }
    
    /**
     * Constructor with specific values
     * @param inWidth Width of Cards as an int.
     * @param inHeight Height of Cards as an int.
     */
    public DeckPile(int inWidth, int inHeight){
        myType = FoundationType.DECK;
        myWidth = inWidth;
        myHeight = inHeight;
        myCardGap = 0;
        this.setSize(inWidth, inHeight);
        
        fill();
       
        addMouseListener(this);
    }
    
    // populate the deck with one of every card
    private void fill(){
        myCardList = new ArrayList<>();
        for(CardSuit e: CardSuit.values()){
            for(int i = 1; i <= 13; i++)
                myCardList.add(new Card(i, e, CardOrientation.FACEDOWN));
        }
    }
    
    /**
     * Shuffle the deck
     * @param inTimes Number of Card movements to make as an int.
     */
    public void shuffle(int inTimes){
        Random gen = new Random();
        for(int i = 0; i < inTimes; i++){
            int from = gen.nextInt(52);
            int to;
            do{
                to = gen.nextInt(52);
                
            } while (from == to);
            Card temp = myCardList.get(from);
            myCardList.set(from, myCardList.get(to));
            myCardList.set(to, temp);
        }
    }
    
    /**
     * Get number of Card objects in the deck
     * @return Returns the number of Cards as an int.
     */
    public int getCardCount(){ return myCardList.size();}
    
    /**
     * Remove a card from the deck.  It's a pop action.
     * @return Returns the Card object returned from the deck.
     */
    public Card removeCard(){
        Card ret = myCardList.get(0);
        myCardList.remove(0);
        return ret;
    }
    
    /**
     * Replace the deck cards with the input list
     * @param inCards An ArrayList of the Card objects to set the deck to.
     */
    public void setCards(ArrayList<Card> inCards){
        myCardList.clear();
        myCardList.addAll(inCards);
    }
    
    // Overrides
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.gray);
        g2d.fillRect(0, 0, myWidth, myHeight);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 0, myWidth, myHeight);
        
        if(!myCardList.isEmpty()){
            g.drawImage(myCardList.get(0).getBackImage(), 0, 0, null);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // if there's a card in the deck, flip it to the discard pile
        DiscardPile dp = null;
        int index = 0;
        while(index < this.getParent().getComponentCount() && this.getParent().getComponent(index) != null && this.getParent().getComponent(index) instanceof DiscardPile == false) index++;

        if(index < this.getParent().getComponentCount()){
            dp = (DiscardPile)this.getParent().getComponent(index);
        }

        if(myCardList.size() > 0 && dp != null){
            for(int i = 0; i < 3; i++){
                if(myCardList.isEmpty()) break;
                Card topCard = this.removeCard();
                topCard.setOrientation(CardOrientation.FACEUP);
                dp.addCard(topCard);
            }
            this.getParent().repaint();
        } else if (dp != null && !dp.isEmpty()) {
            myCardList = dp.getCardList();
            for(ListIterator li = myCardList.listIterator(); li.hasNext();){
                    Card c = (Card)li.next();
                    c.setOrientation(CardOrientation.FACEDOWN);
            }
            
            dp.clearCards();
            this.getParent().repaint();
        }
    }
}
