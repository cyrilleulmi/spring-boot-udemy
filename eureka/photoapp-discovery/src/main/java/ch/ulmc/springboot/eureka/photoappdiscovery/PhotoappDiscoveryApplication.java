package ch.ulmc.springboot.eureka.photoappdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoappDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappDiscoveryApplication.class, args);
	}

}
