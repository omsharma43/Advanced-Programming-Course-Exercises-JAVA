package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class NecessaryNotification extends Notification{
    public NecessaryNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,0);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("•• you have a new Necessary massage from ");
        show.append(this.getReceiver());
        show.append(" ••");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> necessary=new ArrayList<String>(Arrays.asList("hurry up","faster","important","!!!!"));
        for (int i=0;i<necessary.size();i++){
            if (s.contains(necessary.get(i))){
                return true;
            }
        }
        return false;
    }
}