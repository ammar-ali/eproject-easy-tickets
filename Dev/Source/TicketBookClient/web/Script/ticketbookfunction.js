/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
            

var Validate={
		isAllSpace:function(str){
			  i=0;
                    while(i<str.length&&str.charAt(i)==' ')
                        i++;
                    if(i==str.length)
                        return true;
                    else
                        return false;
		},

		isNumber:function(str){
                    num="0123456789";
                    for(i=0;i<str.length;i++)
                    {
                        for(j=0;j<num.length;j++)
                        {
                            if(str.charAt(i)==num.charAt(j)){
                                j=num.length;
                            }
                        }
                        if(j!=num.length+1)
                            return false;
                    }
                    return true;
		}

}

