/*
 * @Author
 * Ashok Kumar K
 * AKLC
 * celestialcluster@gmail.com | 9742024066  
 */
package com.skit.mongosight.domain;

import java.util.ArrayList;
import java.util.List;

public class Connections {

	private List<Host> hosts = new ArrayList<Host>();
	
	public Connections() {
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

}
