package ticketbook.taglib;

import java.util.ArrayList;

public interface IPaging {
	
	public IndexNum getIndexStart();
	public IndexNum getIndexEnd();
	public ArrayList divide();
}
