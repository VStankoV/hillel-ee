package hillelee.knight;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class FaryTale {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("hillelee");
//		Knight knight = new Knight(new Quest());
		
		System.out.println(context.getBean(Knight.class));
		
		
	}
}

@Data
@Component
class Knight {
	private final Quest quest;
}

@Data
@Component
class Quest {
	private String task = "Kill the Dragon";
}
