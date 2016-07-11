package unipay.request;

import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountData;
import unipay.request.parts.account.AccountInfo;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by polesskiy on 12.07.16.
 */
public class ResponseCodeWithAccountDataRequest extends SaleRequest {
    private AccountData accountData;

    public ResponseCodeWithAccountDataRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountData accountData) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountData = accountData;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));

        return map;
    }
}
