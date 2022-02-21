package com.test;

import java.util.HashMap;
import java.util.Random;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. 
 * There is no restriction on how your encode/decode algorithm should work. 
 * You just need to ensure that a URL can be encoded to a tiny URL and 
 * the tiny URL can be decoded to the original URL.
 * 
 * 这种，用hashMap实现，感觉没啥意义啊
 * 
 * @author yline
 */
public class SolutionA
{
	private Random random = new Random();
    private ShortPlugin shortPlugin = new ShortPlugin();
    
    private HashMap<String, String> cacheMap = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	long value = random.nextInt(Integer.MAX_VALUE);
    	value += Integer.MAX_VALUE;
    	
    	String shortUrl = shortPlugin.long2Str(value);
    	cacheMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String longUrl = cacheMap.get(shortUrl);
    	return longUrl;
    }
    
    private static class ShortPlugin {
    	private static final String SOURCE = 
    			"1234567890abcdefghijklmnopqrsduvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	
    	public String long2Str(long value) {
    		StringBuilder sBuilder = new StringBuilder();
    		while (value > 0) {
				int index = (int) (value % SOURCE.length());
				value /= SOURCE.length();
				
				sBuilder.append(SOURCE.charAt(index));
    		}
    		
    		return sBuilder.toString();
    	}
    	
    	public long str2Long(String str) {
    		long result = 0;
    		long multiple = 1;
    		for (int i = 0; i < str.length(); i++) {
				int index = SOURCE.indexOf(str.charAt(i));
				if (-1 == index) {
					return -1;
				}
				
				result += (index * multiple);
				multiple *= SOURCE.length();
			}
    		return result;
    	}
    }
}
