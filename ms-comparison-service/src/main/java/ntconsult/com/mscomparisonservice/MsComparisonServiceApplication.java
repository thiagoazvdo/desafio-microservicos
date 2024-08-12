package ntconsult.com.mscomparisonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsComparisonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsComparisonServiceApplication.class, args);
	}

}
