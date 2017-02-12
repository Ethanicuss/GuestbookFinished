package guestbook;

import java.util.Date;

 

import com.google.appengine.api.users.User;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;

import com.googlecode.objectify.annotation.Id;

 

 

@Entity

public class Greeting implements Comparable<Greeting> {
	static {

        ObjectifyService.register(Greeting.class);

    }
    @Id Long id;

    User user;
    
    String title;	 // ADDED

    String content;

    Date date;

    private Greeting() {}

    public Greeting(User user, String title, String content) {	// CHANGED

        this.user = user;
        
        this.title = title;		// ADDED

        this.content = content;

        date = new Date();

    }

    public User getUser() {

        return user;

    }
    
    public String getTitle() {	// ADDED
    	
    	return title;
    	
    }

    public String getContent() {

        return content;

    }

    @Override

    public int compareTo(Greeting other) {

        if (date.after(other.date)) {

            return 1;

        } else if (date.before(other.date)) {

            return -1;

        }

        return 0;

    }

}