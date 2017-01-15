abstract class A {

	public int f() {
		return 250;
	}

	public void g() {
		answer = j + f();
	}

	protected int j = 14;
	protected int k;
	protected int answer;
}

class B extends A {

	public int f() {
		h();
		return k * 2;
	}

	public void h() {
		k = i * i + super.f();
	}

	protected int i = 2;
}

class C extends A {

	public int f() {
		h();
		return k * 3;
	}

	public void h() {
		k = i * i * i + super.f();
	}

	protected int i = 3;
}

class ABC {
	public static void main(String args[]) {
		A a, a1;
		B b;
		C c;

		b = new B();
		a = b;
		a.g();

		c = new C();
		a1 = c;
		a1.g();
	}
}

// Note: In the code below, the interfaces for A2 B2, and C2
// are named as IA2, IB2 and IC2 respectively.

class ABC2 {
	public static void main(String args[]) {
		
		A a, a1;
		B b;
		C c;

		b = new B();
		a = b;
		a.g();
		
		c = new C();
		a1 = c;
		a1.g();
		
		IA2 a2, a21;
		IB2 b2;
		IC2 c2;
		
		b2 = new B2();
	        a2 = b2;
		a2.g();
		
		c2 = new C2();
		a21 = c2;
		a21.g();
		 
	}
}

interface IA2 {
	int f();

	void g();
	int getk();
	void setk(int val);
	
}

interface IB2 extends IA2 {
	
	void h();
}

interface IC2 extends IA2 {
	
	void h();
}

class A2 implements IA2 {

	public A2(IA2 t) {
		this2 = t;
	}

	public int f() {
		return 250;
	}

	public void g() {
		answer = j + this2.f();
	}

	public int getk() {
		return this.k;
	}

	public void setk(int val) {
		this.k = val;
	}

	IA2 this2;
	protected int j = 14;
	protected int k;
	protected int answer;
}

class B2 implements IB2 {
	public B2() {
		super2 = new A2(this);
	}
	public int getk() {
		return super2.getk();
	}

	public void setk(int val) {
		super2.setk(val);
	}
	public int f() {
		h();
		return getk() * 2;
	}

	public void h() {
		setk(i * i + super2.f());
	}

	public void g() {
		super2.g();
	}

	protected int i = 2;
	IA2 super2;
}
class C2 implements IC2{
	public C2(){
		super2 = new A2(this);
	}
	public int getk() {
		return super2.getk();
	}

	public void setk(int val) {
		super2.setk(val);
	}
	public int f() {
		h();
		return getk() * 3;
	}

	public void h() {
		setk( i * i * i + super2.f());
	}
	public void g() {
		super2.g();
	}
	protected int i = 3;
	IA2 super2;
}
