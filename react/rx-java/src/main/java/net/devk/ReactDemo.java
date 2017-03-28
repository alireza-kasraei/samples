package net.devk;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class ReactDemo {

	public static void main(String[] args) {
		// code1
		Observable.just("Hello").subscribe(System.out::println);
		// code4
		Observable.just("Hello", "World").subscribe(System.out::println);
		// code6
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
		Observable.just(words).subscribe(System.out::println);
		// code7
		Observable.fromIterable(words).subscribe(System.out::println);
		// code8
		Observable.range(0, 5).subscribe(System.out::println);

		// code9
		Observable.fromIterable(words).zipWith(Observable.range(1, Integer.MAX_VALUE),
				(string, count) -> String.format(" %2d. %s", count, string)).subscribe(System.out::println);
		// code10
		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split("")))
				.zipWith(Observable.range(1, Integer.MAX_VALUE),
						(string, count) -> String.format(" %2d. %s", count, string))
				.subscribe(System.out::println);
		// code11
		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split(""))).distinct()
				.zipWith(Observable.range(1, Integer.MAX_VALUE),
						(string, count) -> String.format(" %2d. %s", count, string))
				.subscribe(System.out::println);
		// code12
		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split(""))).distinct().sorted()
				.zipWith(Observable.range(1, Integer.MAX_VALUE),
						(string, count) -> String.format(" %2d. %s", count, string))
				.subscribe(System.out::println);

	}

}
