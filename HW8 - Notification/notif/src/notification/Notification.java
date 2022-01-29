package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class Notification {

    String receiver;
    String massage;
    int hours;
    int minutes;
    int priority;

    public Notification(){
    }

    public Notification(String receiver,String massage,int hours,int minutes,int priority){
        this.receiver=receiver;
        this.massage=massage;
        this.hours=hours;
        this.minutes=minutes;
        this.priority=priority;
    }

    public String getMassage() {
        return massage;
    }
    public String getReceiver() {
        return receiver;
    }
    public int getPriority() {
        return priority;
    }
    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public static ArrayList<Notification> sort(ArrayList<Notification> notifications){
        for (int i=0;i<notifications.size();i++){
            for (int j=0;j<notifications.size()-i-1;j++){
                if (notifications.get(j).getPriority() > notifications.get(j+1).getPriority()){
                    Notification n=new Notification();
                    n=notifications.get(j);
                    notifications.set(j,notifications.get(j+1));
                    notifications.set(j+1,n);
                }
                if (notifications.get(j).getPriority() == notifications.get(j+1).getPriority()){
                    if (notifications.get(j).getHours() > notifications.get(j+1).getHours()){
                        Notification n=new Notification();
                        n=notifications.get(j);
                        notifications.set(j,notifications.get(j+1));
                        notifications.set(j+1,n);
                    }
                    if (notifications.get(j).getHours() == notifications.get(j+1).getHours()){
                        if (notifications.get(j).getMinutes() > notifications.get(j+1).getMinutes()){
                            Notification n=new Notification();
                            n=notifications.get(j);
                            notifications.set(j,notifications.get(j+1));
                            notifications.set(j+1,n);
                        }
                    }
                }
            }
        }
        return notifications;
    }

    public Notification(Notification n){
        this.receiver=n.getReceiver();
        this.massage=n.getMassage();
        this.priority=n.getPriority();
        this.minutes=n.getMinutes();
        this.hours=n.getHours();
    }

    public String showNotificationPanel(){
        StringBuilder show=new StringBuilder();
        show.append(getReceiver());
        show.append(" has send you a new massage");
        return show.toString();
    }

}