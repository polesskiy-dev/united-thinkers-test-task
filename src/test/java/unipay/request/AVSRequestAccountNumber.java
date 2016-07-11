package unipay.request;

import unipay.request.parts.AuthInfo;
import unipay.request.parts.BillingAddressInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountInfo;
import unipay.request.parts.account.AccountNumber;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

public class AVSRequestAccountNumber extends SaleRequest {
    private AccountNumber accountNumber;
    private BillingAddressInfo billingAddressInfo;

    public AVSRequestAccountNumber(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountNumber accountNumber, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountNumber = accountNumber;
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
