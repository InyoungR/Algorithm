package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_9760_PokerGame {
    static class card{
        int type; int num;

        public card(char t, int num) {
            switch(t){
                case 'S':
                    this.type = 0;
                    break;
                case 'D':
                    this.type = 1;
                    break;
                case 'H':
                    this.type = 2;
                    break;
                case 'C':
                    this.type = 3;
                    break;
            }
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        card [] cards = new card[5];
        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());

            for(int i=0; i<5; i++){
                String msg = st.nextToken();
                char temp = msg.charAt(1);

                switch(temp){
                    case 'A':
                        cards[i] = new card(msg.charAt(0),1);
                        break;
                    case 'J':
                        cards[i] = new card(msg.charAt(0),11);
                        break;
                    case 'Q':
                        cards[i] = new card(msg.charAt(0),12);
                        break;
                    case 'K':
                        cards[i] = new card(msg.charAt(0),13);
                        break;
                    case 'T':
                        cards[i] = new card(msg.charAt(0),10);
                        break;
                    default:
                        cards[i] = new card(msg.charAt(0),temp-'0');
                }
            }
            sb.append("#").append(t).append(" ");
            switch(Pattern(cards)){
                case 1:
                    sb.append("Straight Flush").append("\n");
                    break;
                case 2:
                    sb.append("Four of a Kind").append("\n");
                    break;
                case 3:
                    sb.append("Full House").append("\n");
                    break;
                case 4:
                    sb.append("Flush").append("\n");
                    break;
                case 5:
                    sb.append("Straight").append("\n");
                    break;
                case 6:
                    sb.append("Three of a kind").append("\n");
                    break;
                case 7:
                    sb.append("Two pair").append("\n");
                    break;
                case 8:
                    sb.append("One pair").append("\n");
                    break;
                case 9:
                    sb.append("High card").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static int Pattern(card[] cards){
        int [] types = new int [4];
        int [] samekind = new int [2];
        int same = 0;
        int royal[] = {1,10,11,12,13};

        Arrays.sort(cards, (o1, o2) -> o1.num-o2.num);
        boolean isRoyal = true;
        boolean isStraight = true;
        for(int i=0; i<5; i++){
            types[cards[i].type] += 1;
            if(cards[i].num != royal[i]) isRoyal = false;
            if(i>=1 && cards[i].num != cards[i-1].num+1) isStraight = false;
            if(i>=1 && cards[i].num == cards[i-1].num) samekind[same]++;
            if(i>=1 && cards[i].num != cards[i-1].num && samekind[same]>0 && same == 0) same++;
        }

        int max = Arrays.stream(types).max().getAsInt();

        if(max == 5 && (isRoyal || isStraight)) return 1;
        if(max == 5) return 4;
        if(isStraight) return 5;
        if(samekind[0] == 3) return 2;

        if((samekind[0] ==1 && samekind[1] ==2) || (samekind[0] ==2 && samekind[1] ==1)) return 3;
        if(samekind[0] == 2) return 6;
        if(samekind[0] == 1 && samekind[1] ==1) return 7;
        if(samekind[0] == 1) return 8;
        return 9;
    }
}
