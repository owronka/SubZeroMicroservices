package com.axxessio.axx2cld.registration.facade.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTO extends GenericTO {

	private long accountId;

    private String accountName;
    private String pwdHash;
    private String pwdSalt;

    @JsonCreator
    public AccountTO(@JsonProperty("accountId") long newAccountId, @JsonProperty("accountName") String newAccountName, @JsonProperty("pwdHash") String newPwdHash, @JsonProperty("pwdSalt") String newPwdSalt) {
		super();
		this.accountId = newAccountId;
		this.accountName = newAccountName;
		this.pwdHash = newPwdHash;
		this.pwdSalt = newPwdSalt;
	}
	
    public AccountTO(String newAccountName, String newPwdHash, String newPwdSalt) {
		super();
		this.accountName = newAccountName;
		this.pwdHash = newPwdHash;
		this.pwdSalt = newPwdSalt;
	}
	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long newAccountId) {
		this.accountId = newAccountId;
	}

    public String getAccountName() {
		return accountName;
	}
	
    public void setAccountName(String newAccountName) {
		this.accountName = newAccountName;
	}
	
    public String getPwdHash() {
		return pwdHash;
	}
	
    public void setPwdHash(String newPwdHash) {
		this.pwdHash = newPwdHash;
	}

    public String getPwdSalt() {
		return pwdSalt;
	}
	
    public void setPwdSalt(String newPwdSalt) {
		this.pwdSalt = newPwdSalt;
	}
}
  