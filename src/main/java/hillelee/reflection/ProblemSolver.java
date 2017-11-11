package hillelee.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProblemSolver {
	public String solve(Object problem) {
		Class<?> aClass = problem.getClass();
		Method[] methods = aClass.getMethods();
		
		for (Method method : methods) {
			if (method.isAnnotationPresent(CorrectAnswer.class)) {
				try {
					return (String) method.invoke(problem);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		throw new RuntimeException("There is no correct answer annotation");
	}
}
