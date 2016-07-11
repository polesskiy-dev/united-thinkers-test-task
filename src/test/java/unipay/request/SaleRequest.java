package unipay.request;

import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountInfo;
import java.util.Map;

public abstract class SaleRequest {
    protected AuthInfo authInfo;
    protected AccountInfo accountInfo;
    protected TransactionInfo transactionInfo;

    public SaleRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo) {
        this.authInfo = authInfo;
        this.accountInfo = accountInfo;
        this.transactionInfo = transactionInfo;
    }

    /**
     * Construct K-V map from all aggregated entities
     *
     * @return map - all entities as map of key-value
     * @throws IllegalAccessException
     */
    public abstract Map toMap() throws IllegalAccessException;

    public String toGetParamsString() throws IllegalAccessException {
        StringBuilder getParams = new StringBuilder();
        this.toMap().forEach((k, v) -> getParams.append(k + "=" + v + "&"));

        //remove last "&"
        if (getParams.length() > 0) getParams.setLength(getParams.length() - 1);

        return getParams.toString().replace(" ", "+");
    }
}
