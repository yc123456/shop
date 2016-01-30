package shop;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcacheTest {
	public static void main(String[] args) {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses("localhost:11211"));
		 
		try {
			MemcachedClient client = builder.build();
			client.flushAll();
			client.shutdown();
		} catch (Exception e) {
			
		}
	}
}