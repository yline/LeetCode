package com.test;

/**
 * https://leetcode.com/problems/design-browser-history
 * 
Input:
[
"BrowserHistory",	// ["leetcode.com"],		null
"visit",			// ["google.com"],			null
"visit",			// ["facebook.com"],		null
"visit",			// ["youtube.com"],			null

"back",				// [1],						"facebook.com"
"back",				// [1],						"google.com"
"forward",			// [1],						"facebook.com"
"visit",			// ["linkedin.com"],		null
"forward",			// [2],						"linkedin.com"
"back",				// [2],						"google.com"
"back"]				// [7]						"leetcode.com"

 * @author yline
 *
 * 解决方案：双向链表就可以了
 *
 */
public class BrowserHistory {
	private Node current = null;
	
	public BrowserHistory(String homepage) {
		current = new Node(homepage);
	}

	public void visit(String url) {
		current.next = new Node(url);
		current.next.pre = current;
		
		current = current.next;
	}

	public String back(int steps) {
		Node temp = current;
		for (int i = 0; i < steps; i++) {
			if (null == temp.pre) {
				break;
			}
			temp = temp.pre;
		}
		
		current = temp;
		return temp.url;
	}

	public String forward(int steps) {
		Node temp = current;
		for (int i = 0; i < steps; i++) {
			if (null == temp.next) {
				break;
			}
			temp = temp.next;
		}
		
		current = temp;
		return temp.url;
	}
	
	private static class Node{
		private Node pre;
		private Node next;
		private String url;
		
		private Node(String url) {
			this.url = url;
		}
	}
}















