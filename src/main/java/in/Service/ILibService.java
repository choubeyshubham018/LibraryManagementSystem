package in.Service;

import in.dto.Librarian;

public interface ILibService  {
String getRegistered(Librarian lib1);
boolean checkLibrarian(String userid,String pass);
}
