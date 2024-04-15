package ss5_access_static.practice;

public class Util {
    String title;
    public void setTitle( String newTitle ) {
        if ( newTitle == null )   // Don’t allow null strings as titles!
            title = "(Untitled)";  // Use an appropriate default value instead.
        else
            title = newTitle;
    }
    // luu so lan gia tri doc ra
    int titleAccessCount;
    public String getTitle() {
        titleAccessCount++;  // Increment member variable titleAccessCount.
        return title;
    }
}
