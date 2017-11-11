package hillelee.apple;

import java.util.function.Predicate;

public class ApplesColorPredicate implements Predicate {
	
	@Override
	public boolean test(Object o) {
		return false;
	}
	
	@Override
	public Predicate and(Predicate other) {
		return null;
	}
	
	@Override
	public Predicate negate() {
		return null;
	}
	
	@Override
	public Predicate or(Predicate other) {
		return null;
	}
}
