package com.jcs.sbs.auth;

/**
 *This class initializes accessKey and secretKey
 */
public class BasicJCSCredentials  implements JCSCredentials{
	private String accessKey;
	private String secretKey;
	
	/**
	 * constructor to initialize accessKey and secretKey
	 * 
	 * @param accessKey Unique JCS Access Key of the account
	 * @param secretKey JCS Secret Key of the account
	 */
	public BasicJCSCredentials(String accessKey, String secretKey){
		if (accessKey == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        }
        if (secretKey == null) {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        this.accessKey = accessKey;
        this.secretKey = secretKey;
	}
	
	@Override
	public String getJCSAccessKey() {
		return this.accessKey;
	}

	@Override
	public String getJCSSecretKey() {
		return this.secretKey;
	}

}
