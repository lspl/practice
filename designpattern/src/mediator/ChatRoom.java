package mediator;

import java.util.Date;

/**
 * @author lishunpu
 * @create 2017-07-17 14:47
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
