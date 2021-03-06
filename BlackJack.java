import java.util.Scanner;
public class BlackJack{
  public static void main(String[] args){       
    Scanner Q = new Scanner(System.in);
    System.out.println("What is your name?");
    String Name = Q.nextLine();
    Player p1 = new Player(Name);
    p1.dollar=10;
    while(0<2){
      p1.betting = betting(p1);
      p1.total = play_human(p1);
      int computer_total = play_computer();
      calculate_winner(p1,computer_total);
      Scanner RePlay = new Scanner(System.in);
      System.out.println("Play again?");
        String A = RePlay.nextLine();
        if(A.equals("Y")){
          continue;}
        break;
      }
  }
    public static int betting(Player x){
      
      System.out.println(x.name+" has "+x.dollar);
      Scanner M = new Scanner(System.in);
      System.out.println("How much will you bet?");
      int m = M.nextInt();
      if(m<=10 && m>=0){
        x.dollar = x.dollar - m;
      }
      else{
        System.out.println("No Money");
        m=0;
      }
      return m;}

    public static int play_human(Player x){
      int human_card1 = (int)(Math.random()*11)+1;
      int human_card2 = (int)(Math.random()*11)+1;
      System.out.println(x.name+" player got");
      System.out.println(human_card1+" and "+human_card2);
      int human_total = human_card1 + human_card2;
      while(0<1){
        if(human_total<21){
          Scanner i = new Scanner(System.in);
          System.out.println("Do you want another card (Y/N)");
          String s = i.nextLine();
          if(s.equals("Y")){
            int human_card3 = (int)(Math.random()*11)+1;
            human_total=human_total+human_card3;
            System.out.println("new human_total "+ human_total);}
          else if(s.equals("N")){
            System.out.println(human_total);
            break;
          }
          else{
            continue;}}
        else{
          break;}
        } 
      return human_total;
      }
    public static int play_computer(){
      int computer_card1 = (int)(Math.random()*11)+1;
      int computer_card2 = (int)(Math.random()*11)+1;
      int computer_total = computer_card1 + computer_card2;
      System.out.println("Computer player got");
      System.out.println(computer_card1+" and "+computer_card2);
      return computer_total;
    }
    
    public static void calculate_winner(Player p1,int computer_total){
      int computer_dollar=10;
      if(p1.total<=21 && computer_total<p1.total){
        System.out.println(p1.name+" Wins");
        System.out.println("Computer Loses $"+(p1.betting));
        System.out.println(p1.name+" has $"+p1.dollar+(p1.betting*2));
        System.out.println("Computer has $"+ (computer_dollar-p1.betting));
      }
      else{
        System.out.println("Computer Wins");
        System.out.println(p1.name+" Loses$"+(p1.betting));
        System.out.println(p1.name+" has&"+(p1.dollar));
        System.out.println("Computer has$"+(computer_dollar+p1.betting));
        
        
      }
    }
    }
    