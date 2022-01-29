package bank.system;

/*    hello
      the main answer is in the first switch case 2 where we register new guys
      the other cases and some methods are for making the program reasonable like some little bank ops and search
      i only want to make a better program so if you want to check it for correct answer the registration happens in the first switch(line 88) case 2(line 182)
      sorry for writing bunch of other methods and functions but my idea was to make this program somewhat more reasonable
      if its a little dirty im truly sorry.i tried my best to finish it. pouya ardehkhani 2021.
*/


// the answer is in line 182


import java.util.*;
import java.io.*;
import java.lang.String;
import java.io.IOException;

public class Main {
    public enum sex {
        male, female
    }
    public class bank_account {
        //------------------attributes-------------------------------------
        private short age, number_of_accounts;
        private long national_id;
        private int telephone_number;
        private Vector<Long> account_id;
        private Vector<Double> money;
        private sex type;
        private String name, family_name;
        //-----------------------------------------------------------------

        //------------main constructor-------------------------------------
        public bank_account(String n, String fn, short age, sex t, long n_id, int t_n, short n_of_acc, Vector<Long> ACC_ID, Vector<Double> MONEY) {
            this.name = n;
            this.family_name = fn;
            this.age = age;
            this.type = t;
            this.national_id = n_id;
            this.telephone_number = t_n;
            this.number_of_accounts = n_of_acc;
            this.account_id = ACC_ID;
            this.money = MONEY;
        }

        //--------------setter methods--------------------------------------
        public void setAccount_id(Vector<Long> account_id) {
            this.account_id = account_id;
        }

        public void setAge(short age) {
            this.age = age;
        }

        public void setFamily_name(String family_name) {
            this.family_name = family_name;
        }

        public void setMoney(Vector<Double> money) {
            this.money = money;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNational_id(long national_id) {
            this.national_id = national_id;
        }

        public void setNumber_of_accounts(short number_of_accounts) {
            this.number_of_accounts = number_of_accounts;
        }

        public void setTelephone_number(int telephone_number) {
            this.telephone_number = telephone_number;
        }

        public void setType(sex type) {
            this.type = type;
        }

        //special getter for one account when we have dozen accounts
        public void setAccounts_money(int i, double m) {
            this.money.set(i, m);
        }

        public void setAccounts_number(int i, long m) {
            this.account_id.set(i, m);
        }
        //-----------------------------------------------------------------

        //---------------getter methods------------------------------------
        public int getTelephone_number() {
            return telephone_number;
        }

        public long getNational_id() {
            return national_id;
        }

        public short getAge() {
            return age;
        }

        public short getNumber_of_accounts() {
            return number_of_accounts;
        }

        public String getFamily_name() {
            return family_name;
        }

        public String getName() {
            return name;
        }

        public Vector<Long> getAccount_id() {
            return account_id;
        }

        public Vector<Double> getMoney() {
            return money;
        }

        public sex getsex() {
            return type;
        }

        //special getter for one account when we have dozen accounts
        public double getAccounts_money(int i) {
            return this.money.get(i);
        }

        public long getAccounts_number(int i) {
            return this.account_id.get(i);
        }
        //-----------------------------------------------------------------

        //---------------------tostring method-----------------------------
        public String tostring() {
            return "name: " + name + " family name: " + family_name + " age: " + age + " sex type: " + type + " national id : " + national_id + " telephone number: " + telephone_number + " \nnumber of accounts: " + number_of_accounts + " \naccounts id: " + account_id + " money in every accounts(with arrangement of account id): " + money;
        }
        //-----------------------------------------------------------------

        //----------copy constructor---------------------------------------
        bank_account(final bank.system.bank_account b) {
            this.name = b.name;
            this.family_name = b.family_name;
            this.age = b.age;
            this.type = b.type;
            this.national_id = b.national_id;
            this.telephone_number = b.telephone_number;
            this.number_of_accounts = b.number_of_accounts;
            this.account_id = b.account_id;
            this.money = b.money;
        }
        //-----------------------------------------------------------------

        //-------------------equals method---------------------------------
        public boolean equals(bank.system.bank_account b) {
            if (this == b) return true;
            if (b == null) return false;
            if (getClass() != b.getClass()) return false;
            if (!this.account_id.equals(b.account_id)) return false;
            //if (!this.money.equals(b.money)) return false;
            //if (this.number_of_accounts != b.number_of_accounts) return false;
            //if (this.telephone_number != b.telephone_number) return false;
            //if (this.type != b.type) return false;
            if (this.national_id != b.national_id) return false;
            //if (this.age != b.age) return false;
            if (!this.family_name.equals(b.family_name)) return false;
            if (!this.name.equals(b.name)) return false;
            return true;
        }
        //-----------------------------------------------------------------

        //--------------deposit method-------------------------------------
        public void deposit(double money, int i) {
            double MON = this.getAccounts_money(i);
            MON += money;
            this.money.set(i, MON);
        }
        //-----------------------------------------------------------------

        //--------------withdraw method------------------------------------
        public void withdraw(double money, int i) {
            double MON = this.getAccounts_money(i);
            MON -= money;
            this.money.set(i, MON);
        }
        //-----------------------------------------------------------------

    }

