import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MAC {
	
	public static String byteToHexString(byte[] by) {
		StringBuffer SB = new StringBuffer();
		int i = 0;
		while (i < by.length) {
			int k = by[i];
			int j = k;
			if (k < 0) {
				j = k + 256;
			}
			if (j < 16) {
				SB.append("0");
			}
			SB.append(Integer.toHexString(j));
			i += 1;
		}
		return SB.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		SecretKey key = new SecretKeySpec("1234567890".getBytes(), "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		mac.update("a12345678".getBytes());
		byte[] res = mac.doFinal();
		System.out.println( byteToHexString(res) );
		
	}
	
}
