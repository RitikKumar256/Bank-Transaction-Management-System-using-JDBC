package max.cl;
import java.util.Scanner;

import max.bean.BankBean;
import max.bo.BankBo;

public class CL {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter Amount");
	int amt=Integer.parseInt(s.nextLine());
	System.out.println("Enter Account");
	String acc=s.nextLine();
	System.out.println("Enter IFSC");
	String ifsc=s.nextLine();
	System.out.println("Enter name");
	String name=s.nextLine();
	BankBean bb=new BankBean();
	bb.setAmt(amt);
	bb.setAcc(acc);
	bb.setIfsc(ifsc);
	bb.setName(name);
   BankBo bbo=new BankBo();
if(bbo.getDetail(bb)>0) 
{
	System.out.println("success");
}
else {
	System.out.println("fail");
}
	}

}
