package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

public class SaleAVSRequestWithAccountData extends SaleRequest {
    private AccountData accountData;
    private BillingAddressInfo billingAddressInfo;

    public SaleAVSRequestWithAccountData(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountData accountData, BillingAddressInfo billingAddressInfo) {
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
