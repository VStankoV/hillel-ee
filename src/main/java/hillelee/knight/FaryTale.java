package hillelee.knight;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

public class FaryTale {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("hillelee");
//		Knight knight = new Knight(new Quest());

//		System.out.println(context.getBean(Knight.class));
		System.out.println(context.getBean("knight123"));
		
		
		Knight knight1 = context.getBean(Knight.class);
		Knight knight2 = context.getBean(Knight.class);
		
		
		System.out.println(knight1 == knight2);
	}
}

@Configuration
class Config {
	@Bean
	public Knight knight123(/*@Qualifier("rescueThePrinces")*/ Quest quest) {
		return new Knight(quest);
	}
	
	@Bean
	@Primary
	Quest killTheDragon() {
		return new Quest("Kill the Dragon");
	}
	
	@Bean
	Quest rescueThePrinces() {
		return new Quest("Rescue The Princes");
	}
	
	
}


@Data
//@Component("myKnight")
//@Scope(SCOPE_PROTOTYPE)
class Knight {
	private final Quest quest;
}

@Data
//@Component
class Quest {
	private final String task;
}
