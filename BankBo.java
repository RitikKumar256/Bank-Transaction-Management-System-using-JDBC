package max.bo;

import java.util.Random;

import max.bean.BankBean;
import max.dao.BankDao;
import max.dto.BankDTO;

public class BankBo {
public int getDetail(BankBean bb) {
	BankDTO bdto=new BankDTO();
	String n=bb.getName();
	bdto.setName(n.toUpperCase());
	bdto.setAcc(bb.getAcc().length()>=11?bb.getAcc():"0000");	
	bdto.setIfsc(bb.getIfsc());
	bdto.setAmt(bb.getAmt());
	bdto.setTid(getID());
	BankDao bankDao=new BankDao();
	
	return bankDao.insert(bdto);
	
}
private String getID() {
	StringBuffer sb=new StringBuffer();
	for(int i=0; i<=9;i++) {
		sb.append(new Random().nextInt(10));
	}
	
	return sb.toString();
}
}
