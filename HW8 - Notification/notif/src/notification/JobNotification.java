package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class JobNotification extends Notification{
    public JobNotification(String REC, String MAS, int hours,int minutes){
        super(REC,MAS,hours,minutes,3);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append(":: you have a new Job massage from ");
        show.append(this.getReceiver());
        show.append(" ::");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> job=new ArrayList<String>(Arrays.asList("project","presentation","meeting","deadline"));
        for (int i=0;i< job.size();i++){
            if (s.contains(job.get(i))){
                return true;
            }
        }
        return false;
    }
}