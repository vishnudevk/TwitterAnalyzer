package com.vish.twitterAnalyst.model.responseModel;

/**This is a master class for responses objects from server
 * it have the possible general fields like error message 
 * response code etc
 * 
 * @author vishnudev
 */
public class MasterResponseModel {

	private String errorMessage;
	private int responseCode;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	
}
