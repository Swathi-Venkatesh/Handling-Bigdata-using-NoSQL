/*
 * @Author
 * Ashok Kumar K
 * AKLC
 * celestialcluster@gmail.com | 9742024066  
 */
package com.skit.mongosight.callback;

import com.skit.mongosight.domain.Host;

public interface ConnectCallback {

	public void onRequestConnect(Host host);
	
}
