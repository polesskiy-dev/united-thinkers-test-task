package avs_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.AVSRequestAccountNumber;
import unipay.request.SaleRequest;
import unipay.request.parts.AuthInfo;
import unipay.request.parts.BillingAddressInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountInfo;
import unipay.request.parts.account.AccountNumber;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AVSRequest46Test {
    private static final String EXPECTED_RESPONSE_CODE_STRING = "avsResponseCode=46";

    private String zipCode;
    private SaleRequest saleRequest;

    public AVSRequest46Test(String zipCode) {
        this.zipCode = zipCode;
        this.saleRequest = new AVSRequestAccountNumber(
                new AuthInfo("account-verification", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(5000, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422"),
                new BillingAddressInfo(this.zipCode)
        );
    }


    @Test
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);


            System.out.printf("Send AVS request with accountNumber and zipCode %s to URL:\r\n%s\r\nResponse: %s\r\n", this.zipCode, REQUEST_URL, response);
            assertTrue("Expect " + EXPECTED_RESPONSE_CODE_STRING, response.contains(EXPECTED_RESPONSE_CODE_STRING));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"22222"}
        });
    }
}
