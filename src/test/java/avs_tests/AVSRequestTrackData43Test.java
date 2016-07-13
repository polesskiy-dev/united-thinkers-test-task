package avs_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleAVSRequestWithAccountData;
import unipay.request.SaleRequest;
import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AVSRequestTrackData43Test {
    private static final String EXPECTED_RESPONSE_CODE_STRING = "avsResponseCode=43";

    private String zipCode;
    private SaleRequest saleRequest;

    public AVSRequestTrackData43Test(String zipCode) {
        this.zipCode = zipCode;
        this.saleRequest = new SaleAVSRequestWithAccountData(
                new AuthInfo("account-verification", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(5000, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F"),
                new BillingAddressInfo(this.zipCode)
        );
    }


    @Test
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            System.out.printf("Send AVS request with accountData and zipCode %s to URL:\r\n%s\r\nResponse: %s\r\n", this.zipCode, REQUEST_URL, response);
            assertTrue("Expect " + EXPECTED_RESPONSE_CODE_STRING, response.contains(EXPECTED_RESPONSE_CODE_STRING));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"33333"}
        });
    }
}
