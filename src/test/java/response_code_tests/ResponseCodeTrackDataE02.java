package response_code_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.ResponseCodeWithAccountDataRequest;
import unipay.request.SaleRequest;
import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountData;
import unipay.request.parts.account.AccountInfo;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ResponseCodeTrackDataE02 {
    private static final String EXPECTED_RESPONSE_CODE_STRING = "responseCode=E02";

    private int amount;
    private SaleRequest saleRequest;

    public ResponseCodeTrackDataE02(int amount) {
        this.amount = amount;
        this.saleRequest = new ResponseCodeWithAccountDataRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F")
        );
    }

    @Test
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);


            System.out.printf("Send sale request with accountNumber and amount %d to URL:\r\n%s\r\nResponse: %s\r\n", this.amount, REQUEST_URL, response);
            assertTrue("Expect "+EXPECTED_RESPONSE_CODE_STRING, response.contains(EXPECTED_RESPONSE_CODE_STRING));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {13000}, {13500}, {13999},
        });
    }
}
