/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

public class Calculator {
	public static int result = 0;

	private int x;
	private int y;

	public Calculator() {
	}

	Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void clear(){
		result =0;
		System.out.println("当前结果已清零！");
	}
	public synchronized static int synCount(int x) throws InterruptedException {
		int i= result;
		Thread.sleep(1000);
		result = i + x;
		return result;
	}
	public static int count(int x) throws InterruptedException {
		int i= result;
//		Thread.sleep(1000);
		result = i + x;
		return result;
	}
	//自减
	public int sub(int x) throws InterruptedException {
		int i= result;
		Thread.sleep(1000);
		result = i - x;
		return result;
	}
	public int add() {
		return this.x + this.y;
	}

	public int add(int x) throws InterruptedException {
		result +=x;
		return result;
	}

	public int add(int a, int b) {
		return a + b;
	}

	public double add(double a, double b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public double sub(double a, double b) {
		return a - b;
	}
	public int mul(int a, int b) {
		return a * b;
	}

	public double mul(double a, double b) {
		return a * b;
	}

	public int div(int a, int b) {
		return a / b;
	}

	public double div(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("Divide by zero");
		} else {
			return a / b;
		}
	}
}
