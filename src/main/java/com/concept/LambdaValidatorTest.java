package com.concept;



@FunctionalInterface
interface Validator<T> {
    boolean validate(T t);
    default Validator<T> and(Validator<T> other) {
    	System.out.println("------ and -----");
        return (T t) -> this.validate(t) && other.validate(t);
    }
}


class SimpleValidator<T> implements Validator<T> {
    private Validator<T> val;

    public SimpleValidator(Validator<T> validator) {
        this.val = validator;
    }

    @Override
    public boolean validate(T t) {
        return val.validate(t);
    }

    public Validator<T> and(final Validator<T> other) {
        return new Validator<T>() {
            @Override
            public boolean validate(T t) {
                return SimpleValidator.this.validate(t) && other.validate(t);
            }
        };
    }
}


class PositiveNumberValidator implements Validator<Integer> {
    @Override
    public boolean validate(Integer number) {
        return number > 0;
    }
}


class EvenNumberValidator implements Validator<Integer> {
    @Override
    public boolean validate(Integer number) {
        return number % 2 == 0;
    }
}

public class LambdaValidatorTest {

	public static void main(String[] args) {
		 Validator<Integer> positiveValidator = new SimpleValidator<>(new PositiveNumberValidator());
	        Validator<Integer> evenValidator = new SimpleValidator<>(new EvenNumberValidator());

	        Validator<Integer> positiveAndEvenValidator = ((SimpleValidator<Integer>) positiveValidator).and(evenValidator);

	        System.out.println(positiveAndEvenValidator.validate(4)); // true
	        System.out.println(positiveAndEvenValidator.validate(3)); // false
	        System.out.println(positiveAndEvenValidator.validate(-2)); // false

	}

}
