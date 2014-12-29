package com.bint.exception;

import org.junit.Test;

public class NotDealtExceptionTest {
	@Test
	public void test(){
		try {
			throw new NotDealtException();
		} catch (NotDealtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