    //---------function for searching our accounts by account id-----------
    //we use map for getting a specific account by account id
    static bank_account search(Map<Long, bank_account> accounts, long account_ID) {
        return accounts.get(account_ID);
    }
    //---------------------------------------------------------------------

    //--------------function for index searching account search------------
    //we use th search function for bank account then we find the index pos of each accounts in vector<Long> account_id
    //this will let us to use the bank methods
    static int index_search(Map<Long, bank_account> accounts, long account_ID) {
        int i = 0;
        bank_account p = search(accounts, account_ID);
        Vector<Long> A = p.getAccount_id();
        i = A.indexOf(account_ID);
        return i;
    }
    //---------------------------------------------------------------------

    //------------------function for national id search--------------------
    //we only using this to determine we have the same national id or not
    static boolean natID_search(long national_id, Vector<bank_account> b) {
        for (int i = 0; i < b.size(); i++) {
            long i_id = b.get(i).getNational_id();
            if (i_id == national_id) return true;
        }
        return false;
    }
    //---------------------------------------------------------------------

    //----------function for generating random bank account id-------------
    //we currently can have 16 digit number for bank id but we stick to 8 digit according to tegarat bank
    static int random_bank_id() {//8 digit
        Random random = new Random();
        int max_min = 99999999 - 10000000;
        return random.nextInt(max_min) + 10000000;
    }
    //---------------------------------------------------------------------




