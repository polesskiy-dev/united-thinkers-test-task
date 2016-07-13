package unipay.request;

import unipay.request.parts.AuthInfo;
import unipay.request.parts.BillingAddressInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountData;
import unipay.request.parts.account.AccountInfo;
import unipay.request.parts.account.AccountNumber;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

public class AVSRequestWithAccountDataRequest extends SaleRequest {
    private AccountData accountData;
    private BillingAddressInfo billingAddressInfo;

    public AVSRequestWithAccountDataRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountData accountData, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountData = accountData;
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
