/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.naming.Context;

/**
 *
 * @author Admin
 */
public class Setting {

    public static final String JAVA_NAMING_FACTORY_INITIAL=Context.INITIAL_CONTEXT_FACTORY;
    public static final String ORG_JNP_INTERFACES_NAMINGCONTEXTFACTORY=org.jnp.interfaces.NamingContextFactory.class.getName();
    public static final String JAVA_NAMING_PROVIDER_URL=Context.PROVIDER_URL;
    public static final String LOCALHOST_1099="localhost:1099";
    public static final String JAVA_NAMING_FACTORY_URL_PKGS="java.naming.factory.url.pkgs";
    public static final String ORG_JBOSS_NAMING="org.jboss.naming";

    public static final String[][] SYSTEMPROPERTIES_CONFIG_FOR_ENTITYBEAN=new String[][]{
      new String[]{Setting.JAVA_NAMING_FACTORY_INITIAL,Setting.ORG_JNP_INTERFACES_NAMINGCONTEXTFACTORY},
      new String[]{Setting.JAVA_NAMING_PROVIDER_URL,Setting.LOCALHOST_1099},
      new String[]{Setting.JAVA_NAMING_FACTORY_URL_PKGS,Setting.ORG_JBOSS_NAMING}
    };

    public static final String[][] SYSTEMPROPERTIES_CONFIG_FOR_SESSIONBEAN=new String[][]{
      new String[]{Setting.JAVA_NAMING_FACTORY_INITIAL,Setting.ORG_JNP_INTERFACES_NAMINGCONTEXTFACTORY},
      new String[]{Setting.JAVA_NAMING_PROVIDER_URL,Setting.LOCALHOST_1099}
    };
    
}
