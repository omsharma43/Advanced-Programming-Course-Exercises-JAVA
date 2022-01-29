package notification;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        ArrayList<Notification> NOTIF=new ArrayList<Notification>();

        ArrayList<String> MASSAGES=new ArrayList<String>();

        String m;
        while (input.hasNextLine()){
            m = input.nextLine();
            MASSAGES.add(m);
        }

        input.close();

        lable:
        for (int i=0;i< MASSAGES.size();i++){

            StringBuilder mas=new StringBuilder(MASSAGES.get(i));
            mas.append(" : ");
            Scanner in=new Scanner(mas.toString()).useDelimiter(" : ");

            String rec= new String(in.next());
            StringBuilder rest=new StringBuilder(in.next());
            in.close();

            rest.append(" , ");

            Scanner inp=new Scanner(rest.toString()).useDelimiter("\\s*,\\s*");

            String massage=new String(inp.next());
            StringBuilder time=new StringBuilder(inp.next());
            inp.close();

            time.append(":");

            Scanner cin=new Scanner(time.toString()).useDelimiter(":");

            int hour=Integer.parseInt(cin.next());
            int min=Integer.parseInt(cin.next());
            cin.close();

            if (NecessaryNotification.find(MASSAGES.get(i))){
                Notification n=new NecessaryNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (EmotionalNotification.find(MASSAGES.get(i))){
                Notification n=new EmotionalNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (ExchangeNotification.find(MASSAGES.get(i))){
                Notification n=new ExchangeNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (JobNotification.find(MASSAGES.get(i))){
                Notification n=new JobNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (FamilyNotification.find(MASSAGES.get(i))){
                Notification n=new FamilyNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (SportNotification.find(MASSAGES.get(i))){
                Notification n=new SportNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (EducationalNotification.find(MASSAGES.get(i))){
                Notification n=new EducationalNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
            if (DietNotification.find(MASSAGES.get(i))){
                Notification n=new DietNotification(rec,massage,hour,min);
                NOTIF.add(n);

                continue lable;
            }
        }

        NOTIF=Notification.sort(NOTIF);

        for (int i=0;i<NOTIF.size();i++){
            System.out.println(NOTIF.get(i).showNotificationPanel());
        }
    }
}
