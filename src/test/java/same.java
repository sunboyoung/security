import java.util.Scanner;

public class same {
    public static void main(String[] args) {
        System.out.print("请输入您的数组:");
        Scanner sc=new Scanner(System.in);
        StringBuffer sb=new StringBuffer(sc.nextLine());
        StringBuffer sb1=new StringBuffer();
        char[] stringArr=sb.toString().toCharArray();
        char[] tempArr=sb.toString().toCharArray();
        for(int i=0;i<stringArr.length/2;i++){
                char temp;
                temp=stringArr[i];
                stringArr[i]=stringArr[stringArr.length-i-1];
                stringArr[stringArr.length-i-1]=temp;
        }
        for(int i=0;i<stringArr.length;i++){
                if(stringArr[i]!=tempArr[i]){
                    System.out.println("不是回文");
                    return ;
                }
                if(i==stringArr.length-1&&stringArr[i]==tempArr[i]){
                    System.out.println("是回文");
                }
        }
    }
}
