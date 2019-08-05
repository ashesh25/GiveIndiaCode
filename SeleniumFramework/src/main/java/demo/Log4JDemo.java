package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {
	
	static Logger log = LogManager.getLogger(Log4JDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello World \n");
		log.info("This is an information");
		log.error("Thiss is an error message");
		log.fatal("This is a fatal message");
		log.warn("This is a warning");
		
		System.out.println("/ It's over");
	}

}
