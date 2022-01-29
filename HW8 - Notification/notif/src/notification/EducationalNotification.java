package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class EducationalNotification extends Notification{
    public EducationalNotification(String REC,String MAS, int hours,int minutes){
        super(REC,MAS,hours,minutes,6);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append(">> ");
        show.append(this.getReceiver());
        show.append(" has sent you a new Educational massage <<");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> educational=new ArrayList<String>(Arrays.asList("university","master","lesson","grade","homework","class"));
        for (int i=0;i< educational.size();i++){
            if (s.contains(educational.get(i))){
                return true;
            }
        }
        return false;
    }
}
