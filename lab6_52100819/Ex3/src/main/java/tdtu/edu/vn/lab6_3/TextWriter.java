package tdtu.edu.vn.lab6_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public interface TextWriter {
    @Bean
    public void write(String content,String path);
}
