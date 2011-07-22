/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class TicketBookConvert {
    
    public static Object castAttributeRequestIsNull(HttpServletRequest request,String attName,Object value2){
        if(request==null){
            return value2;
        }else {
            if(request.getAttribute(attName)==null)
                return value2;
            else
                return request.getAttribute(attName);
        }
    }

    public static String castParameterRequestIsNull(HttpServletRequest request,String attName,String value2){
        if(request==null){
            return value2;
        }else {
            if(request.getParameter(attName)==null)
                return value2;
            else
                return StringUtil.convertToUTF8(request.getParameter(attName));
        }
    }

    public static Object castSessionIsNull(HttpSession request,String attName,Object value2){
        if(request==null){
            return value2;
        }else {
            if(request.getAttribute(attName)==null)
                return value2;
            else
                return request.getAttribute(attName);
        }
    }
}
