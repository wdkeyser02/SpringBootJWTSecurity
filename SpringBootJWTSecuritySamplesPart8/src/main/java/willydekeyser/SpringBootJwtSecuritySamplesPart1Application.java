package willydekeyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import willydekeyser.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SpringBootJwtSecuritySamplesPart1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtSecuritySamplesPart1Application.class, args);
	}

}
