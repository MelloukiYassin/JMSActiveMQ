package jmsenset;

import java.net.URI;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;



public class ActiveMQBroker {

	public static void main(String[] args) {
		try {
			BrokerService broker = new BrokerService();
			broker.setPersistent(false);
			TransportConnector connector = new TransportConnector();
			connector.setUri(new URI("tcp://0.0.0.0:61616"));
			broker.addConnector(connector);
			broker.start();
			System.out.println("Broker Started!!!");
	        // now lets wait forever to avoid the JVM terminating immediately
	        Object lock = new Object();
	        synchronized (lock) {
	            lock.wait();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
