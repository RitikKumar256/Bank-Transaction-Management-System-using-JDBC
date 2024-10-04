package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.JDBCConn;
import max.dto.BankDTO;

public class BankDao {
	public List<BankDTO> view() {
		
		List<BankDTO> list = new ArrayList<BankDTO>();
		Connection con =JDBCConn.getConn();
	   try {
		  PreparedStatement ps= con.prepareStatement("select * from bank");
        ResultSet rs=ps.executeQuery();
	    while(rs.next()) {
	    	BankDTO bdto=new BankDTO();
	    	String tid=rs.getString("tid");
	    	String ifsc=rs.getString("ifsc");
	    	int amt=rs.getInt("amt");
	    	String acc=rs.getString("acc");
           bdto.setAcc(acc);
           bdto.setAmt(amt);
           bdto.setIfsc(ifsc);
           bdto.setTid(tid);
           list.add(bdto);
           
	    }
	   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return list;
	}
	public List<BankDTO> view(String tid) {
		
		List<BankDTO> list = new ArrayList<BankDTO>();
		Connection con =JDBCConn.getConn();
	   try {
		  PreparedStatement ps= con.prepareStatement("select * from bank where tid=?");
           ps.setString(1, tid);
		  ResultSet rs=ps.executeQuery();
	    while(rs.next()) {
	    	BankDTO bdto=new BankDTO();
           
	     bdto.setAcc(rs.getString("acc"));
           bdto.setAmt(rs.getInt(3));
           bdto.setIfsc(rs.getString(2));
           bdto.setTid(rs.getString(1));
           list.add(bdto);
           
           
	    }
	   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return list;
	}
public int insert(BankDTO bdto) {
try {
		Connection con =JDBCConn.getConn();
	  PreparedStatement ps=con.prepareStatement("insert into bank values(?,?,?,?)");
	  ps.setString(1,bdto.getTid());
	  ps.setString(2,bdto.getIfsc());
	  ps.setInt(3,bdto.getAmt());
	  ps.setString(4,bdto.getAcc());
      return ps.executeUpdate();

	}
	catch(Exception e) {
		
	}

		return 0;
}
}
