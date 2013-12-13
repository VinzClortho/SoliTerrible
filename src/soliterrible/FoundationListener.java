package soliterrible;

/**
 * Foundation Listener trigger interface
 * @author Jason LaFrance
 */
public interface FoundationListener {
    /**
     * This is the required method for listening
     * @param triggerObject An object sent back from the Foundation event
     */
    public void triggered(Object triggerObject);
}
