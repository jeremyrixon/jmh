package org.rixon;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

	final int N = 1000;
	double[] a = new double[N];
	double[] b = new double[N];
	double[] results = new double[N];
	InlineTest it = new InlineTest();

	@Setup
	public void setup() {
		Random r = new Random();
		for (int i = 0; i < N; i++) {
			a[i] = r.nextDouble();
			b[i] = r.nextDouble();
		}
		it.setA(1);
		it.setB(1);
		it.setC(1);
	}

	@Benchmark
	public double test01Total() {
		double result = 0.0;
		for (int i = 0; i < N; i++) {
			result += a[i];
		}
		return result;
	}

	@Benchmark
	public double[] test02Add() {
		for (int i = 0; i < N; i++) {
			results[i] = a[i] * b[i];
		}
		return results;
	}

	@Benchmark
	public double[] test03Multiply() {
		
		// Multiply
		for (int i = 0; i < N; i++) {
			results[i] = a[i] * b[i];
		}
		return results;
	}

	@Benchmark
	public double test04DotProduct() {
		
		// Multiply and add
		double result = 0.0;
		for (int i = 0; i < N; i++) {
			result += a[i] * b[i];
		}
		return result;
	}

	@Benchmark
	public double test05DotProduct() {

		// Multiply
		for (int i = 0; i < N; i++) {
			results[i] = a[i] * b[i];
		}
		
		// Add
		double result = 0.0;
		for (int i = 0; i < N; i++) {
			result += results[i];
		}

		return result;
	}

	@Benchmark
	public double test06Fibonacci() {
		it.setC(it.getA());
		it.setA(it.getA() + it.getB());
		it.setB(it.getC());
		return it.getA();
	}

}
