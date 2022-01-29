package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

class ExchangeNotification extends Notification{
    public ExchangeNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,2);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("$$ there is a new Exchange massage from ");
        show.append(this.getReceiver());
        show.append(" $$");
        return show.toString();
    }

    public static boolean find(String s){
        if (s.contains("stock")){
            return true;
        }
        Pattern pattern=Pattern.compile("\\d{10}");
        Matcher matcher=pattern.matcher(s);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}