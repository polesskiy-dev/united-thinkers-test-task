package unipay.request.component_entities;

/**
 * Transaction Information
 *
 * @see <a href="https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Transaction_Information"></a>
 */
public class TransactionInfo {
    private int amount;
    private String transactionIndustryType;
//    private String transactionOriginCode;

    public TransactionInfo(int amount, String transactionIndustryType) {
        this.amount = amount;
        this.transactionIndustryType = transactionIndustryType;
//        this.transactionOriginCode = transactionOriginCode;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionIndustryType() {
        return transactionIndustryType;
    }

//    public String getTransactionOriginCode() {
//        return transactionOriginCode;
//    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionIndustryType(String transactionIndustryType) {
        this.transactionIndustryType = transactionIndustryType;
    }

    public void setTransactionOriginCode(String transactionOriginCode) {
//        this.transactionOriginCode = transactionOriginCode;
    }
}
