package hillelee.apple;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppleSelector {
	public static Optional<Apple> getHeviest(List<Apple> apples) {
		Apple heviest = null;

		for (Apple apple : apples) {
			if (heviest == null || apple.getWeight() > heviest.getWeight()) {
				heviest = apple;
			}
		}
		
		return Optional.ofNullable(heviest);
		
//		Optional<Apple> max = apples.stream().max(Comparator.comparingInt(Apple::getWeight));
//		return max;
	}
	
	
	public static List<Apple> filterHeawyThen(List<Apple> apples, Predicate predicate) {
		return (List<Apple>) apples.stream().filter(predicate).collect(Collectors.toList());
	}
}
