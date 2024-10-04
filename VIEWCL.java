package max.cl;


import java.util.Iterator;
import java.util.List;

import max.dao.BankDao;
import max.dto.BankDTO;

public class VIEWCL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BankDao bankDao=new BankDao();
       List<BankDTO> list=bankDao.view("1318985751");
        Iterator<BankDTO> it=list.iterator();
        while(it.hasNext()) {
	 BankDTO t=it.next();
	 System.out.println("-------------------------");
	 System.out.println(t.getAcc()+" "+t.getAmt()+" "+t.getIfsc()+" "+t.getTid());
        }
//ORR another method to print
    //for(BankDTO q:list)
////       {
////    	   System.out.println("------------------------------------");
////    	   System.out.println(q.getAcc()+" "+q.getAmt()+" "+q.getIfsc()+" "+q.getTid());
////       }
//       
	}

}
