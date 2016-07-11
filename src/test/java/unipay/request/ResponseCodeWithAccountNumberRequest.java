package unipay.request;

import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountInfo;
import unipay.request.parts.account.AccountNumber;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

public class ResponseCodeWithAccountNumberRequest extends SaleRequest {
    private AccountNumber accountNumber;

    public ResponseCodeWithAccountNumberRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountNumber accountNumber) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountNumber = accountNumber;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));

        return map;
    }
}

