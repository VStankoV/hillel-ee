package hillelee.apple;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AppleSelectorTest {
	List<Apple> apples = ImmutableList.of(
			new Apple("RED", 100),
			new Apple("GREEN", 500),
			new Apple("RED", 400),
			new Apple("RED", 150),
			new Apple("BLUE", 300),
			new Apple("RED", 109),
			new Apple("BLACK", 105)
	);
	
	
	@Test
	public void getHeviest() throws Exception {
		List<Apple> apples = ImmutableList.of(
				new Apple("RED", 100),
				new Apple("GREEN", 500),
				new Apple("RED", 400),
				new Apple("RED", 150),
				new Apple("BLUE", 300),
				new Apple("RED", 100),
				new Apple("BLACK", 105)
		);
		
		
		Optional<Apple> heviest = AppleSelector.getHeviest(apples);
		
		if (heviest.isPresent()) {
			assertThat(heviest.get().getWeight(), is(500));
		} else {
			fail();
		}
		
		
	}
	
	@Test
	public void getHeviestFromEmptyList() throws Exception {
		List<Apple> apples = ImmutableList.of();
		
		Optional<Apple> heviest = AppleSelector.getHeviest(apples);
		
		if (heviest.isPresent()) {
			fail();
		}
		
	}
	
	
	@Test
	public void sortTest() throws Exception {
		List<Apple> apples = ImmutableList.of(
				new Apple("RED", 100),
				new Apple("GREEN", 500),
				new Apple("RED", 400),
				new Apple("RED", 150),
				new Apple("BLUE", 300),
				new Apple("RED", 100),
				new Apple("BLACK", 105)
		);
		
		apples = new ArrayList<>(apples);
		
		apples.sort(Comparator.comparing(Apple::getWeight));

//		System.out.println(apples);
		
		List<Apple> appleList = apples.stream()
				.filter(apple -> apple.getWeight() > 200)
				.collect(toList());
	}
	
	
	@Test
	public void mapDefault() throws Exception {
		Map<String, Integer> nameToSalary = ImmutableMap.of("Ivan", 200);
		
		Integer salary = nameToSalary.getOrDefault("Stepan", 0);
	}
	
	
	@Test
	public void mapToColor() throws Exception {
		List<String> colors = apples.stream().map(Apple::getColor).collect(toList());
		
		assertThat(colors, hasSize(7));
		assertThat(colors.get(0), is("RED"));
	}
	
	@Test
	public void printApples() throws Exception {
		apples.forEach(System.out::println);
	}
	
	@Test
	public void findExactApple() throws Exception {
		Apple apple = new Apple("RED", 100);

//		apples.stream()
		
	}
	
	@Test
	public void executionFlow() throws Exception {
		apples.stream()
				.filter(apple -> apple.getWeight() > 59)
				.map(Apple::getColor)
				.peek(System.out::println)
				.limit(3)
				.collect(toList());
	}
	
	@Test
	public void findFirst() throws Exception {
		apples.stream()
				.filter(apple -> apple.getWeight() > 59)
				.findFirst()
				.map(Apple::getColor)
				.ifPresent(System.out::println);
	}
	
	@Test
	public void intStream() throws Exception {
		IntSummaryStatistics summaryStatistics = apples.stream()
				.mapToInt(Apple::getWeight)
				.summaryStatistics();
		
		System.out.println(summaryStatistics);
	}
	
	@Test
	public void checkWeight() throws Exception {
		Map<Integer, Apple> weightToApple =
				apples.stream().collect(toMap(Apple::getWeight, identity()));
		
		assertThat(weightToApple.get(100), is(apples.get(0)));

//		weightToApple.get(100);
	}
	
	@Test
	public void groupingBy() throws Exception {
		Map<String, List<Apple>> map = apples.stream()
				.distinct()
//				.flatMap()
				.collect(Collectors.groupingBy(Apple::getColor, toList()));
		
		System.out.println(map.get("RED"));
	}
	
	@Test
	public void flatMap() throws Exception {
		apples.stream().flatMap(apple -> apple.worms.stream()).forEach(System.out::println);
	}
}