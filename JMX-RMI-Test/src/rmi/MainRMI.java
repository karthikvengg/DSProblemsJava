package rmi;
import java.io.IOException;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import jmx.SystemConfigMBean;

public class MainRMI {

    public static final String HOST = "localhost";
    public static final String PORT = "4000";

    public static void main(String[] args) throws IOException, MalformedObjectNameException {
        JMXServiceURL url =
            new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + HOST + ":" + PORT + "/jmxrmi");

        JMXConnector jmxConnector = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();
        ObjectName mbeanName = new ObjectName("com.journaldev.jmx:type=SystemConfig");
        SystemConfigMBean mbeanProxy =
            (SystemConfigMBean) MBeanServerInvocationHandler.newProxyInstance(
                mbeanServerConnection, mbeanName, SystemConfigMBean.class, true);
        System.out.println("Current SystemConfig::" + mbeanProxy.doConfig());
        
        mbeanProxy.setSchemaName("NewSchema");
        mbeanProxy.setThreadCount(0);
        //close the connection
        jmxConnector.close();
    }
}