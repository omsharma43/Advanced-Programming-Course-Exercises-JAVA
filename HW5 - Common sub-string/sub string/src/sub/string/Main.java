package sub.string;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class Main {

    public static ArrayList find_substr(ArrayList<String> sequences) {
        String seq = sequences.get(0);
        ArrayList<String> SUB = new ArrayList<String>();
        for (int i = 0; i < seq.length(); i++) {
            for (int j = i + 1; j <= seq.length(); j++) {
                SUB.add(seq.substring(i, j));
            }
        }
        Collections.sort(SUB);
        return SUB;
    }

    public static ArrayList sort(ArrayList<String> WORDS){
        String TEMP= "";
        for (int i=0;i< WORDS.size();i++){
            for (int j=0;j< WORDS.size()-i-1;j++){
                if (WORDS.get(j).length() > WORDS.get(j+1).length()){
                    TEMP= WORDS.get(j);
                    WORDS.set(j, WORDS.get(j+1));
                    WORDS.set(j+1,TEMP);
                }
            }
        }
        return WORDS;
    }

    public static String answer_select(ArrayList<String> ANSWERS){
        ArrayList<String> ANSWER=sort(ANSWERS);
        String MAX_OF_ANSWERS= "";
        int max=0;
        for (int i = 0; i < ANSWER.size(); i++) {
            for (int j = 0; j < ANSWER.size(); j++) {
                if (ANSWER.get(i).compareTo(ANSWER.get(j)) > 0){
                    max=i;
                }
            }
        }
        MAX_OF_ANSWERS=ANSWERS.get(max);
        return MAX_OF_ANSWERS;
    }

    public static String REVERSE_SUB(String R_S) {
        StringBuilder REV_STR = new StringBuilder();
        REV_STR.append(R_S);
        REV_STR.reverse();
        return REV_STR.toString();
    }

    public static void SEARCH(ArrayList<String> words, ArrayList<String> SUB, int count) {
        Collections.sort(SUB);
        ArrayList<String> SUBS=sort(SUB);
        ArrayList<String> ANSWERS=new ArrayList<String>();
        SEARCH:
        for (int i = SUBS.size() - 1; i > -1; i = i - 1) {

            String subs = new String(SUBS.get(i));

            Vector<Integer> INDEX = new Vector<Integer>();

            for (int n = 0; n < count; n++) {
                String SEQ = new String(words.get(n));
                if (SEQ.contains(subs)) {
                    INDEX.add(n);
                }
            }

            String REV_SUB = new String(SUBS.get(i));
            REV_SUB=REVERSE_SUB(REV_SUB);

            for (int m = 0; m < count; m++) {
                String seq = new String(words.get(m));
                if (seq.contains(REV_SUB)) {
                    INDEX.add(m);
                }
            }

            LinkedHashSet<Integer> lhSet = new LinkedHashSet<Integer>( INDEX );
            INDEX.clear();
            INDEX.addAll(lhSet);

            if (INDEX.size() == count) {
                ANSWERS.add(subs);
            }
        }

        if (ANSWERS.isEmpty()){
            System.exit(0);
        }

        String ANSWER=answer_select(ANSWERS);
        System.out.println(ANSWER);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> sequences = new ArrayList<String>();
        int count = input.nextInt();
        input.nextLine();
        for (int i = 0; i < count; i++) {
            sequences.add(input.nextLine());
        }
        if (count==0){
            System.exit(0);
        }
        ArrayList SUB = new ArrayList(find_substr(sequences));
        SEARCH(sequences,SUB,count);
    }

}
