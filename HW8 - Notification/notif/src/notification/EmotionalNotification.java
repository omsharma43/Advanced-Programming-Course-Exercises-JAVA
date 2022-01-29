package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class EmotionalNotification extends Notification{
    public EmotionalNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,1);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("-- ");
        show.append(this.getReceiver());
        show.append(" has send you a new Emotional massage --");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> emotional=new ArrayList<String>(Arrays.asList("babe","honey","love"));
        for (int i=0;i< emotional.size();i++){
            if (s.contains(emotional.get(i))){
                return true;
            }
        }
        return false;
    }
}