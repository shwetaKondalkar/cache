package com.mycache.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
public class App 
{
    public static void main( String[] args )
    {
    	Jedis jedis = new Jedis("192.168.2.155"); 
	     System.out.println("Connection successful"); 
		  
	   //Checking server
	     System.out.println("Getting response from the server: "+ jedis.ping()); 
	     jedis.flushAll(); 
    	 SpringApplication.run(App.class, args);
    }
}
