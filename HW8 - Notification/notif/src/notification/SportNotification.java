package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class SportNotification extends Notification{
    public SportNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,5);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("&& you have a new Sport massage from ");
        show.append(this.getReceiver());
        show.append(" &&");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> sport=new ArrayList<String>(Arrays.asList("exercises","muscle Building","aerobic","yoga","walking","run"));
        for (int i=0;i<sport.size();i++){
            if (s.contains(sport.get(i))){
                return true;
            }
        }
        return false;
    }
}