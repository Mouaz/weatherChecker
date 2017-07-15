/**
 * @author mohamed265
 * Created On : Mar 25, 2017 11:54:27 AM
 */
package com.mohamed265.weatherchecker.statics;

import com.mohamed265.weatherchecker.util.jsf.annotation.SpringApplicationScoped;

/**
 * @author mohamed265
 *
 */
@SpringApplicationScoped
public class FetchingStatics {

	public static boolean isFetching = false;

	public static boolean isFetchingSuccess = false;
	
	public static boolean isFetchingUncertain = true;

	public static boolean accessDB(){
		return !isFetching && isFetchingSuccess;
	}

}
// Success