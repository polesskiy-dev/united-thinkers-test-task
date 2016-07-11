package response_code_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleRequest;
import unipay.request.ResponseCodeWithAccountNumberRequest;
import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountInfo;
import unipay.request.parts.account.AccountNumber;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ResponseCodeSaleRequestA01Test {
    private static final String EXPECTED_RESPONSE_CODE_STRING = "responseCode=A01";

    private int amount;
    private SaleRequest saleRequest;

    public ResponseCodeSaleRequestA01Test(int amount) {
        this.amount = amount;
        this.saleRequest = new ResponseCodeWithAccountNumberRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422")
        );
    }


    @Test
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);


            System.out.printf("Send sale request with accountNumber and amount %d to URL:\r\n%s\r\nResponse: %s\r\n", this.amount, REQUEST_URL, response);
            assertTrue("Expect " + EXPECTED_RESPONSE_CODE_STRING, response.contains(EXPECTED_RESPONSE_CODE_STRING));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {500}, {4000}, {6999},
        });
    }
}