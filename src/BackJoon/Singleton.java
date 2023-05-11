package BackJoon;

public class Singleton {
	private Singleton() {
	}

	private static class LazyHolder {
		public static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
