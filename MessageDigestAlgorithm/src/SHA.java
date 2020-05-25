import java.security.MessageDigest;

public class SHA {
	
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
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update("a12345678".getBytes());
		byte[] res = md.digest();
		System.out.println( byteToHexString(res) );
		
	}
}
