package tdtu.edu.vn.lab6_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.management.MXBean;

@Configuration
public class ApplicationConfig {
    @Bean
    @Scope("prototype")
    public Product product1(){
        Product pr = new Product(1,"Iphone",10000.0,"15 Pro");
        return pr;
    }
    public String toString(){
        return "Product{id:"+ product1().getId()+" name:"+product1().getName()+" price:"+product1().getPrice()+" depcription:"+product1().getDepcription()+"}";
    }
}
