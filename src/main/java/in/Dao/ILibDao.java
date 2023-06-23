package in.Dao;

import in.dto.Librarian;

public interface ILibDao extends IDao{
  String getRegistered(Librarian lib1);
  boolean checkLibrarian(String userid,String pass);
  
}
