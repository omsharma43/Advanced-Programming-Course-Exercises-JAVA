package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class DietNotification extends Notification{
    public DietNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,7);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("## you have a new Diet massage from ");
        show.append(this.getReceiver());
        show.append(" ##");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> diet=new ArrayList<String>(Arrays.asList("snack","lunch","dinner","salad","breakfast","fruit","vitamin tablets","coffee","herbal Tea"));
        for (int i=0;i<diet.size();i++){
            if (s.contains(diet.get(i))){
                return true;
            }
        }
        return false;
    }
}