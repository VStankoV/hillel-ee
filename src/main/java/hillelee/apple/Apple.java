package hillelee.apple;

import com.google.common.collect.ImmutableList;
import hillelee.defaultMethods.Fruit;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class Apple implements Fruit {
	String color;
	Integer weight;
	List<String> worms = ImmutableList.of("worm1", "worm2", "worm3");
	
	public Apple(String color, Integer weight) {
		this.color = color;
		this.weight = weight;
	}
}
