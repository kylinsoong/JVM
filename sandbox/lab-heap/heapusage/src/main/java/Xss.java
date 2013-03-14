

public class Xss {

	public static void main(String[] args) {
				
		for(int i = 0 ; ; i ++) {
			final int t = i;
			new Thread(new Runnable(){

				public void run() {

					System.out.println("create thread " + t);
					
					try {
						Thread.currentThread().sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) {
						Thread.interrupted();
					}
					
				}}).start();
		}
	}

}
