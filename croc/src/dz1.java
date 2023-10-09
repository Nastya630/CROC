import java.util.*;

public class dz1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str = str.toLowerCase();//приводятся все символы к нижнему регистру
        str = str.replaceAll("[^а-я]", "");//удаляются все элементы, не входящие в русский алфавит
        int len=str.length();
        boolean fl=true;
        for (int i = 0;i<len/2; i++){
            if (str.charAt(i)!=str.charAt(len-1-i)){
                fl=false;
                break;
            }
        }
        if (fl){
            System.out.println("Фраза является палиндромом.");
        }
        else{
            System.out.println("Фраза НЕ является палиндромом.");
        }
    }
}
