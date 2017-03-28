package net.devk;

import io.reactivex.Observable;

public class ReactDemo {

	public static void main(String[] args) {
		Observable.just("Hello").subscribe(System.out::println);
	}

}
