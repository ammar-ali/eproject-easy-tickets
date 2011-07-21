/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.sql.Timestamp;


/**
 *
 * @author Admin
 */
public class StringELF {

    public static Integer validatePositiveNumber(String number) {
                String temp = "0123456789";
        int i;
        for (i = 0; i < number.length(); i++) {
            int j;
            for (j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == number.charAt(i)) {
                    j = temp.length();
                }
            }

            if (j != temp.length() + 1) {
                i = number.length();
            }
        }
        if (i == number.length() + 1) {
            return new Integer(0);
        }
        return new Integer(1);
    }

    public static Timestamp convertStringToTimestamp(String date,String format) throws IllegalArgumentException{
        if(date!=null){
            String[] dates = date.split("-");
            if(dates.length==3){
                boolean stt = true;
                if(!StringUtil.validatePositiveNumber(dates[0])){
                    stt=false;
                }if(!StringUtil.validatePositiveNumber(dates[1])){
                    stt=false;
                }if(!StringUtil.validatePositiveNumber(dates[2])){
                    stt=false;
                }
                if(stt==true){
                    if(format.equals("mm-dd-yyyy")){
                    return new Timestamp(Integer.parseInt(dates[2]),Integer.parseInt (dates[0]), Integer.parseInt(dates[1]), 0, 0, 0, 0);
                    }
                    else if(format.equals("yyyy-mm-dd")){
                        return new Timestamp(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]), 0, 0, 0, 0);

                    }
                    else new IllegalArgumentException("Format of date is wrong ");
                }
            }
        }
        return new Timestamp(0);
    }

}
