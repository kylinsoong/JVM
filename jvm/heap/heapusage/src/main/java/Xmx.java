import java.util.HashMap;
import java.util.Map;


public class Xmx {

	public static void main(String[] args) {
		
		new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("heap-swallow-thread");
				
				long defValue = System.currentTimeMillis();

				Map<String, Object> map = new HashMap<String, Object>();
				
				for(int i = 0 ; ; i++) {
					System.out.println(i + " - " + (System.currentTimeMillis() - defValue) + ", maxMemory: " + Runtime.getRuntime().maxMemory() + ", totalMemory: " + Runtime.getRuntime().totalMemory() + ", freeMemory: " + Runtime.getRuntime().freeMemory());
					map.put("key-" + i, new byte[1024 * 1000 ]);
				}
			}
		}).start();
		
		
	}

}
