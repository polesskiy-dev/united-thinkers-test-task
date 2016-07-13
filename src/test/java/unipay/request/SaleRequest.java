package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;

import java.util.Map;

/**
 * Sale request container class.
 * <p>
 * Represents sale request with appropriate entities.
 */
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
