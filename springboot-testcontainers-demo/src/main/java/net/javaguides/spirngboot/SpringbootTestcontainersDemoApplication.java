package net.javaguides.spirngboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.terraform.TerraformClient;

@SpringBootApplication
public class SpringbootTestcontainersDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestcontainersDemoApplication.class, args);
	}
	 @Autowired
	    private TerraformClient terraform;

	    @Override
	    public void run(String... args) throws Exception {
	        try {
	            this.terraform.setOutputListener(System.out::println);
	            this.terraform.setErrorListener(System.err::println);

	            this.terraform.setWorkingDirectory("/some/local/path/");
	            this.terraform.plan().get();
	            this.terraform.apply().get();
	        } finally {
	            this.terraform.close();
	        }
	    }
}
