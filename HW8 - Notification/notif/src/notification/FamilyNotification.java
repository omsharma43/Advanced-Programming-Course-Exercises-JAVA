package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class FamilyNotification extends Notification{
    public FamilyNotification(String REC, String MAS,  int hours,int minutes){
        super(REC,MAS,hours,minutes,4);
    }

    @Override
    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append("** ");
        show.append(this.getReceiver());
        show.append(" has send you a new Family massage **");
        return show.toString();
    }

    public static boolean find(String s){
        ArrayList<String> family=new ArrayList<String>(Arrays.asList("dad","mom","sonny","son"));
        for (int i=0;i< family.size();i++){
            if (s.contains(family.get(i))){
                return true;
            }
        }
        return false;
    }
}