    //---------------------------------------------our main function--------------------------------------------------------------------------
    public static void main(String[] args) {
        //initializing our input mechanism
        Scanner scanner = new Scanner(System.in);
        //for having the total number of customers
        int number_of_customers_for_registering = 0;
        //these two containers are for two purpose 1-storage 2-bank operations
        Map<Long, bank_account> accounts = new HashMap<Long, bank_account>();//hash based map is more efficient than the ordinary ordered map
        Vector<bank_account> all_of_the_accounts = new Vector<bank_account>();
        //----------------------creating our UI----------------------------
        //label for exiting the program
        outer1:
        while (true) {
            System.out.flush();
            System.out.println("----------------------------------welcome to our bank----------------------------------------");
            System.out.println("please enter the correct option number");
            System.out.println("1:bank operations 2: register 3: find an account info by account id 4:about our bank 5: exit.");
            byte num;

            //label out of the while
            outer2:
            {
                while (true) {
                    //label to get out of the switch
                    outer3:
                    {
                        num = scanner.nextByte();
                        switch (num) {



                            //we use the bank account id for the bank operations such as deposit,...
                            case 1:{
                                long bank_id=0;
                                //first we must have the id from the clients
                                System.out.println("enter the bank account id(8 digit)[10000000-99999999] :");
                                //we must make sure that client enter the right format
                                bank_op:
                                while (true) {
                                    bank_id = scanner.nextLong();
                                    //the id must be 8 digit
                                    if (bank_id > 100000000 || bank_id < 10000000) {
                                        System.out.println("please enter the correct bank account id(8 digit) :");
                                        continue bank_op;
                                    }
                                    //what if the account doesnt exist
                                    if (search(accounts, bank_id) == null){
                                        System.out.println("this bank account id doesnt exist(no account available by that id)");
                                        byte o;
                                        //in case the client change his(or her) mind
                                        again:
                                        while (true) {
                                            System.out.println("please input the option number : 1-try again 2-exit to main menu");
                                            o = scanner.nextByte();
                                            switch (o) {
                                                case 1: {
                                                    System.out.println("try again: ");
                                                    continue bank_op;
                                                }
                                                case 2: break outer2;
                                                default:{
                                                    System.out.println("wrong option number.");
                                                    continue again;
                                                }
                                            }
                                        }
                                    }
                                    bank_account a=search(accounts, bank_id);
                                    //now we figure out which id in our vector from the class
                                    int index=index_search(accounts,bank_id);
                                    //now the main bank account operation
                                    again2:
                                    while (true) {
                                        byte op;
                                        double money;
                                        System.out.println("please input the option number : 1-deposit 2-withdraw 3-existing money  4-exit  to main menu");
                                        op=scanner.nextByte();
                                        switch (op){
                                            case 1:{
                                                //we use our class method
                                                System.out.println("enter the deposit money :");
                                                money=scanner.nextDouble();
                                                a.deposit(money,index);
                                                System.out.println("thank for your trust");
                                                break outer2;
                                            }
                                            case 2:{
                                                //we use our class method
                                                System.out.println("enter the required money :");
                                                money=scanner.nextDouble();
                                                a.withdraw(money,index);
                                                System.out.println("thank for your trust");
                                                break outer2;
                                            }
                                            case 3:{
                                                System.out.println("your current existing money is :");
                                                System.out.println(a.getAccounts_money(index));
                                                System.out.println("thank for your trust");
                                                break outer2;
                                            }
                                            case 4:break outer2;
                                            default:
                                                System.out.println("wrong option number.");
                                                continue again2;
                                        }
                                    }
                                }

                            }





                            //-----------------------------------------------------------THE ANSWER---------------------------------------------------------------------------------------------

                            //one of the important thing is we have to register some accounts first or the other options dont work
                            case 2:{
                                //first we initialize 9 types so we could get them from client and call the constructor
                                //for strings(and some others) we create them in our loop
                                //at the end we could use only equals() to prevent from creating same account but I not only use that also i check the national id and bank account id these must not be same.
                                //in a real bank system these must be check but if you want to use only equals ,comment these lines ([231-234],[267-272],[294-299])
                                System.out.println("please enter the number of registration : ");
                                number_of_customers_for_registering=scanner.nextInt();
                                scanner.nextLine();
                                //we have to continue our loop until the number_of_customers_for_registering
                                for (int i=0;i<number_of_customers_for_registering;++i){
                                    register:
                                    while (true){
                                        System.out.print((i+1)+"-\n");
                                        //-----first name-----
                                        System.out.println("please enter your name :");
                                        String name=scanner.nextLine();
                                        //-----second family name-----
                                        System.out.println("please enter your family name :");
                                        String f_name=scanner.nextLine();
                                        //-----third age-----
                                        System.out.println("please enter your age (+18 years old) : ");
                                        short age=0;
                                        age_entry:
                                        while (true){
                                            age= scanner.nextShort();
                                            if (age<18){
                                                System.out.println("you must be over 18 years old. please re-enter : ");
                                                continue age_entry;
                                            }
                                            break age_entry;
                                        }
                                        //-----fourth gender-----
                                        sex gender;
                                        gender:
                                        while (true){
                                            byte option;
                                            System.out.println("if you are male enter 1 otherwise 2 :");
                                            option=scanner.nextByte();
                                            switch (option){
                                                case 1:{
                                                    gender=sex.male;
                                                    break gender;
                                                }
                                                case 2:{
                                                    gender=sex.female;
                                                    break gender;
                                                }
                                                default:{
                                                    System.out.println("wrong option number.");
                                                    continue gender;
                                                }
                                            }
                                        }
                                        //-----fifth national id (or code)-----
                                        long national_ID=0;
                                        na_id:
                                        while (true){
                                            System.out.println("please enter your personal national id(10 digit)[1000000000-9999999999] : ");
                                            national_ID=scanner.nextLong();
                                            double range=(double)national_ID/999999999;
                                            if (range<1.000000001 || range>10.00000001){
                                                System.out.println("wrong number of digits.");
                                                continue na_id;
                                            }
//                                            if (natID_search(national_ID,all_of_the_accounts)){
//                                                System.out.println("we have an account under this national id please re-enter: ");
//                                                continue na_id;
//                                            }
                                            break na_id;
                                        }
                                        //-----sixth telephone number------
                                        int tel_number=0;
                                        tel_num:
                                        while (true){
                                            System.out.println("please enter your telephone number(8 digit)[10000000-99999999] : ");
                                            tel_number=scanner.nextInt();
                                            if (tel_number>100000000||tel_number<10000000){
                                                System.out.println("wrong number of digits.");
                                                continue tel_num;
                                            }
                                            break tel_num;
                                        }
                                        //-----seventh number of account id's-----
                                        System.out.println("please enter the number of account ids you want to have :");
                                        short number_of_accounts=scanner.nextShort();
                                        //-----eight account id's-----
                                        Vector<Long> BANK_ACC_ID = new Vector<Long>();
                                        acc_id:
                                        while (true){
                                            byte options;
                                            System.out.println("choose one of the two ways for your bank account id number: 1-by machine 2-by manual");
                                            options=scanner.nextByte();
                                            switch (options){
                                                case 1:{
                                                    System.out.println("these are your bank account ids (make sure you remember them) :");
                                                    for (int k = 0; k < number_of_accounts; k++) {
                                                        acc_id_mech:
                                                        while (true) {
                                                            long acc = 0;
                                                            acc = random_bank_id();
                                                            for (int s = 0; s < all_of_the_accounts.size(); s++) {
                                                                if (accounts.get(acc) != null) {
                                                                    System.out.println("sorry for our system issue new ids are : ");
                                                                    continue acc_id_mech;
                                                                }
                                                            }
                                                            BANK_ACC_ID.add(acc);
                                                            System.out.println(acc);
                                                            break acc_id_mech;
                                                        }
                                                    }
                                                    break acc_id;
                                                }
                                                case 2:{
                                                    short index=number_of_accounts;
                                                    System.out.println("enter your bank accounts id(8digit)[10000000-99999999] : ");
                                                    entering:
                                                    while (true) {
                                                        if (index==0){
                                                            break acc_id;
                                                        }
                                                        long acc=0;
                                                        acc=scanner.nextLong();
                                                        if (acc > 100000000 || acc < 10000000) {
                                                            System.out.println("please enter the correct bank account id(8 digit) :");
                                                            continue entering;
                                                        }
//                                                        for (int s=0;s<all_of_the_accounts.size();s++){
//                                                            if(accounts.get(acc)!=null){
//                                                                System.out.println("we currently have this id so re_enter new one : ");
//                                                                continue entering;
//                                                            }
//                                                        }
                                                        BANK_ACC_ID.add(acc);
                                                        index--;
                                                        scanner.nextLine();
                                                    }
                                                }
                                                default:{
                                                    System.out.println("wrong option number.");
                                                    continue acc_id;
                                                }
                                            }
                                        }
                                        //-----ninth adding money-----
                                        Vector<Double> MONEY=new Vector<Double>();
                                        System.out.println("enter accounts money : ");
                                        for (int z=0;z<number_of_accounts;z++){
                                            double money=0;
                                            money=scanner.nextDouble();
                                            MONEY.add(money);
                                            scanner.nextLine();
                                        }
                                        //-----now storage and check and creation-----
                                        bank_account a=new bank_account(name,f_name,age,gender,national_ID,tel_number,number_of_accounts,BANK_ACC_ID,MONEY);
                                        for (int m=0;m<all_of_the_accounts.size();m++){
                                            if (a.equals(all_of_the_accounts.get(m))){
                                                System.out.println("we already have the same account so try again : ");
                                                continue register;
                                            }
                                        }
                                        all_of_the_accounts.add(a);
                                        for (int n=0;n<number_of_accounts;n++){
                                            accounts.put(BANK_ACC_ID.get(n),a);
                                        }
                                        break register;
                                    }
                                }
                                break outer2;
                            }

                            //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------




                            // for make sure that we get the account info we need a search method and a way to print this info
                            case 3:{
                                long bank_id=0;
                                //first we must have the id from the clients
                                System.out.println("enter the bank account id(8 digit)[10000000-99999999] :");
                                search:
                                while (true) {
                                    bank_id = scanner.nextLong();
                                    if (bank_id>100000000||bank_id<10000000){
                                        System.out.println("please enter the correct bank account id(8 digit) :");
                                        continue search;
                                    }
                                    bank_account a;
                                    String name, family_name;
                                    //now we have to search the account and print the owner info
                                    if (search(accounts, bank_id) != null) {
                                        a = search(accounts, bank_id);
                                        name = a.getName();
                                        family_name = a.getFamily_name();
                                        System.out.print("this accounts is registered to: ");
                                        System.out.print(name);
                                        System.out.print(" ");
                                        System.out.print(family_name);
                                    }
                                    if (search(accounts, bank_id) == null){
                                        System.out.println("this bank account id doesnt exist(no account available by that id) ");
                                        byte o;
                                        op:
                                        while (true) {
                                            System.out.println("please input the option number : 1-try again 2-exit  to main menu");
                                            o = scanner.nextByte();
                                            switch (o) {
                                                case 1:
                                                    continue search;
                                                case 2:
                                                    break outer2;
                                                default:
                                                    System.out.println("wrong option number.");
                                                    continue op;
                                            }
                                        }
                                    }
                                    break search;
                                }
                                break outer2;
                            }




                            //just for number of individuals
                            case 4:{
                                System.out.println("number of our total customers(individuals) :");
                                System.out.println(all_of_the_accounts.size());
                                System.out.println("this program designed by pouya ardehkhani");
                                break outer2;
                            }




                            //this will break out of the first while loop and end the program
                            case 5: break outer1;



                            //in case we didnt correctly enter the option number
                            default:
                                System.out.println("enter the correct option number: ");
                                break outer3;
                        }
                    }
                }
            }

        }

        System.exit(0);
    }//-----------------------------------------------------------------------------------------------------------------
}
