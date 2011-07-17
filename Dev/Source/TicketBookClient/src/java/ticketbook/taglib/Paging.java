package ticketbook.taglib;

import java.util.ArrayList;

public class Paging implements IPaging {
	ArrayList indexNum;
	
	int totalRecord;
	int index;
	int numRecordDivide;
	int numPageDivide;
	String nameIndexStart;
	String nameIndexEnd;
	int pos;

	public Paging(){
		this.indexNum=new ArrayList();
		this.nameIndexStart="First";
		this.nameIndexEnd="End";
		this.pos=1;
	}
	
	public IndexNum getIndexStart(){
		IndexNum indexStart=new IndexNum();
		indexStart.setDisplay(this.nameIndexStart);
		indexStart.setIndex(this.pos);
		return indexStart;
	}
	
	public IndexNum getIndexEnd(){
		IndexNum indexEnd=new IndexNum();
		indexEnd.setDisplay(this.nameIndexEnd);
		int num=0;
    	int mod=this.totalRecord%this.numRecordDivide;
    	if(mod>0){
    		num=this.totalRecord/this.numRecordDivide+1;
    	}
    	else{
    		num=this.totalRecord/this.numRecordDivide;		
    	}
    	indexEnd.setIndex(num);
		return indexEnd;
	}
	
	
	public void setNameIndexStart(String name){
		this.nameIndexStart=name;
	}
	
	public void setNameIndexEnd(String name){
		this.nameIndexEnd=name;
	}
	
	
	public void setIndex(int index){
		this.index=index;
	}
	
	public void setTotalRecord(int totalRecord){
		this.totalRecord=totalRecord;
	}
	
	public void setNumRecordDivide(int numRecordDivide){
		this.numRecordDivide=numRecordDivide;
	}
	
	public void setNumPageDivide(int numPageDivide){
		this.numPageDivide=numPageDivide;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public int getTotalRecord(){
		return this.totalRecord;
	}
	
	public int getNumRecordDivide(){
		return this.numRecordDivide;
	}
	
	public int getNumPageDivide(){
		return this.numPageDivide;
	}
	
	public ArrayList divide(){
		
         ArrayList indexList = new ArrayList();
         int j = this.pos;
         if (this.index > 1)
        	 this.index = this.index - 1;
         

         while (this.index <= (totalRecord) / numRecordDivide && j <= numPageDivide)
         {
        	 IndexNum indexNumber=new IndexNum();
        	 
        	 indexNumber.setIndex(this.index);
             indexList.add(indexNumber);
             this.index++;
             j++;
         }
         if (totalRecord % this.numRecordDivide != 0 && totalRecord > this.numRecordDivide && j <= this.numPageDivide)
         {
        	 IndexNum indexNumber=new IndexNum();
        	 indexNumber.setIndex(this.index);
                indexList.add(indexNumber);
         }

         return indexList;
	}

	
}
