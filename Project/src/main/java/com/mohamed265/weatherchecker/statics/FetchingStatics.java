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

	private FetchingStatics(){
		throw new AssertionError();
	}
	
	public static boolean isFetching = false;

	public static boolean isFetchingSuccess = false;
	
	public static boolean isFetchingUncertain = true;

	public static boolean accessDB(){
		return !isFetching && isFetchingSuccess;
	}

	public static boolean isFetching() {
		return isFetching;
	}

	public static void setFetching(boolean isFetching) {
		FetchingStatics.isFetching = isFetching;
	}

	public static boolean isFetchingSuccess() {
		return isFetchingSuccess;
	}

	public static void setFetchingSuccess(boolean isFetchingSuccess) {
		FetchingStatics.isFetchingSuccess = isFetchingSuccess;
	}

	public static boolean isFetchingUncertain() {
		return isFetchingUncertain;
	}

	public static void setFetchingUncertain(boolean isFetchingUncertain) {
		FetchingStatics.isFetchingUncertain = isFetchingUncertain;
	}

}
// Success