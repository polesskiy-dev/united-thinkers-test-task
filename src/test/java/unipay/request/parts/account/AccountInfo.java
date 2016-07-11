package unipay.request.parts.account;

/**
 * Account info
 *
 * @see <a href="https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Account_Information"></a>
 */
public class AccountInfo {
    private String accountType;
//    private String scs;

    public AccountInfo(String accountType) {
        this.accountType = accountType;
//        this.scs = scs;
    }

    public String getAccountType() {
        return accountType;
    }

//    public String getScs() {
//        return scs;
//    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

//    public void setScs(String scs) {
//        this.scs = scs;
//    }
}
