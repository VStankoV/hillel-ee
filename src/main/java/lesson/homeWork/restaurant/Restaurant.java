package lesson.homeWork.restaurant;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.awt.datatransfer.DataTransferer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

enum DishType {
	BEEF,
	CHICKEN,
	VEGETABLES
}

@Data
@AllArgsConstructor
class Dish {
	private String name;
	private Integer calories;
	private Boolean isBio;
	private DishType type;
}

public class Restaurant {
	private static final Integer LOW_CALORIC_BARRIER = 150;
	static List<Dish> menu = ImmutableList.of(
			new Dish("Dish2", 200, false, DishType.BEEF),
			new Dish("Dish1", 300, true, DishType.BEEF),
			new Dish("Dish3", 700, true, DishType.BEEF),
			new Dish("Salad1", 50, true, DishType.VEGETABLES),
			new Dish("Dish4", 400, false, DishType.BEEF),
			new Dish("Salad2", 70, true, DishType.CHICKEN),
			new Dish("Salad3", 80, true, DishType.VEGETABLES)
	);
	
	public static void main(String[] args) {
	
//		1. Вывести названия блюд:
//			a. только низкокаллорийных
//		getLowCaloricDishes().forEach(System.out::println);
//			b. топ-3 самых питательных
//		getTopNutritious(3).forEach(System.out::println);
//			c. всех, но отсортированных сначала по БИО, потом по алфавиту
//		getSortedDishes().forEach(System.out::println);
		

//		2. Посчитать среднюю калорийность по группам: говядина, курица, овощи (Map<DishType, Double>)
//		getAvgCalloriesByType()
//				.forEach((dishType, aDouble) -> System.out.println(dishType.toString() + " - " + aDouble));


//		3. Сгрупировать в Map<DishType, List<String>> БИО блюда
//		getBioDishesByType().forEach((dishType, strings) -> {
//			System.out.println(dishType);
//			strings.forEach(System.out::println);
//		});
	}
	
	static List<Dish> getTopNutritious(Integer limit) {
		return menu.stream()
				.sorted((o1, o2) -> o2.getCalories() - o1.getCalories())
				.limit(limit)
				.collect(toList());
	}
	
	static List<Dish> getLowCaloricDishes() {
		return menu.stream()
				.filter(dish -> dish.getCalories() < LOW_CALORIC_BARRIER)
				.collect(toList());
	}
	
	static List<Dish> getSortedDishes() {
		return menu.stream()
				.sorted(Comparator.comparing(Dish::getIsBio).reversed().thenComparing(Comparator.comparing(Dish::getName)))
				.collect(toList());
	}
	
	
	static Map<DishType, Double> getAvgCalloriesByType() {
		Map<DishType, List<Dish>> dishTypeListMap = menu.stream().collect(groupingBy(Dish::getType));
		Map<DishType, Double> result = new HashMap();
		dishTypeListMap.forEach(
				(dishType, dishes) -> result.put(dishType, dishes.stream()
						.mapToDouble(Dish::getCalories)
						.reduce((left, right) -> (left + right) / 2).orElse(0.0)
				)
		);
		return result;
	}
	
	static Map<DishType, List<String>> getBioDishesByType() {
		Map<DishType, List<Dish>> dishTypeListMap = menu.stream()
				.filter(Dish::getIsBio)
				.collect(Collectors.groupingBy(Dish::getType));
		
		Map<DishType, List<String>> result = new HashMap<>();
		
		dishTypeListMap.forEach(
				(dishType, dishes) -> result.put(dishType, dishes.stream()
						.map(Dish::getName)
						.collect(toList())
				)
		);
		
		return result;
	}
	
}


