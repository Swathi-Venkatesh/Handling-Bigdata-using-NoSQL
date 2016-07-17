/*
 * @Author
 * Ashok Kumar K
 * AKLC
 * celestialcluster@gmail.com | 9742024066  
 */
package com.skit.mongosight.callback;

import com.skit.mongosight.domain.Collection;
import com.skit.mongosight.domain.Host;

public interface NavigationCallback {

	public void onOpenQueryWindowRequested(Collection collection);
	
	public void onFindAllDocumentsRequested(Collection collection);

    public void onDisconnectFromHostRequested(Host host);

}
