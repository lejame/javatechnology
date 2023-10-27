package vn.edu.tdtd.lab6_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplication {
    public static void main(String[] agrs){
        ApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Product product1 = (Product) applicationContext.getBean("product1");
        System.out.println("id of product:"+product1.getId());
        System.out.println("name of product:"+product1.getName());
        System.out.println("price of product:"+product1.getPrice());
        System.out.println("depcription of product:"+product1.getDepcription());

    }
}
